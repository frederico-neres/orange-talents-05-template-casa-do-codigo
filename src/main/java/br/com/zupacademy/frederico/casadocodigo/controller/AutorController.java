package br.com.zupacademy.frederico.casadocodigo.controller;

import br.com.zupacademy.frederico.casadocodigo.dto.AutorInputDTO;
import br.com.zupacademy.frederico.casadocodigo.model.Autor;
import br.com.zupacademy.frederico.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.frederico.casadocodigo.validator.EmailDuplicadoValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @InitBinder("autorInputDTO")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new EmailDuplicadoValidator(autorRepository));
    }

    @PostMapping
    public ResponseEntity<?> salvarAutor(@RequestBody @Valid AutorInputDTO inputDTO) {
        Autor autor = inputDTO.toEntity();
        autor = autorRepository.save(autor);

        return ResponseEntity.ok(null);
    }

}
