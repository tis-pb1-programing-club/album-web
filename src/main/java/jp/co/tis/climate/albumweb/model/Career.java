package jp.co.tis.climate.albumweb.model;

import lombok.Data;
import org.seasar.doma.*;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
@Table(name="HISTORY")
@Data
public class Career {

    @Id
    private Integer userId;

    @Id
    private Integer careerId;

    private Short year;

    private Byte month;

    private String event;
}
