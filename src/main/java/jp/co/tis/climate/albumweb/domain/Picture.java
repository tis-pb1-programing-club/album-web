package jp.co.tis.climate.albumweb.domain;

import org.seasar.doma.Domain;

import java.sql.Blob;

@Domain(valueType = Blob.class)
public class Picture {

    private final Blob value;

    public Picture(Blob value) {
        this.value = value;
    }

    public Blob getValue() {
        return value;
    }
}
