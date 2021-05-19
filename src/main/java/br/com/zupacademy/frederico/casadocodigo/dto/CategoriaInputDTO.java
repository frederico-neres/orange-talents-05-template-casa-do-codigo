package br.com.zupacademy.frederico.casadocodigo.dto;

import br.com.zupacademy.frederico.casadocodigo.annotation.UniqueValue;
import br.com.zupacademy.frederico.casadocodigo.model.Categoria;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CategoriaInputDTO {

    @NotBlank
    @UniqueValue(fieldName = "nome",
            domainClass = Categoria.class,
            message = "Já existe uma categoria cadastrada com esse nome")
    private String nome;

    @JsonCreator
    public CategoriaInputDTO(@NotBlank @JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public Categoria toModel() {
        return  new Categoria(nome);
    }

    public String getNome() {
        return nome;
    }
}
