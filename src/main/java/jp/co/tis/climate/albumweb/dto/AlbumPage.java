package jp.co.tis.climate.albumweb.dto;

import jp.co.tis.climate.albumweb.model.Album;
import jp.co.tis.climate.albumweb.model.History;
import lombok.Data;

import java.util.List;

@Data
public class AlbumPage {

    private Album album;

    private List<History> histories;
}
