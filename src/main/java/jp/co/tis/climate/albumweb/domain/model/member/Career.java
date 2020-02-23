package jp.co.tis.climate.albumweb.domain.model.member;

import jp.co.tis.climate.albumweb.domain.EmployeeId;
import jp.co.tis.climate.albumweb.domain.Project;
import jp.co.tis.climate.albumweb.domain.ProjectContent;
import jp.co.tis.climate.albumweb.domain.YearMonth;
import lombok.Data;

import org.seasar.doma.Entity;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
@Data
public class Career {

    private EmployeeId employeeId;

    private YearMonth startDate;

    private YearMonth endDate;

    private Project project;

    private ProjectContent projectContent;
}
