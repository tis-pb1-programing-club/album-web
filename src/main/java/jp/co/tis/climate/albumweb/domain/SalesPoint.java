package jp.co.tis.climate.albumweb.domain;

import org.seasar.doma.Domain;

@Domain(valueType = String.class)
public class SalesPoint {

    private final String value;

    public SalesPoint(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
