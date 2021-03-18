package es.faculdade.igts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.faculdade.igts.model.Diretor;
import es.faculdade.igts.service.DiretorService;

@RestController
@RequestMapping("/diretorAPI")
public class DiretorController {

	@Autowired
	private DiretorService diretorService;
	
	@RequestMapping("/cadastroDiretor")
	public ResponseEntity<Diretor> cadastroDiretor(@PathVariable Diretor diretor){
		diretorService.cadastroDiretor(diretor);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/listaDeDiretores")
	public ResponseEntity<List<Diretor>> getDiretores(){
		return ResponseEntity.ok(diretorService.getDiretores());
	}
	
	@RequestMapping("/diretor/{idDiretor}")
	public ResponseEntity<Diretor> getDiretor(@PathVariable Integer idDiretor){
		diretorService.getDiretor(idDiretor);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/editaDiretor/{idDiretor}")
	public ResponseEntity<Diretor> editaDiretor(@PathVariable Integer idDiretor){
		Diretor diretor = diretorService.getDiretor(idDiretor);
		if(diretor != null) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping("/deleteDiretor/{idDiretor}")
	public ResponseEntity<Diretor> deleteDiretor(@PathVariable Integer []idDiretor){
		diretorService.deleteDiretor(idDiretor);
		return ResponseEntity.ok().build();
	}
	
}
