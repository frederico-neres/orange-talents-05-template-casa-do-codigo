package br.com.zupacademy.frederico.casadocodigo.handler.dto;

import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class ArgumentNotValidExceptionDTO {
    private List<ErrorDetails> errors;

    public ArgumentNotValidExceptionDTO(List<FieldError> fieldErros) {
        errors = new ArrayList<>();
        fieldErros.stream().forEach(error -> {
            errors.add(new ErrorDetails(error.getField(), error.getDefaultMessage()));
        });

    }

    public List<ErrorDetails> getErrors() {
        return errors;
    }
}
