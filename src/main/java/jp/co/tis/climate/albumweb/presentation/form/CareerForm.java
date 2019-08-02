package jp.co.tis.climate.albumweb.presentation.form;

import jp.co.tis.climate.albumweb.presentation.validation.BeforeYear;
import jp.co.tis.climate.albumweb.presentation.validation.Month;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
public class CareerForm {
    @NotEmpty
    @Pattern(regexp = "[1-9][0-9]?")
    String careerId;

    @BeforeYear(message = "{jp.co.tis.climate.albumweb.presentation.form.year.message}")
    String year;

    @Month
    String month;

    @Size(max = 50, message = "{jp.co.tis.climate.albumweb.presentation.form.event.message}")
    String event;
}
