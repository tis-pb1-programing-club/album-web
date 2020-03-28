package jp.co.tis.climate.albumweb.domain.model.member;

import jp.co.tis.climate.albumweb.domain.EmployeeId;
import jp.co.tis.climate.albumweb.domain.Role;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

import lombok.Data;

@Entity(naming = NamingType.SNAKE_UPPER_CASE, immutable = true)
@Table(name = "USER_ROLE")
@Data
public class UserRole {
    
    public final EmployeeId employeeId;
    
    public final Role role;
    
    public UserRole(final EmployeeId employeeId, final Role role) {
        this.employeeId = employeeId;
        this.role = role;
    }

}
