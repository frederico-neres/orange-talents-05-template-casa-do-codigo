package br.com.zupacademy.frederico.casadocodigo.controller;

import br.com.zupacademy.frederico.casadocodigo.dto.LivroDetalhesDTO;
import br.com.zupacademy.frederico.casadocodigo.model.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @PersistenceContext
    EntityManager entityManager;

    @GetMapping("/{id}")
    public ResponseEntity<?> exibirDetalhes(@PathVariable Long id) {
        Livro livro = entityManager.find(Livro.class, id);

        if(livro == null) {
            return ResponseEntity.notFound().build();
        }

        return  ResponseEntity.ok(new LivroDetalhesDTO(livro));
    }
}
