package br.com.zupacademy.frederico.casadocodigo.validator;

import br.com.zupacademy.frederico.casadocodigo.dto.AutorInputDTO;
import br.com.zupacademy.frederico.casadocodigo.model.Autor;
import br.com.zupacademy.frederico.casadocodigo.repository.AutorRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class EmailDuplicadoValidator implements Validator {

    private AutorRepository autorRepository;
    public EmailDuplicadoValidator(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return AutorInputDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AutorInputDTO autorInputDTO = (AutorInputDTO) o;
        Boolean existsAutor = autorRepository.existsByEmail(autorInputDTO.getEmail());

        if(existsAutor) {
            errors.rejectValue("email", null, "Já existe um(a) autor(a) cadastrado(a) com esse e-mail");
        }

    }
}
