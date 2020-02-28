package jp.co.tis.climate.albumweb.application.service.account;

import jp.co.tis.climate.albumweb.domain.model.member.Account;
import jp.co.tis.climate.albumweb.infrastructure.dao.AccountDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UpdateAdminPrivilegeService {
    private final AccountDao accountDao;

    public UpdateAdminPrivilegeService (AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void updateAdminPrivilege (Account account) {

    }

}
