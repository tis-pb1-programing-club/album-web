package jp.co.tis.climate.albumweb.presentation.form;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class AccountSearchForm {
    private String employeeId;

    private String name;

    private String role;

    public Map<String,String> adminOptions() {

        Map<String,String> pullDownAdmin = new LinkedHashMap<>();
        pullDownAdmin.put("all","");
        pullDownAdmin.put("admin","管理者");

        return pullDownAdmin;
    }
}
