package br.com.zupacademy.frederico.casadocodigo.dto;

import br.com.zupacademy.frederico.casadocodigo.model.Cliente;

public class ClienteOutputDTO {
    private Long id;

    public ClienteOutputDTO(Cliente cliente) {
        this.id = cliente.getId();
    }

    public Long getId() {
        return id;
    }
}
