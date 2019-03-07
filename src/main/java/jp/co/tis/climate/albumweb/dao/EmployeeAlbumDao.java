package jp.co.tis.climate.albumweb.dao;

import jp.co.tis.climate.albumweb.model.EmployeeAlbum;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface EmployeeAlbumDao {

    @Select
    List<EmployeeAlbum> findAll();

    @Select
    EmployeeAlbum findEmployeeAlbum(Integer employeeId);
}
