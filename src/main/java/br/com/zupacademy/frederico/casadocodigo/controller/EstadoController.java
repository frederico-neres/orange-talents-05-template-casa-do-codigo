package br.com.zupacademy.frederico.casadocodigo.controller;

import br.com.zupacademy.frederico.casadocodigo.dto.EstadoInputDTO;
import br.com.zupacademy.frederico.casadocodigo.model.Estado;
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
@RequestMapping("/api/estados")
public class EstadoController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> salvarEstado(@RequestBody @Valid EstadoInputDTO estadoInputDTO) {

        Estado estado = estadoInputDTO.toModel(entityManager);
        entityManager.persist(estado);

        return ResponseEntity.ok(null);
    }
}
