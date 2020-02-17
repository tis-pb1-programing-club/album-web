package jp.co.tis.climate.albumweb.domain;

import org.seasar.doma.Domain;

@Domain(valueType = java.sql.Timestamp.class)
public class Timestamp {

    private final java.sql.Timestamp value;

    public Timestamp(java.sql.Timestamp value) {
        this.value = value;
    }

    public java.sql.Timestamp getValue() {
        return value;
    }
}
