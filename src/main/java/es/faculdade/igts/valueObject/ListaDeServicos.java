package es.faculdade.igts.valueObject;

import es.faculdade.igts.model.Servico;
import lombok.Data;

@Data
public class ListaDeServicos {

	private Integer idService;
	private Servico [] servico;

}
