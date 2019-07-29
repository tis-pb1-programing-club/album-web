package jp.co.tis.climate.albumweb.presentation.validation;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = UploadFileNotEmpty.UploadFileNotEmptyValidator.class)
@Repeatable(UploadFileNotEmpty.List.class)
public @interface UploadFileNotEmpty {

    String message() default "{jp.co.tis.climate.albumweb.presentation.validation.UploadFileNotEmpty.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        UploadFileNotEmpty[] value();
    }

    class UploadFileNotEmptyValidator implements
            ConstraintValidator<UploadFileNotEmpty, MultipartFile> {

        @Override
        public void initialize(UploadFileNotEmpty constraint) {
        }

        @Override
        public boolean isValid(MultipartFile multipartFile,
                               ConstraintValidatorContext context) {
            if (multipartFile == null ||
                    !StringUtils.hasLength(multipartFile.getOriginalFilename())) {
                return true;
            }
            return !multipartFile.isEmpty();
        }
    }
}
