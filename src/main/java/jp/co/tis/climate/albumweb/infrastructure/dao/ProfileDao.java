package jp.co.tis.climate.albumweb.infrastructure.dao;

import jp.co.tis.climate.albumweb.domain.model.member.Profile;
import jp.co.tis.climate.albumweb.presentation.dto.ProfileCard;
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

    // 実態は名前（部分一致）、趣味（部分一致）、趣味、血液型、のみで検索
    @Select
    List<ProfileCard> findProfileCardByProfile(Profile profile);

    @Insert
    int insert(Profile profile);
    
    @Delete
    int delete(Profile profile);
}