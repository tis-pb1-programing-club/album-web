package jp.co.tis.climate.albumweb.dao;

import jp.co.tis.climate.albumweb.model.History;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface HistoryDao {

    @Select
    List<History> findHistoryByEmployeeId(Integer employeeId);
}
