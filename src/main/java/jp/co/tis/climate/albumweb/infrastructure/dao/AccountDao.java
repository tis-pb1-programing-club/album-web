package jp.co.tis.climate.albumweb.infrastructure.dao;

import jp.co.tis.climate.albumweb.domain.model.member.Account;
import jp.co.tis.climate.albumweb.domain.model.member.Career;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface AccountDao {

    @Select
    List<Account> findAccountAllByEmployeeId(String employeeId);

    @Insert
    int insert(Account account);

    @Delete
    int delete(Account account);

}
