package jp.co.tis.climate.albumweb.presentation.dto;

import jp.co.tis.climate.albumweb.domain.EmployeeId;
import jp.co.tis.climate.albumweb.domain.Name;
import jp.co.tis.climate.albumweb.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountResult {
    private EmployeeId employeeId;

    private Name name;

    private Role role;

    public String convertRole2Checked (Role role) {
        if (role.getValue().equals("ROLE_ADMIN")) {
            return "checked";
        }
        return "unchecked";
    }
}

