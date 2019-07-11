package jp.co.tis.climate.albumweb.presentation.form;

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

    // TODO: View側で、数値を選択できるようにする
    @Pattern(regexp = "(|(19|20)[0-9]{2})")
    String year;

    @Pattern(regexp = "(|(1|2|3|4|5|6|7|8|9|10|11|12))")
    String month;

    @Size(min = 0, max = 50)
    String event;
}
