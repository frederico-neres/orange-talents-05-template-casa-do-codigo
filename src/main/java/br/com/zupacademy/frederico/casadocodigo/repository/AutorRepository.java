package br.com.zupacademy.frederico.casadocodigo.repository;

import br.com.zupacademy.frederico.casadocodigo.model.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {

}
