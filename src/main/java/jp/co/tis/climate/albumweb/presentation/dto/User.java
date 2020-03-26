package jp.co.tis.climate.albumweb.presentation.dto;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.jdbc.entity.NamingType;

@Data
@Entity(naming = NamingType.SNAKE_UPPER_CASE)
public class User {
    private String employeeId;
    private String name;
    private String isAdmin;
}
