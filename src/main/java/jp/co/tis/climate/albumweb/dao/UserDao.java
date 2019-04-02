package jp.co.tis.climate.albumweb.dao;

import jp.co.tis.climate.albumweb.dto.PersonalPart;
import jp.co.tis.climate.albumweb.model.User;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface UserDao {

    @Select
    List<User> findAll();

    @Select
    User findPersonalByPersonalId(Integer userId);

    @Select
    List<PersonalPart> findPersonalPartByPersonal(/*User user,*/ /*SelectOptions options*/);

    @Insert
    int insert(User user);
}