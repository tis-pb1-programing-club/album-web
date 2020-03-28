package jp.co.tis.climate.albumweb.infrastructure.dao;

import jp.co.tis.climate.albumweb.domain.EmployeeId;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

import jp.co.tis.climate.albumweb.domain.model.member.UserRole;

import java.util.Optional;

@Dao
@ConfigAutowireable
public interface UserRoleDao {

    @Select
    Optional<UserRole> findUserRoleByEmployeeId(EmployeeId employeeId);

    @Insert
    Result<UserRole> insert(UserRole userRole);

    @Update
    Result<UserRole> update(UserRole userRole);

}
