package jp.co.tis.climate.albumweb.service;

import jp.co.tis.climate.albumweb.dao.EmployeeAlbumDao;
import jp.co.tis.climate.albumweb.dao.HistoryDao;
import jp.co.tis.climate.albumweb.dto.AlbumPage;
import jp.co.tis.climate.albumweb.model.EmployeeAlbum;
import jp.co.tis.climate.albumweb.model.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumViewService {

    @Autowired
    private EmployeeAlbumDao employeeAlbumDao;

    @Autowired
    private HistoryDao historyDao;

    public AlbumPage getAlbumPageById(Integer employeeId){
        EmployeeAlbum employeeAlbum = employeeAlbumDao.findEmployeeAlbum(employeeId);
        List<History> histories = historyDao.findHistoryByEmployeeId(employeeId);
        AlbumPage albumPage = new AlbumPage();
        albumPage.setEmployeeAlbum(employeeAlbum);
        albumPage.setHistories(histories);
        return albumPage;
    }
}
