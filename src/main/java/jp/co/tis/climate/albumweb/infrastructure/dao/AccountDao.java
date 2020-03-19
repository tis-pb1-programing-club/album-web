package jp.co.tis.climate.albumweb.infrastructure.dao;


import jp.co.tis.climate.albumweb.domain.EmployeeId;
import jp.co.tis.climate.albumweb.domain.model.member.Account;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import java.util.Optional;

@Dao
@ConfigAutowireable
public interface AccountDao {

    @Select
    Optional<Account> findAccountByEmployeeId(EmployeeId employeeId);

    @Select
    List<Account> findAccountByConditions(Optional<EmployeeId> employeeId,
                                          Optional<String> name,
                                          Optional<String> isAdmin);

    @Update(include = {"isAdmin"})
    int updateAdminPrivilege(Account account);

    @Delete
    int delete(Account account);

}
