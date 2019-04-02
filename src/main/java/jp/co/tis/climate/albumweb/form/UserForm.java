package jp.co.tis.climate.albumweb.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Setter
@Getter
public class UserForm {
    @NotEmpty
    private Integer userId;

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

    @Valid
    private List<CareerForm> histories;
}
