package jp.co.tis.climate.albumweb.presentation.dto;

import jp.co.tis.climate.albumweb.domain.EmployeeId;
import jp.co.tis.climate.albumweb.domain.Name;
import jp.co.tis.climate.albumweb.domain.Partial;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountSearch {
    private Partial<EmployeeId> employeeId;

    private Partial<Name> name;

    private Partial<String> role;
}
