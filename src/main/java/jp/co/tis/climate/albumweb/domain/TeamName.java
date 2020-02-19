package jp.co.tis.climate.albumweb.domain;

import org.seasar.doma.Domain;

@Domain(valueType = String.class)
public class TeamName {
    private final String value;

    public TeamName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
