package jp.co.tis.climate.albumweb;

import jp.co.tis.climate.albumweb.util.DomainConverter;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "fuudoapp.album")
@Getter
@Setter
public class ApplicationConfig {
    private String imageDirectory;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public BeanUtilsBean beanUtilsBean() throws ClassNotFoundException, IOException, URISyntaxException {
        BeanUtilsBean beanUtilsBean = new BeanUtilsBean(
                new ConvertUtilsBean(),
                BeanUtilsBean.getInstance().getPropertyUtils()
        );
        DomainConverter domainConverter = new DomainConverter();
        beanUtilsBean.getConvertUtils().register(domainConverter, String.class);

        List<Class<?>> list = getClasses("jp.co.tis.climate.albumweb.domain");
        for (Class<?> domain : list) {
            beanUtilsBean.getConvertUtils().register(domainConverter, domain);
        }

        list = getClasses("jp.co.tis.climate.albumweb.domain.code");
        for (Class<?> domain : list) {
            beanUtilsBean.getConvertUtils().register(domainConverter, domain);
        }

        return beanUtilsBean;
    }

    /**
     * パッケージ名を文字列で取得し、パッケージ直下のクラスをリストに詰めて返します。
     *
     * @param packageName パッケージ名
     * @return クラスのリスト
     * @throws IOException
     * @throws URISyntaxException
     * @throws ClassNotFoundException
     */
    private static List<Class<?>> getClasses(String packageName)
            throws IOException, URISyntaxException, ClassNotFoundException {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> e = cl.getResources(packageName.replace(".", "/"));

        List<Class<?>> classes = new ArrayList<>();
        for (; e.hasMoreElements();) {
            URL url = e.nextElement();
            File dir = new File(url.getPath());
            for (String path : dir.list()) {

                // ".class"で終わり、かつ自動生成でないファイルのみ返却用のリストに追加
                if (path.endsWith(".class")) {
                    Class aClass = Class.forName(packageName + "." + path.substring(0, path.length() - 6));
                    if (!aClass.getSimpleName().startsWith("_")) {
                        classes.add(aClass);
                    }
                }
            }
        }
        return classes;
    }

}
