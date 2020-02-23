package jp.co.tis.climate.albumweb.domain.model.member;

import jp.co.tis.climate.albumweb.domain.TeamId;
import jp.co.tis.climate.albumweb.domain.TeamName;
import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
@Data
public class Team {

    @Id
    private TeamId teamId;

    private TeamName teamName;
}
