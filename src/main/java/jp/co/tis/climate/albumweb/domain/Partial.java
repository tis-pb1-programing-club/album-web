package jp.co.tis.climate.albumweb.domain;

import org.seasar.doma.Domain;

import java.util.Optional;

/**
 * 部分一致を表すドメイン
 *
 * @param <DOMAIN> 部分一致対象のドメイン
 */
@Domain(valueType = String.class, factoryMethod = "of")
public class Partial<DOMAIN> {

    private final String value;

    private Partial(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static <T> Partial<T> of(String value) {
        return Optional.ofNullable(value).map(x -> new Partial<T>(x)).orElse(null);
    }
}
