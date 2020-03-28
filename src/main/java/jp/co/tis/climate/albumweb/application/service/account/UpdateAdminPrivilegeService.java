package jp.co.tis.climate.albumweb.application.service.account;

import jp.co.tis.climate.albumweb.domain.EmployeeId;
import jp.co.tis.climate.albumweb.domain.Password;
import jp.co.tis.climate.albumweb.domain.model.member.Account;
import jp.co.tis.climate.albumweb.domain.model.member.UserRole;
import jp.co.tis.climate.albumweb.infrastructure.dao.AccountDao;
import jp.co.tis.climate.albumweb.infrastructure.dao.UserRoleDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@Transactional
public class UpdateAdminPrivilegeService {
    private final AccountDao accountDao;
    private final UserRoleDao userRoleDao;

    public UpdateAdminPrivilegeService(AccountDao accountDao, UserRoleDao userRoleDao) {
        this.accountDao = accountDao;
        this.userRoleDao = userRoleDao;
    }

    public void updateAdminPrivilege (UserRole userRole) {
        EmployeeId employeeId = userRole.getEmployeeId();
        Optional<Account> registeredAccount = accountDao.findAccountByEmployeeId(employeeId);
        registeredAccount.ifPresent(a -> userRoleDao.update(userRole));
    }

}
