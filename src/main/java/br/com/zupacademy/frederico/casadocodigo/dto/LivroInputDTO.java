package br.com.zupacademy.frederico.casadocodigo.dto;

import br.com.zupacademy.frederico.casadocodigo.annotation.AlreadyExists;
import br.com.zupacademy.frederico.casadocodigo.model.Autor;
import br.com.zupacademy.frederico.casadocodigo.model.Categoria;
import br.com.zupacademy.frederico.casadocodigo.model.Livro;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.EntityManager;
import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class LivroInputDTO {

    @NotBlank
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @NotBlank
    @Lob
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @Min(100)
    private Integer numeroPaginas;
    @NotBlank
    @ISBN
    private String isbn;
    @Future
    private OffsetDateTime dataPublicacao;
    @AlreadyExists(fieldName = "id", domainClass = Categoria.class)
    private Long idCategoria;
    @AlreadyExists(fieldName = "id", domainClass = Autor.class)
    private Long idAutor;

    public LivroInputDTO(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
                         @NotNull @Min(20) BigDecimal preco, @Min(100) Integer numeroPaginas, @NotBlank @ISBN String isbn,
                         @Future OffsetDateTime dataPublicacao, Long idCategoria, Long idAutor) {

        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public Livro toModel(EntityManager entityManager) {
        Categoria categoria = entityManager.find(Categoria.class, idCategoria);
        Autor autor = entityManager.find(Autor.class, idAutor);

        return new Livro(titulo, resumo, sumario, preco, numeroPaginas,
                isbn, dataPublicacao,  categoria, autor);
    }
}
