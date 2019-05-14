package jp.co.tis.climate.albumweb.dto;

import jp.co.tis.climate.albumweb.model.Profile;
import jp.co.tis.climate.albumweb.model.Career;
import lombok.Data;

import java.util.List;

@Data
public class PageContent {

    private Profile profile;

    private List<Career> allCareers;
}
