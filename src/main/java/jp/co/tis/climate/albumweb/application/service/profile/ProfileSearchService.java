package jp.co.tis.climate.albumweb.application.service.profile;

import jp.co.tis.climate.albumweb.domain.model.member.Profile;
import jp.co.tis.climate.albumweb.infrastructure.dao.ProfileDao;
import jp.co.tis.climate.albumweb.presentation.dto.ProfileCard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileSearchService {

    private final ProfileDao profileDao;

    public ProfileSearchService(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    // 検索結果取得
    public List<ProfileCard> searchProfile(Profile profile){
        return profileDao.findProfileCardByProfile(profile);
    }

}
