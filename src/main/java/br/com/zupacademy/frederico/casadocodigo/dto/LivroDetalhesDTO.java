package br.com.zupacademy.frederico.casadocodigo.dto;

import br.com.zupacademy.frederico.casadocodigo.model.Livro;

import java.math.BigDecimal;

public class LivroDetalhesDTO {

    private String sumario;
    private Integer numeroPaginas;
    private BigDecimal preco;
    private String resumo;
    private String isbn;
    private AutorLivroDetalhesDTO autor;
    private String titulo;

    public LivroDetalhesDTO(Livro livro) {
        titulo = livro.getTitulo();
        autor = new AutorLivroDetalhesDTO(livro.getAutor());
        isbn = livro.getIsbn();
        numeroPaginas = livro.getNumeroPaginas();
        preco = livro.getPreco();
        resumo = livro.getResumo();
        sumario = livro.getSumario();
    }

    public String getSumario() {
        return sumario;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getIsbn() {
        return isbn;
    }

    public AutorLivroDetalhesDTO getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }
}
