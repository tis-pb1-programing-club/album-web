package jp.co.tis.climate.albumweb.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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

    @NotEmpty
    @Size(min=4,max=4)
    private String year;

    @NotEmpty
    @Size(min=1,max=2)
    private String month;

    private String event;
}
