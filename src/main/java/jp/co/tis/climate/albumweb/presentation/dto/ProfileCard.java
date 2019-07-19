package jp.co.tis.climate.albumweb.presentation.dto;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.jdbc.entity.NamingType;

/**
 * albumページに表示される部分的なpersonalの情報
 */
@Entity(naming = NamingType.SNAKE_UPPER_CASE)
@Data
public class ProfileCard {

    private String employeeId;

    private String profileImageFilename;

    private String lastName;

    private String firstName;

    private String yearly;

    private String sex;

    private String bloodType;

    private String comment;
}
