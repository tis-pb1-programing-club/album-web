package jp.co.tis.climate.albumweb.domain.code;

import org.seasar.doma.Domain;

@Domain(valueType = String.class, factoryMethod = "of")
public enum Recruit {
    中途("0"),
    新卒("1");

    private String code;

    private Recruit(String code) {
        this.code = code;
    }

    public static Recruit of(String id) {
        if (id == null || "".equals(id)) {
            return null;
        }
        for (Recruit recruit : Recruit.values()) {
            if (recruit.code.equals(id)) {
                return recruit;
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
