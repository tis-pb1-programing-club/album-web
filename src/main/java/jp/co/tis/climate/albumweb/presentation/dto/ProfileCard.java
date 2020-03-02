package jp.co.tis.climate.albumweb.presentation.dto;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.jdbc.entity.NamingType;
import org.springframework.util.StringUtils;

import java.time.Year;
import java.util.Optional;

/**
 * albumページに表示される部分的なpersonalの情報
 */
@Entity(naming = NamingType.SNAKE_UPPER_CASE)
@Data
public class ProfileCard {

    private String employeeId;

    private String picture;

    private String Name;
}
