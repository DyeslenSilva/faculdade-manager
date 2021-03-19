package es.faculdade.igts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.vaadin.flow.component.polymertemplate.Id;

import lombok.Data;

@Data
@Table
@Entity
public class Coordenador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCoordenador;
	
	private String nomeCoordenador;
	
	private String []curso;
}
