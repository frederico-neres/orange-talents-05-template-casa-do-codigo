package br.com.zupacademy.frederico.casadocodigo.dto;

import br.com.zupacademy.frederico.casadocodigo.annotation.UniqueValue;
import br.com.zupacademy.frederico.casadocodigo.model.Autor;
import br.com.zupacademy.frederico.casadocodigo.model.Categoria;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorInputDTO {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @UniqueValue(fieldName = "email",
            domainClass = Autor.class,
            message = "Já existe um(a) autor(a) cadastrado(a) com esse e-mail")
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public AutorInputDTO(@NotBlank String nome, @NotBlank @Email String email,
                         @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toEntity() {
        return new Autor(nome, email, descricao);
    }

    public String getEmail() {
        return email;
    }
}
