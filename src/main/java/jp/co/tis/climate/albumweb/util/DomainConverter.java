package jp.co.tis.climate.albumweb.util;

import org.apache.commons.beanutils.Converter;
import org.seasar.doma.Domain;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Stirng -> Domain
 * Domain <- String
 * の変換をする。
 */
public class DomainConverter implements Converter {

    @Override
    public <T> T convert(Class<T> aClass, Object value) {
        if (value == null) {
            return null;
        }

        if (aClass == String.class && isDomain(value.getClass())) { // Domain -> String
            if (getDomainValueType(value.getClass()) == String.class) {
                return (T) getStringValue(value);
            }
        } else if (isDomain(aClass) && value instanceof String) { // String -> Domain
            if (getDomainValueType(aClass) == String.class) {
                if (hasFactoryMethod(aClass)) {
                    return createFromFactory(aClass, value);
                } else {
                    return createFromConstructor(aClass, value);
                }
            }
        }
        return null;
    }

    private boolean isDomain(Class aClass) {
        Annotation[] annotations = aClass.getAnnotations();

        for(Annotation annotation : annotations){
            if(annotation instanceof Domain){
                return true;
            }
        }
        return false;
    }

    private Class getDomainValueType(Class aClass) {
        Annotation[] annotations = aClass.getAnnotations();

        for(Annotation annotation : annotations){
            if(annotation instanceof Domain){
                return ((Domain) annotation).valueType();
            }
        }
        throw new IllegalArgumentException(aClass.getName() + " is not domain class.");
    }

    private boolean hasFactoryMethod(Class domain) {
        Annotation[] annotations = domain.getAnnotations();

        for(Annotation annotation : annotations){
            if(annotation instanceof Domain){
                if ("new".equals(((Domain) annotation).factoryMethod())) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        throw new IllegalArgumentException(domain.getName() + " is not domain class.");
    }

    private String getStringValue(Object value) {
        String str = null;
        try {
            str = (String) value.getClass().getMethod("getValue").invoke(value);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return str;
    }

    private <T> T createFromConstructor(Class<T> aClass, Object value) {
        T returnVal = null;
        try {
            Constructor cons = aClass.getConstructor(String.class);
            returnVal = (T) cons.newInstance(value);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return returnVal;
    }

    private <T> T createFromFactory(Class<T> domain, Object value) {
        Annotation[] annotations = domain.getAnnotations();
        String factoryMethod = null;
        for(Annotation annotation : annotations){
            if(annotation instanceof Domain){
                factoryMethod = ((Domain) annotation).factoryMethod();
            }
        }

        T returnVal = null;
        try {
            Method method = domain.getDeclaredMethod(factoryMethod, String.class);
            returnVal = (T) method.invoke(null, value);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return returnVal;
    }
}
