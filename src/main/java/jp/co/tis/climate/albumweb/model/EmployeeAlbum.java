package jp.co.tis.climate.albumweb.model;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name="EMPLOYEE_ALBUM")
@Data
public class EmployeeAlbum {

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
