package jp.co.tis.climate.albumweb.application.service.account;

import jp.co.tis.climate.albumweb.domain.EmployeeId;

public interface AccountService {
    void deleteAccountByEmployeeId(EmployeeId employeeId);
}
