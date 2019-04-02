package jp.co.tis.climate.albumweb.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class CareerForm {
    @NotEmpty
    Integer userId;

    @NotEmpty
    Integer careerId;

    Short year;

    Byte month;

    String event;
}
