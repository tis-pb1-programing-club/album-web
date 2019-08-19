package jp.co.tis.climate.albumweb.domain.model.member;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_UPPER_CASE, immutable = true)
@Table(name = "USER")
@Data
public class User {

    public final String username;

    public final String password;

    public User(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

}
