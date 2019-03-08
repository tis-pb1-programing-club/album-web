package jp.co.tis.climate.albumweb.dao;

import jp.co.tis.climate.albumweb.model.Personal;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface PersonalDao {

    @Select
    List<Personal> findAll();

    @Select
    Personal findPersonalByPersonalId(Integer personalId);
}
