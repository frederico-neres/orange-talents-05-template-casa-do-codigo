package br.com.zupacademy.frederico.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.OffsetDateTime;

@Entity

public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    @NotNull
    private OffsetDateTime createdAt = OffsetDateTime.now();

    public Autor( @NotBlank String nome, @NotBlank @Email String email,
                 @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
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
