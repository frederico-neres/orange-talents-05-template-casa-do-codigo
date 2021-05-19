package br.com.zupacademy.frederico.casadocodigo.model;

import br.com.zupacademy.frederico.casadocodigo.annotation.AlreadyExists;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Autor autor;

    public Livro( @NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
                  @NotNull @Min(20) BigDecimal preco, @Min(100) Integer numeroPaginas, @NotBlank @ISBN String isbn,
                  @Future OffsetDateTime dataPublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }
}
