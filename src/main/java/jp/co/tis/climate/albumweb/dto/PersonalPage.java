package jp.co.tis.climate.albumweb.dto;

import jp.co.tis.climate.albumweb.model.Personal;
import jp.co.tis.climate.albumweb.model.History;
import lombok.Data;

import java.util.List;

@Data
public class PersonalPage {

    private Personal personal;

    private List<History> histories;
}
