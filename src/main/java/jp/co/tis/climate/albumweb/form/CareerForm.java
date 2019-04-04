package jp.co.tis.climate.albumweb.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Setter
@Getter
public class CareerForm {
    @NotEmpty
    @Pattern(regexp="[0-9]*")
    String careerId;

    String year;

    String month;

    String event;
}
