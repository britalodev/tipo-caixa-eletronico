package com.treinamento.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_CONTA")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Conta implements Serializable {
	
	//TODO: Validacoes dos campos da tabela CONTA

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliete_pj")
	@SequenceGenerator(allocationSize = 1, name = "seq_cliente_pj", sequenceName = "seq_cliente_pj")
	private Long id;

	private Integer agencia;
	
	@JsonProperty("numero_conta")
	@Column(name = "numero_conta")
	private Integer numeroConta;
	
	private Double saldo;
	
	@JsonProperty("tipo_conta")
	@Column(name = "tipo_conta", nullable = false)
	@Length(max = 1, message = "Tipo de conta deve ser somente um caractere")
	private String tipoConta;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Cliente cliente;
	
}
