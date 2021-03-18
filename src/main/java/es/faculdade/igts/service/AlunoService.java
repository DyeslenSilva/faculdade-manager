package es.faculdade.igts.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import es.faculdade.igts.model.Aluno;
import es.faculdade.igts.repo.AlunoRepo;


@Service
public class AlunoService {


	@Autowired
	private AlunoRepo alunoRepo;
	
	public void salvar(Aluno aluno) {
		alunoRepo.save(aluno);
	}
	
	public List<Aluno> getAlunos() {
		return alunoRepo.findAll().stream()
			.filter(aluno -> aluno.isAtivo())
			.collect(Collectors.toList());
	}
	
	public Aluno getAluno(Integer idAluno) {
		return alunoRepo.findById(idAluno)
				.orElse(null);
	}
	
	public void deleteAluno(Integer [] aluno) {
		Arrays.stream(aluno).forEach(idAluno ->{
			Aluno aluno2 = getAluno(idAluno);
			if(aluno2!=null) {
				aluno2.setAtivo(false);
				alunoRepo.deleteById(idAluno);
			}
		});
		
		}
	}

