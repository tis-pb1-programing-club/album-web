package jp.co.tis.climate.albumweb.application.service.account;

import jp.co.tis.climate.albumweb.domain.EmployeeId;
import jp.co.tis.climate.albumweb.domain.Name;
import jp.co.tis.climate.albumweb.domain.UserName;
import jp.co.tis.climate.albumweb.domain.model.member.Account;
import jp.co.tis.climate.albumweb.infrastructure.dao.AccountDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SearchService {

    AccountDao accountDao;

    public SearchService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> search(Optional<EmployeeId> employeeId,
                                Optional<Name> name,
                                Optional<String> isAdmin) {
        return accountDao.findAccountByConditions(employeeId,name.map(Name::getValue),isAdmin);
    }



}
