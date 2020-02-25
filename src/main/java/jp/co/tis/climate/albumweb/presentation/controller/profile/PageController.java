package jp.co.tis.climate.albumweb.presentation.controller.profile;

import jp.co.tis.climate.albumweb.domain.code.BloodType;
import jp.co.tis.climate.albumweb.domain.model.member.Profile;
import jp.co.tis.climate.albumweb.presentation.dto.PageContent;
import jp.co.tis.climate.albumweb.presentation.form.CareerForm;
import jp.co.tis.climate.albumweb.presentation.form.ProfileForm;
import jp.co.tis.climate.albumweb.infrastructure.manager.ImageFileManager;
import jp.co.tis.climate.albumweb.domain.model.member.Career;
import jp.co.tis.climate.albumweb.application.service.profile.PageService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("album")
public class PageController {

    private final PageService pageService;

    private final ImageFileManager imageFileManager;

    private final ModelMapper modelMapper;

    public PageController(PageService pageService,
                          ImageFileManager imageFileManager,
                          ModelMapper modelMapper) {
        this.pageService = pageService;
        this.imageFileManager = imageFileManager;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{employeeId}")
    public String view(@PathVariable String employeeId, Model model) {
        if (!pageService.isRegisteredProfile(employeeId)) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        PageContent pageContent = pageService.getPageContentByEmployeeId(employeeId);
        Profile profile = pageContent.getProfile();
        model.addAttribute("profile", profile);
        model.addAttribute("allCareers", pageContent.getAllCareers());
        //entityを修正したためコメントアウト
        /*Optional.ofNullable(profile.getJoiningYear())
                .filter(StringUtils::hasText)
                .ifPresent(year -> model.addAttribute("yearly", Year.now().getValue() - Integer.parseInt(year) + 1));*/
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
        profileForm.setAllCareers(IntStream.range(1, 11).mapToObj(i -> {
            CareerForm career = new CareerForm();
            career.setCareerId(String.valueOf(i));
            return career;
        }).collect(Collectors.toList()));

        model.addAttribute("profileForm", profileForm);
        model.addAttribute("bloodTypeList", BloodType.values());

        return "login";
    }

    // TODO 画像をプレビューする機能はバックログに追加
    // TODO 一旦一度にアップロードすることにして、このメソッドは削除

    @PostMapping(value = "/newpage")
    public String submit(@ModelAttribute @Validated ProfileForm profileForm, BindingResult result, HttpServletRequest request) throws ServletException {
        
        if (result.hasErrors()) {
            return "album/newpage";
        }

        Path path = null;

        try {
            if (!profileForm.getProfileImage().isEmpty()) {
                path = imageFileManager.create();
                profileForm.getProfileImage().transferTo(path);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        Profile profile = modelMapper.map(profileForm, Profile.class);
        String employeeId = profile.getEmployeeId();
        if (pageService.isRegisteredProfile(employeeId)) {
            String[] phAry = new String[] { employeeId };
            result.rejectValue("employeeId", "profileAlreadyExistMsg", phAry, "");
            return "album/newpage";
        }

        //entityを修正したためコメントアウト
        /*List<Career> allCareers = profileForm.getAllCareers()
                .stream()
                .filter(c -> StringUtils.hasText(c.getEvent())
                        && StringUtils.hasText(c.getYear())
                        && StringUtils.hasText(c.getMonth()))
                .map(h -> {
                    Career career = modelMapper.map(h, Career.class);
                    career.setEmployeeId(profileForm.getEmployeeId());
                    return career;
                })
                .collect(Collectors.toList());*/
        List<Career> allCareers = null;

        //entityを修正したためコメントアウト
        /*profile.setProfileImageFilename(Optional.ofNullable(path)
                .map(Path::getFileName)
                .map(Path::toString)
                .orElse(null));*/

        pageService.register(profile, allCareers, profileForm.getPassword());
        request.login(profileForm.getEmployeeId(), profileForm.getPassword());

        return "redirect:/album/" + profile.getEmployeeId();
    }


    @GetMapping("/edit/{employeeId}")
    public String editView(@PathVariable String employeeId, Model model) {
        if (!pageService.isRegisteredProfile(employeeId)) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        PageContent pageContent = pageService.getPageContentByEmployeeId(employeeId);
        ProfileForm profileForm = modelMapper.map(pageContent.getProfile(), ProfileForm.class);
        profileForm.setAllCareers(IntStream.range(1, 11).mapToObj(i -> {
            CareerForm career = new CareerForm();
            career.setCareerId(String.valueOf(i));
            return career;
        }).collect(Collectors.toList()));

        model.addAttribute("profileForm", profileForm);
        //model.addAttribute("profileImageFilename", pageContent.getProfile().getProfileImageFilename()); //entityを修正したためコメントアウト

        return "album/edit";
    }
}
