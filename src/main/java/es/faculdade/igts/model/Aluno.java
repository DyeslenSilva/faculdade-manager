package es.faculdade.igts.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAluno;
	
	@Column
	private String nomeDoAluno;
	
	@Column
	private String email;
	
	@Column
	private String celular;
	
	private String endereco;
	
	@Column
	private String curso;
	
	@Column
	private Integer semestreLetivo;
	
	private boolean ativo, inativo;
	
}
