package br.com.zupacademy.frederico.casadocodigo.dto;

import br.com.zupacademy.frederico.casadocodigo.model.Autor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;

public class AutorOutputDTO {

    private String nome;
    private String email;
    private String descricao;
    private OffsetDateTime createdAt = OffsetDateTime.now();

    public AutorOutputDTO(Autor autor) {
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.createdAt = autor.getCreatedAt();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
}
