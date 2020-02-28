package jp.co.tis.climate.albumweb.application.service.account;

import jp.co.tis.climate.albumweb.domain.EmployeeId;
import jp.co.tis.climate.albumweb.domain.model.member.Account;
import jp.co.tis.climate.albumweb.domain.model.member.Profile;
import jp.co.tis.climate.albumweb.infrastructure.dao.AccountDao;
import jp.co.tis.climate.albumweb.infrastructure.dao.ProfileDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class DeleteService {

    private final ProfileDao profileDao;
    private final AccountDao accountDao;

    public DeleteService (ProfileDao profileDao,
                          AccountDao accountDao) {
        this.profileDao = profileDao;
        this.accountDao = accountDao;
    }



    public void deleteAccountWithProfile (Account account) {
        EmployeeId employeeId = account.getEmployeeId();
        Optional<Profile> profile = profileDao.findProfileByEmployeeId(employeeId);

        profile.map(profileDao::delete);

        accountDao.delete(account);
    }


}
