package jp.co.tis.climate.albumweb.form;

import javax.validation.constraints.NotEmpty;

public class HistoryForm {
    @NotEmpty
    private Integer personalId;

    @NotEmpty
    private Integer historyId;

    private Short year;

    private Byte month;

    private String event;
}
