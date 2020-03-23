package jp.co.tis.climate.albumweb.domain;

import org.seasar.doma.Domain;

@Domain(valueType = String.class)
public class Role {

    private final String value;

    public Role(String value) { this.value = value; }

    public String getValue() { return value; }
}
