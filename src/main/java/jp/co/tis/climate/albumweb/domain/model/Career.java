package jp.co.tis.climate.albumweb.domain.model;

import lombok.Data;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
@Table(name = "CAREER")
@Data
public class Career {

    @Id
    private String employeeId;

    @Id
    private String careerId;

    private String year;

    private String month;

    private String event;
}
