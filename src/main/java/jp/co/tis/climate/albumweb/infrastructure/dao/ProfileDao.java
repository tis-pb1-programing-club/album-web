package jp.co.tis.climate.albumweb.infrastructure.dao;

import jp.co.tis.climate.albumweb.domain.EmployeeId;
import jp.co.tis.climate.albumweb.domain.model.member.Profile;
import jp.co.tis.climate.albumweb.presentation.dto.ProfileCard;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import java.util.Optional;

@Dao
@ConfigAutowireable
public interface ProfileDao {

    @Select
    List<Profile> findAll();

    @Select
    Optional<Profile> findProfileByEmployeeId(EmployeeId employeeId);

    @Select
    List<ProfileCard> findProfileCardAll();

    @Insert
    int insert(Profile profile);
    
    @Delete
    int delete(Profile profile);
}