package jp.co.tis.climate.albumweb.infrastructure.dao;

import jp.co.tis.climate.albumweb.domain.model.member.Team;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface TeamDao {

    //チーム一覧を取得する
    @Select
    List<Team> findTeamList();

}
