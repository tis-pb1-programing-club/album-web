package jp.co.tis.climate.albumweb.application.service.profile.impl;

import jp.co.tis.climate.albumweb.application.service.profile.ProfileService;
import jp.co.tis.climate.albumweb.infrastructure.dao.UserDao;
import jp.co.tis.climate.albumweb.presentation.dto.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    private final UserDao userDao;
    public ProfileServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public List<User> findUser(String employeeId, String name, String isAdmin) {
        return userDao.findUserBy(employeeId, name, isAdmin);
    }
}
