package jp.co.tis.climate.albumweb.infrastructure.dao;


import jp.co.tis.climate.albumweb.domain.EmployeeId;
import jp.co.tis.climate.albumweb.domain.model.member.Account;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.Optional;

@Dao
@ConfigAutowireable
public interface AccountDao {

    @Select
    Optional<Account> findAccountByEmployeeId(EmployeeId employeeId);

    @Delete
    int delete(Account account);
}
