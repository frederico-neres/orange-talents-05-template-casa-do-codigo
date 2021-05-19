package br.com.zupacademy.frederico.casadocodigo.repository;

import br.com.zupacademy.frederico.casadocodigo.model.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    Boolean existsByNome(String nome);
}
