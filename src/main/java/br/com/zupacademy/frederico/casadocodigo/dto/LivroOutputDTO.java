package br.com.zupacademy.frederico.casadocodigo.dto;

import br.com.zupacademy.frederico.casadocodigo.model.Livro;

public class LivroOutputDTO {
    private Long id;
    private String titulo;

    public LivroOutputDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
