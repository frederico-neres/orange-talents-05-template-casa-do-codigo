package br.com.zupacademy.frederico.casadocodigo.dto;

import br.com.zupacademy.frederico.casadocodigo.annotation.UniqueValue;
import br.com.zupacademy.frederico.casadocodigo.model.Autor;
import br.com.zupacademy.frederico.casadocodigo.model.Pais;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class PaisInputDTO {

    @NotBlank
    @UniqueValue(fieldName = "nome",
            domainClass = Pais.class,
            message = "Já existe um país cadastrado com esse nome")
    private String nome;

    @JsonCreator
    public PaisInputDTO(@JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public Pais toModel() {
        return new Pais(nome);
    }
}
