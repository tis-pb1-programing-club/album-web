package jp.co.tis.climate.albumweb.presentation.controller.profile;

import jp.co.tis.climate.albumweb.presentation.dto.PageContent;
import jp.co.tis.climate.albumweb.presentation.form.CareerForm;
import jp.co.tis.climate.albumweb.presentation.form.ProfileForm;
import jp.co.tis.climate.albumweb.infrastructure.manager.ImageFileManager;
import jp.co.tis.climate.albumweb.domain.model.profile.Career;
import jp.co.tis.climate.albumweb.domain.model.profile.Profile;
import jp.co.tis.climate.albumweb.application.service.profile.PageService;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Controller
@RequestMapping("album")
public class PageController {

    /**
     * 経歴番号の初期値
     */
    private static final String FIRST_CAREER_ID = "1";

    private PageService pageService;

    private ImageFileManager imageFileManager;

    private MessageSource msg;

    private ModelMapper modelMapper;

    public PageController(PageService pageService,
                          ImageFileManager imageFileManager,
                          MessageSource msg,
                          ModelMapper modelMapper) {
        this.pageService = pageService;
        this.imageFileManager = imageFileManager;
        this.msg = msg;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{employeeId}")
    public String view(@PathVariable String employeeId, Model model) throws HttpClientErrorException.NotFound {
        if (!pageService.isRegisteredProfile(employeeId)) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        PageContent pageContent = pageService.getPageContentByEmployeeId(employeeId);
        model.addAttribute("profile", pageContent.getProfile());
        model.addAttribute("allCareers", pageContent.getAllCareers());
        return "album/view";
    }

    @PostMapping("/{employeeId}")
    public String delete(@PathVariable String employeeId, Model model) {
        PageContent pageContent = pageService.getPageContentByEmployeeId(employeeId);
        pageService.delete(pageContent.getProfile(), pageContent.getAllCareers());
        return "redirect:/album";
    }

    @ModelAttribute
    @GetMapping("/newpage")
    public String add(Model model) {
        ProfileForm profileForm = new ProfileForm();

        List<CareerForm> allCareers = new ArrayList<>();
        CareerForm career = new CareerForm();
        career.setCareerId(FIRST_CAREER_ID);
        allCareers.add(career);
        profileForm.setAllCareers(allCareers);

        model.addAttribute("profileForm", profileForm);

        return "album/newpage";
    }
        // TODO Controllerなので分岐などの処理は下の層に任せること。
        // TODO 画像をプレビューする機能はバックログに追加
        // TODO 一旦一度にアップロードすることにして、このメソッドは削除

    @PostMapping(value = "/newpage")
    public String submit(@ModelAttribute @Validated ProfileForm profileForm, BindingResult result, @RequestParam("profileImage") MultipartFile mpf, Model model) {
        
        if (result.hasErrors()) {
            return "album/newpage";
        }

        Path path = imageFileManager.create();

        try {
            mpf.transferTo(path);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        Profile profile = modelMapper.map(profileForm, Profile.class);
        String employeeId = profile.getEmployeeId();
        if (pageService.isRegisteredProfile(employeeId)) {
            String[] phAry = new String[] { employeeId };
            String errorMsg = msg.getMessage("profileAlreadyExistMsg", phAry, Locale.JAPANESE);
            model.addAttribute("profileAlreadyExistError", errorMsg);
            return "album/newpage";
        }

        List<Career> allCareers = profileForm.getAllCareers().stream().filter(h -> h.getEvent() != null).map(h -> {
            Career career = modelMapper.map(h, Career.class);
            career.setEmployeeId(profileForm.getEmployeeId());
            return career;
        }).collect(Collectors.toList());

        profile.setProfileImageFilename(path.getFileName().toString());

        pageService.register(profile, allCareers);
        return "redirect:/album";
    }

}
