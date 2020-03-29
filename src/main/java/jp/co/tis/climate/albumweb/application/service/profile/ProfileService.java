package jp.co.tis.climate.albumweb.application.service.profile;

import jp.co.tis.climate.albumweb.domain.model.member.Profile;
import jp.co.tis.climate.albumweb.infrastructure.dao.ProfileDao;
import jp.co.tis.climate.albumweb.infrastructure.dao.TeamDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfileService {

    public final ProfileDao profileDao;

    public ProfileService(ProfileDao profileDao){this.profileDao = profileDao;}

    //プロフィール登録
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public int registar(Profile profile){
        return profileDao.insert(profile);
    }

}
