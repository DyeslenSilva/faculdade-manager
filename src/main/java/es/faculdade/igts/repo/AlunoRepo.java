package es.faculdade.igts.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import es.faculdade.igts.model.Aluno;

public interface AlunoRepo extends JpaRepository<Aluno, Integer> {

}
