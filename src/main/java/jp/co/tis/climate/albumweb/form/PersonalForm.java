package jp.co.tis.climate.albumweb.form;

import jp.co.tis.climate.albumweb.model.History;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Setter
@Getter
public class PersonalForm {
    @NotEmpty
    private Integer personalId;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String firstName;

    private Byte yearly;

    private Byte sex;

    private Byte bloodType;

    private String team;

    private String customer;

    private String project;

    private String privateSentence;

    private String comment;

    private List<History> histories;
}
