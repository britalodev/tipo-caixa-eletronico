package com.treinamento.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_CLIENTE_PF")
public class ClientePF extends Cliente{


	/**
	 * 
	 */
	private static final long serialVersionUID = 6561172887498911526L;

	@Length(max = 11, message = "RG não pode ter mais que {max} caracteres")
	@Column(name = "rg", length = 11, nullable = true)
	private String rg;

	@Length(max = 11, message = "CPF não pode ter mais que {max} caracteres")
	@CPF(message = "CPF deve ser válido")
	@NotEmpty(message = "CPF não pode ser nulo")
	@Column(name = "cpf", length = 11, nullable = false)
	private String cpf;

	@JsonFormat(pattern = "d/MM/yyyy")
	@JsonProperty("data_nascimento")
	@Column(name = "data_nascimento", nullable = false)
	@NotNull(message = "Data de nascimento não pode ser nulo")
	private LocalDate dataNascimento;

	@NotEmpty(message = "Banco não pode ser nulo")
	private String banco;
	
	@JsonFormat(pattern = "d/MM/yyyy")
	@JsonProperty("data_adesao")
	@Column(name = "data_adesao", nullable = false)
	@NotNull(message = "Data de adesão não pode ser nulo")
	private LocalDate dataAdesao;

}
