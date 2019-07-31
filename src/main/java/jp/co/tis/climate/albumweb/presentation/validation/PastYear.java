package jp.co.tis.climate.albumweb.presentation.validation;

import org.springframework.util.StringUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.time.DateTimeException;
import java.time.Year;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = PastYear.UploadFileRequiredValidator.class)
@Repeatable(PastYear.List.class)
public @interface PastYear {

    String message() default "{jp.co.tis.climate.albumweb.presentation.validation.PastYear.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        PastYear[] value();
    }

    class UploadFileRequiredValidator implements
            ConstraintValidator<PastYear, String> {

        @Override
        public void initialize(PastYear constraint) {
        }

        @Override
        public boolean isValid(String year,
                               ConstraintValidatorContext context) {
            if (StringUtils.isEmpty(year)) {
                return true;
            }
            try {
                Year y = Year.of(Integer.parseInt(year));
                return y.getValue() <= Year.now().getValue();
            } catch (NumberFormatException | DateTimeException e) {
                return false;
            }
        }

    }
}
