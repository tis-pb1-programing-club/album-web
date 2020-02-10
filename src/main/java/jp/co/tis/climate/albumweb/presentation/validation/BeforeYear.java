package jp.co.tis.climate.albumweb.presentation.validation;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
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
import java.util.Arrays;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = BeforeYear.BeforeYearValidator.class)
@Repeatable(BeforeYear.List.class)
public @interface BeforeYear {

    String message() default "{jp.co.tis.climate.albumweb.presentation.validation.BeforeYear.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        BeforeYear[] value();
    }

    class BeforeYearValidator implements
            ConstraintValidator<BeforeYear, String> {

        @Override
        public void initialize(BeforeYear constraint) {
        }

        @Override
        public boolean isValid(String year,
                               ConstraintValidatorContext context) {
            if (StringUtils.isEmpty(year)) {
                return true;
            }
            Year thisYear = Year.now();
            context.unwrap(HibernateConstraintValidatorContext.class)
                    .addExpressionVariable("thisYear", thisYear);
            try {
                Year y = Year.of(Integer.parseInt(year));
                return y.getValue() <= thisYear.getValue();
            } catch (NumberFormatException | DateTimeException e) {
                return false;
            }
        }

    }
}
