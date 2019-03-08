package jp.co.tis.climate.albumweb.model;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
@Table(name="HISTORY")
@Data
public class History {

    @Id
    private Integer historyId;

    private Integer albumId;

    private Short year;

    private Byte month;

    private String event;
}
