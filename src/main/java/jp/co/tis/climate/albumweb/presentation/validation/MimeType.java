package jp.co.tis.climate.albumweb.presentation.validation;

public enum MimeType {

    /** image/jpeg, image/jpg */
    JPEG(4, "FFD8FFDB", "FFD8FFE0", "FFD8FFE1"),
    /** image/png */
    PNG(4, "89504E47");

    private final int magicNumberLength;
    private final String[] magicNumbers;

    MimeType(int magicNumberLength, String... mimeTypes) {
        this.magicNumberLength = magicNumberLength;
        this.magicNumbers = mimeTypes;
    }

    public int getMagicNumberLength() {
        return magicNumberLength;
    }

    public String[] getMagicNumbers() {
        return magicNumbers;
    }

}
