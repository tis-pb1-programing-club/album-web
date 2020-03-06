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

    /** プロフィールの検索処理。
     * 実態はプロフィールの要素の内の名前（部分一致）、趣味（部分一致）、出身地、所属チームのみで検索し、
     * 社員番号、名前、顔写真のみを返す。
     * これはtop画面の検索/結果表示の仕様に準ずる */
    // TODO: 現在所属チームでは検索していない
    @Select
    List<Profile> findProfileByProfile(Profile profile);

    @Insert
    int insert(Profile profile);
    
    @Delete
    int delete(Profile profile);
}