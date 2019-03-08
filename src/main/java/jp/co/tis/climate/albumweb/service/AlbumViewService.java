package jp.co.tis.climate.albumweb.service;

import jp.co.tis.climate.albumweb.dao.AlbumDao;
import jp.co.tis.climate.albumweb.dao.HistoryDao;
import jp.co.tis.climate.albumweb.dto.AlbumPage;
import jp.co.tis.climate.albumweb.model.Album;
import jp.co.tis.climate.albumweb.model.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumViewService {

    @Autowired
    private AlbumDao albumDao;

    @Autowired
    private HistoryDao historyDao;

    public AlbumPage getAlbumPageById(Integer albumId){
        Album album = albumDao.findAlbumByAlbumId(albumId);
        List<History> histories = historyDao.findHistoryByAlbumId(albumId);
        AlbumPage albumPage = new AlbumPage();
        albumPage.setAlbum(album);
        albumPage.setHistories(histories);
        return albumPage;
    }
}
