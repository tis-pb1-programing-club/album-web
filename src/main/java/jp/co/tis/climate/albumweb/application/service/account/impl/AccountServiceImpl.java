package jp.co.tis.climate.albumweb.application.service.account.impl;

import jp.co.tis.climate.albumweb.application.service.account.AccountService;
import jp.co.tis.climate.albumweb.domain.EmployeeId;
import jp.co.tis.climate.albumweb.domain.model.member.Account;
import jp.co.tis.climate.albumweb.domain.model.member.Profile;
import jp.co.tis.climate.albumweb.infrastructure.dao.AccountDao;
import jp.co.tis.climate.albumweb.infrastructure.dao.BelongDao;
import jp.co.tis.climate.albumweb.infrastructure.dao.CareerDao;
import jp.co.tis.climate.albumweb.infrastructure.dao.ProfileDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountDao accountDao;
    private final ProfileDao profileDao;
    private final BelongDao belongDao;
    private final CareerDao careerDao;
    public AccountServiceImpl(AccountDao accountDao, ProfileDao profileDao, BelongDao belongDao, CareerDao careerDao) {
        this.accountDao = accountDao;
        this.profileDao = profileDao;
        this.belongDao = belongDao;
        this.careerDao = careerDao;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteAccountByEmployeeId(EmployeeId employeeId) {
        Profile profile = new Profile();
        profile.setEmployeeId(employeeId);
        profileDao.delete(profile);
        Account account = new Account();
        account.setEmployeeId(employeeId);
        careerDao.deleteByAccount(account);
        belongDao.deleteByAccount(account);
        accountDao.delete(account);
    }
}
