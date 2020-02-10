package jp.co.tis.climate.albumweb.domain.model.member;

import lombok.Data;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

import java.io.Serializable;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
@Table(name = "PROFILE")
@Data
public class Profile implements Serializable {

    @Id
    private String employeeId;

    private String profileImageFilename;

    private String lastName;

    private String firstName;

    private String joiningYear;

    private String sex;

    private String bloodType;

    private String team;

    private String customer;

    private String project;

    private String privateSentence;

    private String comment;
}