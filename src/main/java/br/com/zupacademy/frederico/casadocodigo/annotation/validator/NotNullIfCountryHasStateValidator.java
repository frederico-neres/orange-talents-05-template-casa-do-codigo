package br.com.zupacademy.frederico.casadocodigo.annotation.validator;

import br.com.zupacademy.frederico.casadocodigo.annotation.NotNullIfCountryHasState;
import br.com.zupacademy.frederico.casadocodigo.dto.ClienteInputDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class NotNullIfCountryHasStateValidator implements ConstraintValidator<NotNullIfCountryHasState, ClienteInputDTO> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean isValid(ClienteInputDTO clienteInputDTO, ConstraintValidatorContext constraintValidatorContext) {

        Long idPais = clienteInputDTO.getIdPais();
        Long idEstado = clienteInputDTO.getIdEstado();

        String jpql = "select 1 from Estado e where e.pais.id = :id";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("id", idPais);
        List<?> list = query.getResultList();

        Boolean temEstados = !list.isEmpty();
        Boolean idEstadoValid =  temEstados && idEstado == null? false:true;

        if(idEstado != null) {
            jpql = "select 1 from Estado e where e.pais.id = :idpais and e.id = :id";
            query = entityManager.createQuery(jpql);
            query.setParameter("idpais", idPais);
            query.setParameter("id", idEstado);
            list = query.getResultList();

            idEstadoValid = !list.isEmpty();
        }

        return idEstadoValid;
    }
}
