package jp.co.tis.climate.albumweb.infrastructure.dao;

import jp.co.tis.climate.albumweb.domain.model.member.User;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

import java.util.List;
import java.util.Optional;

@Dao
@ConfigAutowireable
public interface UserDao {

    @Insert
    Result<User> insert(User user);

    @Select
    Optional<User> loadUserByUserName(String username);

    @Select
    List<String> loadUserRoles(String username);

    @Select
    List<jp.co.tis.climate.albumweb.presentation.dto.User> findUserBy(String employeeId, String name, String isAdmin);
}
