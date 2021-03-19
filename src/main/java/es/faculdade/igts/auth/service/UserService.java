package es.faculdade.igts.auth.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import es.faculdade.igts.auth.model.Usuario;
import reactor.core.publisher.Mono;

@Service
public class UserService {

	private Map<String, User> data;
	
	@PostConstruct	
	public void init() {
		data = new HashMap<>();
		data.put("user", (User) new Usuario("user", "cBrlgyL2GI2GINuLUUwgojITuIufFycpLG4490dhGtY="));
		data.put("admin", (User) new Usuario("admin", "dQNjUIMorJb8Ubj2+wVGYp6eAeYkdekqAcnYp+aRq5w="));
	}
	
	public Mono<User> findByUsername(String username) {
		if (data.containsKey(username)) {
			return Mono.just(data.get(username));
		} else {
			return Mono.empty();
		}
	}
}
