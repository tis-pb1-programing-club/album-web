package jp.co.tis.climate.albumweb.dto;

import jp.co.tis.climate.albumweb.model.User;
import jp.co.tis.climate.albumweb.model.Career;
import lombok.Data;

import java.util.List;

@Data
public class PersonalPage {

    private User user;

    private List<Career> histories;
}
