package br.com.zupacademy.frederico.casadocodigo.dto;

import br.com.zupacademy.frederico.casadocodigo.model.Autor;

public class AutorLivroDetalhesDTO {

    private String nome;
    private String descricao;

    public AutorLivroDetalhesDTO(Autor autor) {
        nome = autor.getNome();
        descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
