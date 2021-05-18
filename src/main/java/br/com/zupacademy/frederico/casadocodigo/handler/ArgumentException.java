package br.com.zupacademy.frederico.casadocodigo.handler;

import br.com.zupacademy.frederico.casadocodigo.handler.dto.ArgumentNotValidExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ArgumentException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
  public ArgumentNotValidExceptionDTO argumentNotValidException(MethodArgumentNotValidException exception) {
        System.out.println("Passa aqui");
        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> fieldErros = bindingResult.getFieldErrors();

        ArgumentNotValidExceptionDTO argumentNotValidException =
                new ArgumentNotValidExceptionDTO(fieldErros);
        return argumentNotValidException;
    }
}
