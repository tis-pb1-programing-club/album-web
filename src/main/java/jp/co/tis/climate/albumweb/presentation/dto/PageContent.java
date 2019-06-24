package jp.co.tis.climate.albumweb.presentation.dto;

import jp.co.tis.climate.albumweb.domain.model.profile.Profile;
import jp.co.tis.climate.albumweb.domain.model.profile.Career;
import lombok.Data;

import java.util.List;

@Data
public class PageContent {

    private Profile profile;

    private List<Career> allCareers;
}
