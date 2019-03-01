package jp.co.tis.climate.albumweb.model;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name="HELLO")
@Data
public class Hello {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String message;
}
