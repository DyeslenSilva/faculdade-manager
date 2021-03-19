package es.faculdade.igts.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.faculdade.igts.webflux.repo.ProfessorWebFluxRepo;

@RestController
@RequestMapping("/apiFluxProfessor")
public class ProfessorFluxController {

	@Autowired 
	private ProfessorWebFluxRepo fluxRepo;
}
