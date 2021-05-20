package br.com.zupacademy.frederico.casadocodigo.dto;

import br.com.zupacademy.frederico.casadocodigo.annotation.AlreadyExists;
import br.com.zupacademy.frederico.casadocodigo.annotation.UniqueValue;
import br.com.zupacademy.frederico.casadocodigo.model.Estado;
import br.com.zupacademy.frederico.casadocodigo.model.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoInputDTO {

    @NotBlank
    @UniqueValue(fieldName = "nome",
            domainClass = Estado.class,
            message = "Já existe um estado cadastrado com esse nome")
    private String nome;
    @NotNull
    @AlreadyExists(fieldName = "id", domainClass = Pais.class)
    private Long idPais;


    public EstadoInputDTO(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }


    public Estado toModel(EntityManager entityManager) {
        Pais pais = entityManager.find(Pais.class, idPais);

        return new Estado(nome, pais);
    }
}
