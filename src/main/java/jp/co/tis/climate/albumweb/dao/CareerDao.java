package jp.co.tis.climate.albumweb.dao;

import jp.co.tis.climate.albumweb.model.Career;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface CareerDao {

    @Select
    List<Career> findHistoryAllByUserId(Integer userId);

    @Insert
    int insert(Career career);
}
