package br.com.zupacademy.frederico.casadocodigo.validator;

import br.com.zupacademy.frederico.casadocodigo.dto.CategoriaInputDTO;
import br.com.zupacademy.frederico.casadocodigo.repository.CategoriaRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NomeDuplicadoValidator implements Validator {

    private CategoriaRepository categoriaRepository;
    public NomeDuplicadoValidator(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoriaInputDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CategoriaInputDTO categoriaInputDTO = (CategoriaInputDTO) o;
        Boolean existsNome = categoriaRepository.existsByNome(categoriaInputDTO.getNome());

        if(existsNome) {
            errors.rejectValue("nome", null, "Já uma categoria cadastrada com esse nome");
        }
    }
}
