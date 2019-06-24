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

    @PostMapping(value = "/newpage", params = "addCareer")
    public String addCareer(@ModelAttribute ProfileForm profileForm, Model model) {
        List<CareerForm> allCareers = profileForm.getAllCareers();
        String careerId = String.valueOf(allCareers.size() + 1);

        CareerForm career = new CareerForm();
        career.setCareerId(careerId);
        allCareers.add(career);
        profileForm.setAllCareers(allCareers);

        model.addAttribute("profileForm", profileForm);

        return "album/newpage";
    }

    @PostMapping(value = "/newpage", params = "addImage")
    public String addProfileImage(@ModelAttribute ProfileForm profileForm,
            @RequestParam("profileImage") MultipartFile mpf, Model model) {
        if (mpf.isEmpty()) {
            model.addAttribute("profileForm", profileForm);
            return "album/newpage";
        }

        String profileImageFilename = profileForm.getProfileImageFilename();
        try {
            Path uploadFile;
            if (profileImageFilename.isEmpty()) {
                uploadFile = imageFileManager.create();
                profileImageFilename = uploadFile.getFileName().toString();
            } else {
                uploadFile = imageFileManager.get(profileImageFilename)
                        .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
            }
            mpf.transferTo(uploadFile);
        } catch (IOException e) {
            // TODO: IOException発生時の挙動を実装する
            model.addAttribute("profileForm", profileForm);
            return "album/newpage";
        }

        profileForm.setProfileImageFilename(profileImageFilename);

        model.addAttribute("profileForm", profileForm);

        return "album/newpage";
    }

    @PostMapping(value = "/newpage", params = "submit")
    public String submit(@ModelAttribute @Validated ProfileForm profileForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "album/newpage";
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

        pageService.register(profile, allCareers);
        return "redirect:/album";
    }

}
