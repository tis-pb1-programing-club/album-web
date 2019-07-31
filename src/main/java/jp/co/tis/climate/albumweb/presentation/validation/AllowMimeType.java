package jp.co.tis.climate.albumweb.presentation.validation;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = AllowMimeType.AllowMimeTypeValidator.class)
@Repeatable(AllowMimeType.List.class)
public @interface AllowMimeType {

    String message() default "{jp.co.tis.climate.albumweb.presentation.validation.AllowMimeType.message}";
    MimeType[] allowTypes();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        AllowMimeType[] value();
    }

    class AllowMimeTypeValidator implements
            ConstraintValidator<AllowMimeType, MultipartFile> {

        AllowMimeType constraint;

        @Override
        public void initialize(AllowMimeType constraint) {
            this.constraint = constraint;
        }

        @Override
        public boolean isValid(MultipartFile multipartFile,
                               ConstraintValidatorContext context) {
            if (multipartFile == null ||
                    !StringUtils.hasLength(multipartFile.getOriginalFilename())) {
                return true;
            }
            for (MimeType type : constraint.allowTypes()) {
                try (InputStream is = multipartFile.getInputStream()) {
                    byte[] magicNumber = new byte[type.getMagicNumberLength()];
                    int rb = is.read(magicNumber);
                    if (rb != type.getMagicNumberLength()) {
                        continue;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b : magicNumber) {
                        sb.append(String.format("%02x", b));
                    }

                    String string = sb.toString();
                    Set<String> allowMagicNumbers = new HashSet<>(Arrays.asList(type.getMagicNumbers()));
                    if (allowMagicNumbers.contains(string.toUpperCase())) {
                        // OK
                        return true;
                    }
                } catch (IOException e) {
                    // nop
                }
            }
            return false;
        }

    }
}
