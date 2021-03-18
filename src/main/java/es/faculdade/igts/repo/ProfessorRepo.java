package es.faculdade.igts.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import es.faculdade.igts.model.Professor;

public interface ProfessorRepo extends JpaRepository<Professor, Integer> {

}
