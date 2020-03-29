package jp.co.tis.climate.albumweb.presentation.form;

import jp.co.tis.climate.albumweb.domain.code.City;
import jp.co.tis.climate.albumweb.domain.code.Recruit;
import jp.co.tis.climate.albumweb.presentation.validation.AllowMimeType;
import jp.co.tis.climate.albumweb.presentation.validation.MimeType;
import jp.co.tis.climate.albumweb.presentation.validation.UploadFileMaxSize;
import jp.co.tis.climate.albumweb.presentation.validation.UploadFileNotEmpty;
import jp.co.tis.climate.albumweb.presentation.validation.UploadFileRequired;
import jp.co.tis.climate.albumweb.presentation.validation.BeforeYear;
import jp.co.tis.climate.albumweb.presentation.validation.EmployeeId;
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
    //@NotEmpty
    @EmployeeId
    private String employeeId;
    
    //@NotEmpty
    private String password;

    @UploadFileRequired
    @UploadFileNotEmpty
    @UploadFileMaxSize
    @AllowMimeType(allowTypes = { MimeType.JPEG })
    private MultipartFile profileImage;

    //姓・名から姓名に変更
    //@NotEmpty
    @Size(min = 1, max = 20)
    private String fullName;

    @BeforeYear
    private String joiningYear;

    //辞書と違っていたのでsex⇒genderへ変更
    //@NotEmpty
    @Size(min = 1, max = 1)
    private String genderId;

    @Size(min = 0, max = 1)
    private String bloodTypeId;

    @Size(min = 0, max = 30)
    private String teamId;

    //customerは不要
//    @Size(min = 0, max = 30)
//    private String customer;

    @Size(min = 0, max = 30)
    private String project;

    @Size(min = 0, max = 300)
    private String privateSentence;

    @Size(min = 0, max = 200)
    private String comment;

    //なかったので追加
    private String recruitId;

    //@Valid
    private List<CareerForm> allCareers;

    //なかったので追加
    private String cityId;
}
