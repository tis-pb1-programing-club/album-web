package jp.co.tis.climate.albumweb.model;

import lombok.Data;
import org.seasar.doma.*;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
@Table(name="CAREER")
@Data
public class Career {

    @Id
    private String userId;

    @Id
    private String careerId;

    private String year;

    private String month;

    private String event;
}
