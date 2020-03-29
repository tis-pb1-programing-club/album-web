package jp.co.tis.climate.albumweb.application.service.account;

import jp.co.tis.climate.albumweb.application.service.team.TeamService;
import jp.co.tis.climate.albumweb.domain.model.member.Account;
import jp.co.tis.climate.albumweb.domain.model.member.Career;
import jp.co.tis.climate.albumweb.domain.model.member.Profile;
import jp.co.tis.climate.albumweb.infrastructure.dao.AccountDao;
import jp.co.tis.climate.albumweb.infrastructure.dao.CareerDao;
import jp.co.tis.climate.albumweb.infrastructure.dao.ProfileDao;
import jp.co.tis.climate.albumweb.infrastructure.dao.TeamDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountDao accountDao;

    private  final CareerDao careerDao;

    private final ProfileDao profileDao;

    private final TeamDao teamDao;

    public AccountService(AccountDao accountDao, CareerDao careerDao, ProfileDao profileDao, TeamDao teamDao){

        this.accountDao = accountDao;
        this.careerDao = careerDao;
        this.profileDao = profileDao;
        this.teamDao = teamDao;

    }

    public void register(Account account, List<Career> allCareers, Profile profile){
        accountDao.insert(account);
        careerDao.batchInsert(allCareers);
        profileDao.insert(profile);
    }

    public void delete(Account account, List<Career> allCareers, Profile profile){
        accountDao.delete(account);
        careerDao.batchDelete(allCareers);
        profileDao.delete(profile);
    }
}
