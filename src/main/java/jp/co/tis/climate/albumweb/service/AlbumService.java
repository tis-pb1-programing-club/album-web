package jp.co.tis.climate.albumweb.service;

import jp.co.tis.climate.albumweb.dao.PersonalDao;
import jp.co.tis.climate.albumweb.dto.PersonalPart;
import jp.co.tis.climate.albumweb.model.Personal;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private static final Integer PERSONAL_PART_NUMBER=12;

    @Autowired
    private PersonalDao personalDao;

    /**
     *
     * @param personal 検索条件 クラス及び属性がnullは無視
     * @param pageNumber 表示するページ。1~
     * @return 検索結果
     */
    public List<PersonalPart> getPersonalParts(Personal personal, int pageNumber){
        int offset = (pageNumber-1) * PERSONAL_PART_NUMBER + 1;
        SelectOptions options = SelectOptions.get().offset(offset).limit(offset + PERSONAL_PART_NUMBER -1).count();
        return personalDao.findPersonalPartByPersonal(/*personal,*/ /*options*/);
    }
}
