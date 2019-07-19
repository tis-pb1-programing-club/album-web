package jp.co.tis.climate.albumweb.application.service.profile;

import jp.co.tis.climate.albumweb.infrastructure.dao.ProfileDao;
import jp.co.tis.climate.albumweb.infrastructure.dao.CareerDao;
import jp.co.tis.climate.albumweb.presentation.dto.PageContent;
import jp.co.tis.climate.albumweb.infrastructure.manager.ImageFileManager;
import jp.co.tis.climate.albumweb.domain.model.profile.Career;
import jp.co.tis.climate.albumweb.domain.model.profile.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PageService {

    private final ProfileDao profileDao;

    private final CareerDao careerDao;

    private final ImageFileManager imageFileManager;

    public PageService(ProfileDao profileDao, CareerDao careerDao, ImageFileManager imageFileManager) {
        this.profileDao = profileDao;
        this.careerDao = careerDao;
        this.imageFileManager = imageFileManager;
    }

    public PageContent getPageContentByEmployeeId(String employeeId) {
        Profile profile = profileDao.findProfileByEmployeeId(employeeId);
        List<Career> allCareers = careerDao.findCareerAllByEmployeeId(employeeId);
        PageContent pageContent = new PageContent();
        pageContent.setProfile(profile);
        pageContent.setAllCareers(allCareers);
        return pageContent;
    }

    public boolean isRegisteredProfile(String employeeId) {
        Profile profile = profileDao.findProfileByEmployeeId(employeeId);
        return Objects.nonNull(profile);
    }

    public void register(Profile profile, List<Career> allCareers) {
        profileDao.insert(profile);
        careerDao.batchInsert(allCareers);
    }
    
    public void delete(Profile profile, List<Career> allCareers){
        String filename = profile.getProfileImageFilename();
        profileDao.delete(profile);
        careerDao.batchDelete(allCareers);
        imageFileManager.delete(filename);
    }
}
