package jp.co.tis.climate.albumweb.infrastructure.dao;


import jp.co.tis.climate.albumweb.domain.model.member.Account;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface AccountDao {

    @Delete
    int delete(Account account);
}
