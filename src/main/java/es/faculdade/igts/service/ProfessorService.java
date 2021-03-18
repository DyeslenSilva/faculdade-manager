package es.faculdade.igts.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.faculdade.igts.model.Professor;
import es.faculdade.igts.repo.ProfessorRepo;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepo professorRepo;

	public void salvaProfessor(Professor professor) {
		professorRepo.save(professor);
	}
	
	public List<Professor> getProfessores(){
		return professorRepo.findAll().stream()
				.filter(professorRepo -> professorRepo.isInativo())
				.collect(Collectors.toList());
	}
	
	public Professor getProfessor(Integer idProfessor) {
		return professorRepo.findById(idProfessor)
				.orElse(null);
	}
	
	public void removeProfessor(Integer[]lista) {
		Arrays.stream(lista).forEach(idProfessor ->{
			Professor professor = getProfessor(idProfessor);
			if(professor !=null) {
				professor.setInativo(true);
				professorRepo.deleteById(idProfessor);
			}
		});
	}
}
