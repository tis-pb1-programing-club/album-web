package jp.co.tis.climate.albumweb.domain.model.member;

import jp.co.tis.climate.albumweb.domain.*;
import jp.co.tis.climate.albumweb.domain.code.BloodType;
import jp.co.tis.climate.albumweb.domain.code.City;
import jp.co.tis.climate.albumweb.domain.code.Gender;
import jp.co.tis.climate.albumweb.domain.code.Recruit;
import lombok.Data;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

import java.io.Serializable;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
@Data
public class Profile implements Serializable {

    @Id
    private EmployeeId employeeId;

    private Picture picture;

    private Name name;

    private YearMonth hireDate;

    private Recruit recruit;

    private Gender genderId;

    private BloodType bloodTypeId;

    private SalesPoint salesPoint;

    private Hobby hobby;

    private City birthplace;

    private Presentation presentation;
}
