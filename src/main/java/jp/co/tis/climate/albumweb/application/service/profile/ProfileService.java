package jp.co.tis.climate.albumweb.application.service.profile;

import jp.co.tis.climate.albumweb.presentation.dto.User;

import java.util.List;

public interface ProfileService {
    public List<User> findUser(String employeeId, String name, String isAdmin);
}
