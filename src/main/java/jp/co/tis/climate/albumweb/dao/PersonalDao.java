package jp.co.tis.climate.albumweb.dao;

import jp.co.tis.climate.albumweb.dto.PersonalPart;
import jp.co.tis.climate.albumweb.model.Personal;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.SelectOptions;

import java.util.List;

@Dao
@ConfigAutowireable
public interface PersonalDao {

    @Select
    List<Personal> findAll();

    @Select
    Personal findPersonalByPersonalId(Integer personalId);

    @Select
    List<PersonalPart> findPersonalPartByPersonal(/*Personal personal,*/ /*SelectOptions options*/);

}