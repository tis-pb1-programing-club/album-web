package jp.co.tis.climate.albumweb.dao;

import jp.co.tis.climate.albumweb.model.Album;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface AlbumDao {

    @Select
    List<Album> findAll();

    @Select
    Album findAlbumByAlbumId(Integer albumId);
}
