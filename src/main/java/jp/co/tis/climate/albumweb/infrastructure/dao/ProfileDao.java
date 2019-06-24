package jp.co.tis.climate.albumweb.infrastructure.dao;

import jp.co.tis.climate.albumweb.presentation.dto.ProfileCard;
import jp.co.tis.climate.albumweb.domain.model.profile.Profile;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface ProfileDao {

    @Select
    List<Profile> findAll();

    @Select
    Profile findProfileByEmployeeId(String employeeId);

    @Select
    List<ProfileCard> findProfileCardAll();

    @Insert
    int insert(Profile profile);
    
    @Delete
    int delete(Profile profile);
}