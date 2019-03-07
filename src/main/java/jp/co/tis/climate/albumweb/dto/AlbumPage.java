package jp.co.tis.climate.albumweb.dto;

import jp.co.tis.climate.albumweb.model.EmployeeAlbum;
import jp.co.tis.climate.albumweb.model.History;
import lombok.Data;

import java.util.List;

@Data
public class AlbumPage {

    private EmployeeAlbum employeeAlbum;

    private List<History> histories;
}
