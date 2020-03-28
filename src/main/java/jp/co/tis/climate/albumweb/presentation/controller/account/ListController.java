package jp.co.tis.climate.albumweb.presentation.controller.account;

import jp.co.tis.climate.albumweb.application.service.account.SearchService;
import jp.co.tis.climate.albumweb.presentation.dto.AccountResult;
import jp.co.tis.climate.albumweb.presentation.dto.AccountSearch;
import jp.co.tis.climate.albumweb.presentation.form.AccountSearchForm;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.modelmapper.ModelMapper;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class ListController {

    private final ModelMapper modelMapper;
    private final SearchService searchService;
    private final BeanUtilsBean beanUtilsBean;

    public ListController(ModelMapper modelMapper, SearchService searchService, BeanUtilsBean beanUtilsBean) {
        this.modelMapper = modelMapper;
        this.searchService = searchService;
        this.beanUtilsBean = beanUtilsBean;
    }

    @InitBinder
    public void initbinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/list")
    public String list(@ModelAttribute @Validated AccountSearchForm accountSearchForm, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "account/list";
        }
        AccountSearch accountSearch = new AccountSearch();
        try {
            beanUtilsBean.copyProperties(accountSearch, accountSearchForm);
        }catch (IllegalAccessException |
                InvocationTargetException ex){
            System.out.println(ex);
        }

        List<AccountResult> accounts = searchService.search(accountSearch);
        model.addAttribute("accountSearchForm", accountSearchForm);
        model.addAttribute("accountList", accounts);

        return "account/list";
    }

}
