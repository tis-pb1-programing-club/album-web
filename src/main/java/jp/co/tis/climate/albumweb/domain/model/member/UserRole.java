package jp.co.tis.climate.albumweb.domain.model.member;

import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

import lombok.Data;

@Entity(naming = NamingType.SNAKE_UPPER_CASE, immutable = true)
@Table(name = "USER_ROLE")
@Data
public class UserRole {
    
    public final String username;
    
    public final String role;
    
    public UserRole(final String username, final String role) {
        this.username = username;
        this.role = role;
    }

}
