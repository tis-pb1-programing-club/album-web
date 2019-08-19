package jp.co.tis.climate.albumweb.infrastructure.dao;

import jp.co.tis.climate.albumweb.domain.model.member.User;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import java.util.Optional;

@Dao
@ConfigAutowireable
public interface UserDao {

    @Select
    Optional<User> loadUserByUserName(String username);

    @Select
    List<String> loadUserRoles(String username);
}
