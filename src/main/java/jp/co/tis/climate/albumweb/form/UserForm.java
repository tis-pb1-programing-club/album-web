package jp.co.tis.climate.albumweb.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.List;

@Setter
@Getter
public class UserForm {
    @NotEmpty
    @Pattern(regexp="[kK0-9][0-9]{5}")
    private String userId;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String firstName;

    @NotEmpty
    @Size(min=1,max=2)
    private String yearly;

    @NotEmpty
    private String sex;

    @NotEmpty
    private String bloodType;

    @NotEmpty
    private String team;

    @NotEmpty
    private String customer;

    @NotEmpty
    private String project;

    private String privateSentence;

    @NotEmpty
    private String comment;

    @Valid
    private List<CareerForm> histories;
}
