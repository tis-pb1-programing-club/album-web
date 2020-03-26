package jp.co.tis.climate.albumweb.infrastructure.dao;

import jp.co.tis.climate.albumweb.domain.model.member.Account;
import jp.co.tis.climate.albumweb.domain.model.member.Career;

import org.seasar.doma.BatchDelete;
import org.seasar.doma.BatchInsert;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface CareerDao {

    @Select
    List<Career> findCareerAllByEmployeeId(String employeeId);

    @BatchInsert
    int[] batchInsert(List<Career> careers);

    @Insert
    int insert(Career career);
    
    @BatchDelete
    int[] batchDelete(List<Career> careers);

    @Delete
    int deleteByAccount(Account account);
}
