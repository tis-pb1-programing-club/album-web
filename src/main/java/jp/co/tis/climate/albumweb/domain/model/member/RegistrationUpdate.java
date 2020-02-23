package jp.co.tis.climate.albumweb.domain.model.member;

import jp.co.tis.climate.albumweb.domain.EmployeeId;
import jp.co.tis.climate.albumweb.domain.Timestamp;
import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
@Data
public class RegistrationUpdate {

    private EmployeeId employeeId;

    private Timestamp updateDate;
}
