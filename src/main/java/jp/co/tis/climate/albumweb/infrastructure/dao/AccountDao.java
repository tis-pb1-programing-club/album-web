package jp.co.tis.climate.albumweb.infrastructure.dao;


import jp.co.tis.climate.albumweb.domain.EmployeeId;
import jp.co.tis.climate.albumweb.domain.model.member.Account;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.Optional;

@Dao
@ConfigAutowireable
public interface AccountDao {

    @Select
    Optional<Account> findAccountByEmployeeId(EmployeeId employeeId);

    @Update(include = {"isAdmin"})
    int updateAdminPrivilege(Account account);

    @Delete
    int delete(Account account);

}
