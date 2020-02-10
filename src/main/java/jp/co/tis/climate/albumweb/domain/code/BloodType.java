package jp.co.tis.climate.albumweb.domain.code;

import org.seasar.doma.Domain;

@Domain(valueType = String.class, factoryMethod = "of")
public enum BloodType {
    A型("0"),
    B型("1"),
    O型("2"),
    AB型("3");

    private String code;

    private BloodType(String code) {
        this.code = code;
    }

    public static BloodType of(String id) {
        if (id == null || "".equals(id)) {
            return null;
        }
        for (BloodType bloodType : BloodType.values()) {
            if (bloodType.code.equals(id)) {
                return bloodType;
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
