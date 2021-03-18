package es.faculdade.igts.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.faculdade.igts.model.Diretor;
import es.faculdade.igts.repo.DiretorRepo;

@Service
public class DiretorService {

	@Autowired
	private DiretorRepo diretorRepo;
	
	public void cadastroDiretor(Diretor diretor) {
		diretorRepo.save(diretor);
	}
	
	public List<Diretor> getDiretores(){
		return diretorRepo.findAll().stream()
				.filter(diretor -> diretor.isAtivo())
				.collect(Collectors.toList());
	}
	
	public Diretor getDiretor(Integer idDiretor) {
		return diretorRepo.findById(idDiretor)
				.orElse(null);
	}
	
	public void deleteDiretor(Integer [] lista) {
		Arrays.stream(lista).forEach(idDiretor -> {
			Diretor diretorDelete = getDiretor(idDiretor);
			if(diretorDelete != null) {
				diretorDelete.setInativo(false);
				diretorRepo.deleteById(idDiretor);
			}
		});
	}
}