package jp.co.tis.climate.albumweb.presentation.dto;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.jdbc.entity.NamingType;

import java.time.Year;

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

    private String joiningYear;

    private String sex;

    private String bloodType;

    private String comment;

    public Integer getYearly() {
        if (joiningYear == null) {
            return null;
        }
        return Year.now().getValue() - Integer.parseInt(joiningYear) + 1;
    }
}
