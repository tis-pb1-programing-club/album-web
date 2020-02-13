package jp.co.tis.climate.albumweb.domain.code;

import org.seasar.doma.Domain;

@Domain(valueType = String.class, factoryMethod = "of")
public enum Gender {
    男性("0"),
    女性("1"),
    無回答("2");

    private String code;

    private Gender(String code) {
        this.code = code;
    }

    public static Gender of(String id) {
        if (id == null || "".equals(id)) {
            return null;
        }
        for (Gender gender : Gender.values()) {
            if (gender.code.equals(id)) {
                return gender;
            }
        }
        throw new IllegalArgumentException(id);
    }

    public String getValue() {
        return code;
    }

    public String getLabel() {
        return this.name();
    }
}
