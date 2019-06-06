package jp.co.tis.climate.albumweb.service;

import jp.co.tis.climate.albumweb.dao.ProfileDao;
import jp.co.tis.climate.albumweb.dao.CareerDao;
import jp.co.tis.climate.albumweb.dto.PageContent;
import jp.co.tis.climate.albumweb.manager.ImageFileManager;
import jp.co.tis.climate.albumweb.model.Career;
import jp.co.tis.climate.albumweb.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PageService {

    @Autowired
    private ProfileDao profileDao;

    @Autowired
    private CareerDao careerDao;

    @Autowired
    private ImageFileManager imageFileManager;

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
