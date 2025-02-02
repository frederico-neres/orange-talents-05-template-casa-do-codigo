package br.com.zupacademy.frederico.casadocodigo.controller;

import br.com.zupacademy.frederico.casadocodigo.dto.CategoriaInputDTO;
import br.com.zupacademy.frederico.casadocodigo.model.Categoria;
import br.com.zupacademy.frederico.casadocodigo.repository.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<?> salvarCategoria(@RequestBody @Valid CategoriaInputDTO categoriaInputDTO) {
        Categoria categoria = categoriaInputDTO.toModel();
        categoriaRepository.save(categoria);

        return  ResponseEntity.ok(null);
    }
}
