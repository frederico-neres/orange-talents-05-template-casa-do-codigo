package br.com.zupacademy.frederico.casadocodigo.controller;

import br.com.zupacademy.frederico.casadocodigo.dto.LivroInputDTO;
import br.com.zupacademy.frederico.casadocodigo.dto.LivroOutputDTO;
import br.com.zupacademy.frederico.casadocodigo.model.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @PersistenceContext
    EntityManager entityManager;

    @GetMapping
    public ResponseEntity<List<LivroOutputDTO>> buscarLivros() {
        String jpql = "SELECT l FROM Livro l";
        Query query = entityManager.createQuery(jpql);

        List<Livro> list = query.getResultList();
        List<LivroOutputDTO> listaLivros = new ArrayList<>();

        for (Livro livro: list) {
            listaLivros.add(new LivroOutputDTO(livro));
        }

        return ResponseEntity.ok(listaLivros);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> salvarLivro(@RequestBody @Valid LivroInputDTO livroInputDTO) {
        Livro livro = livroInputDTO.toModel(entityManager);
        entityManager.persist(livro);

        return ResponseEntity.ok(null);
    }
}
