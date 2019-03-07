package jp.co.tis.climate.albumweb.model;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

import java.io.Serializable;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
@Table(name="EMPLOYEE_ALBUM")
@Data
public class EmployeeAlbum implements Serializable {

    @Id
    private Integer employeeId;

    private String familyName;

    private String personalName;

    private Byte yearly;

    private Byte bloodType;

    private String team;

    private String customer;

    private String project;

    private String privateSentence;

    private String comment;
}
