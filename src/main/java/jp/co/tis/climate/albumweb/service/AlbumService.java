package jp.co.tis.climate.albumweb.service;

import jp.co.tis.climate.albumweb.dao.UserDao;
import jp.co.tis.climate.albumweb.dto.UserPart;
import jp.co.tis.climate.albumweb.model.User;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private static final Integer PERSONAL_PART_NUMBER=12;

    @Autowired
    private UserDao userDao;

    /**
     *
     * @param user 検索条件 クラス及び属性がnullは無視
     * @param pageNumber 表示するページ。1~
     * @return 検索結果
     */
    public List<UserPart> getPersonalParts(User user, int pageNumber){
        int offset = (pageNumber-1) * PERSONAL_PART_NUMBER + 1;
        SelectOptions options = SelectOptions.get().offset(offset).limit(offset + PERSONAL_PART_NUMBER -1).count();
        return userDao.findPersonalPartByPersonal(/*user,*/ /*options*/);
    }
}
