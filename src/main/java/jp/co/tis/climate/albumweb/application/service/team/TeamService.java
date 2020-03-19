package jp.co.tis.climate.albumweb.application.service.team;

import jp.co.tis.climate.albumweb.domain.model.member.Team;
import jp.co.tis.climate.albumweb.infrastructure.dao.TeamDao;
import org.springframework.stereotype.Service;

import java.util.List;

/** 所属チームのサービス */
@Service
public class TeamService {

    private final TeamDao teamDao;

    public TeamService(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public List<Team> findTeamAll(){
        return  teamDao.findAll();
    }
}
