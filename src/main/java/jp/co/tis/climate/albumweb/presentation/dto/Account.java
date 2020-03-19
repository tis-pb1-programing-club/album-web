package jp.co.tis.climate.albumweb.presentation.dto;

import jp.co.tis.climate.albumweb.domain.EmployeeId;
import jp.co.tis.climate.albumweb.domain.Password;
import lombok.Data;

@Data
public class Account {
    private EmployeeId employeeId;

    private Password password;

    private String isAdmin;
}
