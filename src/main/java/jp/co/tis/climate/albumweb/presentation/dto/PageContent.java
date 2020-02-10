package jp.co.tis.climate.albumweb.presentation.dto;

import jp.co.tis.climate.albumweb.domain.model.member.Profile;
import jp.co.tis.climate.albumweb.domain.model.member.Career;
import lombok.Data;

import java.util.List;

@Data
public class PageContent {

    private Profile profile;

    private List<Career> allCareers;
}
