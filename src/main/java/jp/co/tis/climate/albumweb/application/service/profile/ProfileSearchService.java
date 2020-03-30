package jp.co.tis.climate.albumweb.application.service.profile;

import jp.co.tis.climate.albumweb.domain.TeamId;
import jp.co.tis.climate.albumweb.domain.model.member.Profile;
import jp.co.tis.climate.albumweb.infrastructure.dao.ProfileDao;
import org.springframework.stereotype.Service;

import java.util.List;

/** プロフィール一覧検索サービス */
@Service
public class ProfileSearchService {

    private final ProfileDao profileDao;

    public ProfileSearchService(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    /** プロフィールを各要素で検索(チーム無し) */
    public List<Profile> searchProfile(Profile profile){
        return searchProfile(profile, null);
    }

    /** プロフィールを各要素で検索 */
    public List<Profile> searchProfile(Profile profile, TeamId teamId){
        return profileDao.findProfileByProfile(profile, teamId);
    }

}