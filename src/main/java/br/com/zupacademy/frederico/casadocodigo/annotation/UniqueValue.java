package br.com.zupacademy.frederico.casadocodigo.annotation;

import br.com.zupacademy.frederico.casadocodigo.annotation.validator.UniqueValueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueValueValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {

    String message() default "";

    Class<?>[] groups() default {};

    Class<?  extends Payload>[] payload() default {};

    String  fieldName();

    Class<?> domainClass();
}
