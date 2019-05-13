package jp.co.tis.climate.albumweb.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.List;

@Setter
@Getter
public class UserForm {
    @NotEmpty
    @Pattern(regexp="[kK0-9][0-9]{5}")
    private String userId;

    @NotNull
    @Size(min=1,max=50)
    private String profileImageFilename;
    
    @NotEmpty
    @Size(min=1,max=20)
    private String lastName;

    @NotEmpty
    @Size(min=1,max=20)
    private String firstName;

    @Size(min=1,max=2)
    private String yearly;

    @NotEmpty
    private String sex;

    private String bloodType;

    private String team;

    private String customer;

    private String project;

    private String privateSentence;

    private String comment;

    @Valid
    private List<CareerForm> histories;
}
