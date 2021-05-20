package br.com.zupacademy.frederico.casadocodigo.controller;

import br.com.zupacademy.frederico.casadocodigo.dto.PaisInputDTO;
import br.com.zupacademy.frederico.casadocodigo.model.Pais;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> salvarPais(@RequestBody @Valid PaisInputDTO paisInputDTO) {

        Pais pais = paisInputDTO.toModel();
        entityManager.persist(pais);

        return ResponseEntity.ok(null);
    }
}
