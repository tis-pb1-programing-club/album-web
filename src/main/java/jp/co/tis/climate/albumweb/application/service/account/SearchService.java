package jp.co.tis.climate.albumweb.application.service.account;

import jp.co.tis.climate.albumweb.domain.Name;
import jp.co.tis.climate.albumweb.domain.Role;
import jp.co.tis.climate.albumweb.domain.model.member.Account;
import jp.co.tis.climate.albumweb.domain.model.member.Profile;
import jp.co.tis.climate.albumweb.infrastructure.dao.AccountDao;
import jp.co.tis.climate.albumweb.infrastructure.dao.ProfileDao;
import jp.co.tis.climate.albumweb.infrastructure.dao.UserRoleDao;
import jp.co.tis.climate.albumweb.presentation.dto.AccountResult;
import jp.co.tis.climate.albumweb.presentation.dto.AccountSearch;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SearchService {

    AccountDao accountDao;
    ProfileDao profileDao;
    UserRoleDao userRoleDao;

    public SearchService(AccountDao accountDao, ProfileDao profileDao, UserRoleDao userRoleDao) {
        this.accountDao = accountDao;
        this.profileDao = profileDao;
        this.userRoleDao = userRoleDao;
    }

    public List<AccountResult> search(AccountSearch accountSearch) {
        List<Account> accounts = accountDao.findAccountByConditions(accountSearch);
        return accounts.stream()
                .map(account -> {
                    Name name = profileDao.findProfileByEmployeeId(account.getEmployeeId()).map(Profile::getName).orElse(new Name("(No name)"));
                    Role role = userRoleDao.findUserRoleByEmployeeId(account.getEmployeeId()).orElseThrow(RuntimeException::new).getRole();
                    return new AccountResult(account.getEmployeeId(),name,role);})
                .collect(Collectors.toList());
    }
}
