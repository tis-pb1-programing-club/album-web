package jp.co.tis.climate.albumweb.application.service.team;

import jp.co.tis.climate.albumweb.domain.model.member.Team;
import jp.co.tis.climate.albumweb.infrastructure.dao.TeamDao;
import jp.co.tis.climate.albumweb.presentation.validation.Month;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamService {

    private final TeamDao teamDao;

    public TeamService(TeamDao teamDao){this.teamDao = teamDao;}

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Team> findTeamList(){
        return teamDao.findTeamList();
    }
}

