package br.com.zupacademy.frederico.casadocodigo.handler.dto;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class ArgumentNotValidExceptionDTO {
    private List<ErrorDetails> errors;

    public ArgumentNotValidExceptionDTO(List<FieldError> fieldErros, List<ObjectError> globalErrors) {
        errors = new ArrayList<>();
        fieldErros.stream().forEach(error -> {
            errors.add(new ErrorDetails(error.getField(), error.getDefaultMessage()));
        });

        globalErrors.stream().forEach(error -> {
            errors.add(new ErrorDetails(null, error.getDefaultMessage()));
        });

    }

    public List<ErrorDetails> getErrors() {
        return errors;
    }
}
