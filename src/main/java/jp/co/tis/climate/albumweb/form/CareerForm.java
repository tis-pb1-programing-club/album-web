package jp.co.tis.climate.albumweb.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class CareerForm {
    @NotEmpty
    String userId;

    @NotEmpty
    String careerId;

    String year;

    String month;

    String event;
}
