package jp.co.tis.climate.albumweb.presentation.controller.account;

import jp.co.tis.climate.albumweb.application.service.account.AccountService;
import jp.co.tis.climate.albumweb.domain.EmployeeId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class DeleteController {

    private final AccountService accountService;
    public DeleteController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") EmployeeId employeeId) {
        accountService.deleteAccountByEmployeeId(employeeId);
        return "redirect:/account/list";
    }
}
