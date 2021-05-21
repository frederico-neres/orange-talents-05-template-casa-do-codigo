package br.com.zupacademy.frederico.casadocodigo.dto;

import br.com.zupacademy.frederico.casadocodigo.annotation.CPFOrCNPJ;
import br.com.zupacademy.frederico.casadocodigo.annotation.NotNullIfCountryHasState;
import br.com.zupacademy.frederico.casadocodigo.annotation.UniqueValue;
import br.com.zupacademy.frederico.casadocodigo.model.Cliente;
import br.com.zupacademy.frederico.casadocodigo.model.Estado;
import br.com.zupacademy.frederico.casadocodigo.model.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NotNullIfCountryHasState
public class ClienteInputDTO {
    @Email
    @UniqueValue(fieldName = "email",
            domainClass = Cliente.class,
            message = "Já existe um(a) cliente(a) cadastrado(a) com esse e-mail")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @UniqueValue(fieldName = "documento",
            domainClass = Cliente.class,
            message = "Já existe um(a) cliente(a) cadastrado(a) com esse documento")
    @CPFOrCNPJ
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    private Long idPais;
    private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;


    public ClienteInputDTO(String email, String nome, String sobrenome, String documento, String endereco,
                           String complemento, String cidade, Long idPais, Long idEstado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public Cliente toModel(EntityManager entityManager) {
        Pais pais = (Pais) entityManager.find(Pais.class, idPais);
        Estado estado = null;

        if(idEstado != null)
            estado = entityManager.find(Estado.class, idEstado);

        return new Cliente(email, nome, sobrenome, documento, endereco,
                complemento, cidade, pais, estado, telefone, cep);
    }
}
