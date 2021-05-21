package br.com.zupacademy.frederico.casadocodigo.annotation;


import br.com.zupacademy.frederico.casadocodigo.annotation.validator.NotNullIfCountryHasStateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.TYPE;

@Constraint(validatedBy = NotNullIfCountryHasStateValidator.class)
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNullIfCountryHasState {
    String message() default "Um Estado precisa ser selecionado";

    Class<?>[] groups() default {};

    Class<?  extends Payload>[] payload() default {};
}
