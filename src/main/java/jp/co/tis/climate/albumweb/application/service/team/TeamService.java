package jp.co.tis.climate.albumweb.application.service.team;

import static java.util.stream.Collectors.toList;

import java.util.List;

import jp.co.tis.climate.albumweb.infrastructure.dao.TeamDao;
import jp.co.tis.climate.albumweb.infrastructure.dao.UserDao;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final TeamDao teamDao;

    public TeamService(TeamService teamService){ this.teamDao = teamDao;}

    /**
     *
     * @param
     * @param
     * @return
     */

}

