package com.treinamento.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_CLIENTE_PJ")
public class ClientePJ extends Cliente{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliete_pj")
	@SequenceGenerator(allocationSize = 1, name = "seq_cliente_pj", sequenceName = "seq_cliente_pj")
	private Long id;

	private String cnpj;

	private String inscricaoEstatual;

	private LocalDate dataAbertura;

	private String RazaoSocial;

	@NotEmpty
	private String banco;

	private LocalDate dataAdesao;

}
