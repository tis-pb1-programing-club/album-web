package jp.co.tis.climate.albumweb.domain;

import org.seasar.doma.Domain;

@Domain(valueType = byte[].class)
public class Presentation {
    private final byte[] value;

    public Presentation(byte[] value) {
        this.value = value;
    }

    public byte[] getValue() {
        return value;
    }
}
