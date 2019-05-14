package jp.co.tis.climate.albumweb.model;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
@Table(name="PROFILE")
@Data
public class Profile implements Serializable {

    @Id
    @NotEmpty
    private String employeeId;

    @NotNull
    private String profileImageFilename;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String firstName;

    private String yearly;

    @NotEmpty
    private String sex;

    private String bloodType;

    private String team;

    private String customer;

    private String project;

    private String privateSentence;

    private String comment;
}
