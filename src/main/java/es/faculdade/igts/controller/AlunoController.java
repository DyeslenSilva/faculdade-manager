package es.faculdade.igts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.faculdade.igts.model.Aluno;
import es.faculdade.igts.service.AlunoService;

@RestController
@RequestMapping("/alunoAPI")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	@RequestMapping("/cadastraAluno")
	public ResponseEntity<Aluno> cadastraAluno(@PathVariable Aluno aluno){
		alunoService.salvar(aluno);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/alunos")
	public ResponseEntity<List<Aluno>> getAlunos(){
		return ResponseEntity.ok(alunoService.getAlunos());
	}
	
	@RequestMapping("/aluno/{idAluno}")
	public ResponseEntity<Aluno> getAluno(@PathVariable Integer idAluno){
		alunoService.getAluno(idAluno);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/editaAluno/{idAluno}")
	public ResponseEntity<Aluno> editaAluno(@PathVariable Integer idAluno){
		Aluno aluno = alunoService.getAluno(idAluno);
		if(aluno !=null) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping("/deleteAluno/{idAluno}")
	public ResponseEntity<Aluno> deleteAluno(@PathVariable Integer[] idAluno){
		alunoService.deleteAluno(idAluno);
		return ResponseEntity.ok().build();
	}
	
	
}
