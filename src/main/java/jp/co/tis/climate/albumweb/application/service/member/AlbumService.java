package jp.co.tis.climate.albumweb.application.service.member;

import jp.co.tis.climate.albumweb.infrastructure.dao.ProfileDao;
import jp.co.tis.climate.albumweb.presentation.dto.ProfileCard;
import jp.co.tis.climate.albumweb.domain.model.profile.Profile;
//import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    // TODO: ページネーションを実装する。
    // こちらは実装に必要なのでとっておく
    // private static final Integer PERSONAL_PART_NUMBER=12;

    private final ProfileDao profileDao;

    public AlbumService(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    /**
     *
     * @param user       検索条件 クラス及び属性がnullは無視
     * @param pageNumber 表示するページ。1~
     * @return 検索結果
     */
    // 引数はまだ使わないが、ページネーション実装時に必要なのでとっておく。
    public List<ProfileCard> getProfileCards(Profile profile, int pageNumber) {
        // ページネーション実装に必要な個所。
        // int offset = (pageNumber-1) * PERSONAL_PART_NUMBER + 1;
        // SelectOptions options = SelectOptions.get().offset(offset).limit(offset +
        // PERSONAL_PART_NUMBER -1).count();
        return profileDao.findProfileCardAll();
    }
}
