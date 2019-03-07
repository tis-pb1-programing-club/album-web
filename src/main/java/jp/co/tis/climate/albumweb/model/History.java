package jp.co.tis.climate.albumweb.model;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name="HISTORY")
@Data
public class History {

    @Id
    private Integer historyId;

    private Integer employeeId;

    private Short year;

    private Byte month;

    private String event;
}
