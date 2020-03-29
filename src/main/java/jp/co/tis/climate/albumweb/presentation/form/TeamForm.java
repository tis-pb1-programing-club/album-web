package jp.co.tis.climate.albumweb.presentation.form;

import jp.co.tis.climate.albumweb.domain.model.member.Team;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Getter
@Setter

public class TeamForm {

    String teamId;
    String teamName;

    public TeamForm(String teamId, String teamName){
        this.teamId = teamId;
        this.teamName = teamName;
    }

    public String getTeamId(){
        return teamId;
    }

    public String getTeamName(){
        return teamName;
    }

    private List<TeamForm> allTeams;

}
