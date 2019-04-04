package jp.co.tis.climate.albumweb.service;

import jp.co.tis.climate.albumweb.dao.UserDao;
import jp.co.tis.climate.albumweb.dao.CareerDao;
import jp.co.tis.climate.albumweb.dto.UserPage;
import jp.co.tis.climate.albumweb.model.Career;
import jp.co.tis.climate.albumweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CareerDao careerDao;

    public UserPage getPersonalPageByPersonalId(Integer personalId){
        User user = userDao.findPersonalByPersonalId(personalId);
        List<Career> histories = careerDao.findHistoryAllByPersonalId(personalId);
        UserPage userPage = new UserPage();
        userPage.setUser(user);
        userPage.setHistories(histories);
        return userPage;
    }

    public void register(User user, List<Career> histories){
        userDao.insert(user);
        for(Career career :histories){
            careerDao.insert(career);
        }
    }
}
