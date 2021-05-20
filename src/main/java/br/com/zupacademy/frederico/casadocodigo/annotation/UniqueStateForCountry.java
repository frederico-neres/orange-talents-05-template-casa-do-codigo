package br.com.zupacademy.frederico.casadocodigo.annotation;

import br.com.zupacademy.frederico.casadocodigo.annotation.validator.UniqueStateForCountryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueStateForCountryValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueStateForCountry {

    String message() default "Já existe um estado cadastrado com esse nome para esse país";

    Class<?>[] groups() default {};

    Class<?  extends Payload>[] payload() default {};
}
