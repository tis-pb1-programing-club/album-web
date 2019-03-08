package jp.co.tis.climate.albumweb.service;

import jp.co.tis.climate.albumweb.dao.PersonalDao;
import jp.co.tis.climate.albumweb.dao.HistoryDao;
import jp.co.tis.climate.albumweb.dto.PersonalPage;
import jp.co.tis.climate.albumweb.model.Personal;
import jp.co.tis.climate.albumweb.model.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalService {

    @Autowired
    private PersonalDao personalDao;

    @Autowired
    private HistoryDao historyDao;

    public PersonalPage getPersonalPageByPersonalId(Integer personalId){
        Personal personal = personalDao.findPersonalByPersonalId(personalId);
        List<History> histories = historyDao.findHistoryAllByPersonalId(personalId);
        PersonalPage personalPage = new PersonalPage();
        personalPage.setPersonal(personal);
        personalPage.setHistories(histories);
        return personalPage;
    }
}
