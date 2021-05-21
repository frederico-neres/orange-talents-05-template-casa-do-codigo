package br.com.zupacademy.frederico.casadocodigo.controller;

import br.com.zupacademy.frederico.casadocodigo.dto.ClienteInputDTO;
import br.com.zupacademy.frederico.casadocodigo.dto.ClienteOutputDTO;
import br.com.zupacademy.frederico.casadocodigo.model.Cliente;
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
@RequestMapping("/api/clientes")
public class ClienteController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> salvarCliente(@RequestBody @Valid ClienteInputDTO clienteInputDTO) {
        Cliente cliente = clienteInputDTO.toModel(entityManager);
        entityManager.persist(cliente);

        return ResponseEntity.ok(new ClienteOutputDTO(cliente));
    }
}
