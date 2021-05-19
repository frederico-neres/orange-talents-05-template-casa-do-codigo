package br.com.zupacademy.frederico.casadocodigo.controller;

import br.com.zupacademy.frederico.casadocodigo.dto.CategoriaInputDTO;
import br.com.zupacademy.frederico.casadocodigo.model.Categoria;
import br.com.zupacademy.frederico.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.frederico.casadocodigo.validator.NomeDuplicadoValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @InitBinder("categoriaInputDTO")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new NomeDuplicadoValidator(categoriaRepository));
    }

    @PostMapping
    public ResponseEntity<?> salvarCategoria(@RequestBody @Valid CategoriaInputDTO categoriaInputDTO) {
        Categoria categoria = categoriaInputDTO.toModel();
        categoriaRepository.save(categoria);

        return  ResponseEntity.ok(null);
    }
}
