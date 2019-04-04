package jp.co.tis.climate.albumweb.model;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
@Table(name="USER")
@Data
public class User implements Serializable {

    @Id
    @NotEmpty
    private String userId;

    private String lastName;

    private String firstName;

    private String yearly;

    private String sex;

    private String bloodType;

    private String team;

    private String customer;

    private String project;

    private String privateSentence;

    private String comment;
}
