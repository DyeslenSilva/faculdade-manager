package es.faculdade.igts.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.Data;

@Data
@Table
public class Diretor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDiretor;
	
	@Column
	private String nomeDiretor;

	@Column
	private String email;
	
	@Column
	private String whatsapp;

	@Column
	private String tipoDiretor;
	
	private boolean ativo, inativo;
}
