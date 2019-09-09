package jp.co.tis.climate.albumweb.infrastructure.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

import jp.co.tis.climate.albumweb.domain.model.member.UserRole;

@Dao
@ConfigAutowireable
public interface UserRoleDao {
    
    @Insert
    Result<UserRole> insert(UserRole userRole);

}
