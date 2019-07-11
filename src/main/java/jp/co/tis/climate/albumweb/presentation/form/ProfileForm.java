package jp.co.tis.climate.albumweb.presentation.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.List;

@Setter
@Getter
public class ProfileForm {
    // TODO: パートナさんにも対応できるようにする。現状、数値以外が入るとdomaで変換エラーが発生
    // @Pattern(regexp="[kK\\d]\\d{5}")
    @NotEmpty
    @Pattern(regexp = "\\d{6}")
    private String employeeId;

    /** TODO
     *  Validation を追加する。
     *  http://terasolunaorg.github.io/guideline/5.5.1.RELEASE/ja/ArchitectureInDetail/WebApplicationDetail/FileUpload.html#bean-validation
     */
    private MultipartFile profileImage;

    @NotEmpty
    @Size(min = 1, max = 20)
    private String lastName;

    @NotEmpty
    @Size(min = 1, max = 20)
    private String firstName;

    @Size(min = 0, max = 2)
    private String yearly;

    @NotEmpty
    @Size(min = 1, max = 1)
    private String sex;

    @Size(min = 0, max = 1)
    private String bloodType;

    @Size(min = 0, max = 30)
    private String team;

    @Size(min = 0, max = 30)
    private String customer;

    @Size(min = 0, max = 30)
    private String project;

    @Size(min = 0, max = 300)
    private String privateSentence;

    @Size(min = 0, max = 200)
    private String comment;

    @Valid
    private List<CareerForm> allCareers;
}
