package br.com.zupacademy.frederico.casadocodigo.annotation.validator;

import br.com.zupacademy.frederico.casadocodigo.annotation.UniqueStateForCountry;
import br.com.zupacademy.frederico.casadocodigo.dto.EstadoInputDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueStateForCountryValidator implements ConstraintValidator<UniqueStateForCountry, EstadoInputDTO> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean isValid(EstadoInputDTO estadoInputDTO, ConstraintValidatorContext constraintValidatorContext) {
        String nome = estadoInputDTO.getNome();
        Long idPais = estadoInputDTO.getIdPais();

        String jpql = "select e from Estado e where e.nome = :nome and e.pais.id = :id";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("nome", nome);
        query.setParameter("id", idPais);

        List<?> list = query.getResultList();

        return list.isEmpty();
    }
}
