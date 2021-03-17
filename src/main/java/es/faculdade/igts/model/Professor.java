package es.faculdade.igts.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfessor;
	
	@Column
	private String nomeProfessor;
	
	@Column
	private String endereco;
	
	@Column
	private String telefoneCelular;
	
	@Column
	private String areaDeAtuacao;
	
	@Column
	private Float valorHora;
	
	@Column
	private Integer horasTrabalhadas;
}
