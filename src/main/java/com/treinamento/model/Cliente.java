package com.treinamento.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_CLINTE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliete")
	@SequenceGenerator(allocationSize = 1, name = "seq_cliente", sequenceName = "seq_cliente_id")
	private Long id;

	@NotEmpty(message = "Nome não pode ser nullo")
	@Length(max = 50, message = "Nome não pode ter mais que {max} caracteres")
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;

	@NotEmpty(message = "Email não pode ser nullo")
	@Length(max = 50, message = "Email não pode ter mais que {max} caracteres")
	@Column(name = "email", length = 50, nullable = false)
	private String email;

	@NotEmpty(message = "Telefone não pode ser nullo")
	@Length(max = 11, message = "Telefone não pode ter mais que {max} caracteres")
	@Column(name = "telefone", length = 11, nullable = false)
	private String telefone;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Conta> contas;

}
