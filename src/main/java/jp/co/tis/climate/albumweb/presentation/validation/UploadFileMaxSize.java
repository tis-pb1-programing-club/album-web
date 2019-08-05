package jp.co.tis.climate.albumweb.presentation.validation;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
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
@Constraint(validatedBy = UploadFileMaxSize.UploadFileMaxSizeValidator.class)
@Repeatable(UploadFileMaxSize.List.class)
public @interface UploadFileMaxSize {

    String message() default "{jp.co.tis.climate.albumweb.presentation.validation.UploadFileMaxSize.message}";
    long value() default (1024 * 1024);
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        UploadFileMaxSize[] value();
    }

    class UploadFileMaxSizeValidator implements
            ConstraintValidator<UploadFileMaxSize, MultipartFile> {

        private UploadFileMaxSize constraint;

        @Override
        public void initialize(UploadFileMaxSize constraint) {
            this.constraint = constraint;
        }

        @Override
        public boolean isValid(MultipartFile multipartFile,
                               ConstraintValidatorContext context) {
            if (constraint.value() < 0 || multipartFile == null) {
                return true;
            }
            HibernateConstraintValidatorContext hcon = context.unwrap(HibernateConstraintValidatorContext.class);
            hcon.addExpressionVariable("kb", constraint.value() + "B" );
            hcon.addExpressionVariable("kb", (constraint.value() / 1024) + "KB" );
            hcon.addExpressionVariable("mb", (constraint.value() / (1024 * 1024)) + "MB");
            return multipartFile.getSize() <= constraint.value();
        }

    }
}
