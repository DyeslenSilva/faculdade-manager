package es.faculdade.igts.webClient;

import org.springframework.web.reactive.function.client.WebClient;

import com.sun.research.ws.wadl.Resource;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FaculdadeWebClient {
	
	private WebClient client;
	
	public WebClient openConnection(String url) {
		client = WebClient.create(url);
		return client;
	}
	
	public void getResourseByID(String id) {
		Mono<Resource> results = client.get()
				.uri("/resourse/{id}","id")
				.retrieve()
				.bodyToMono(Resource.class);
		
		results.subscribe(System.out::println);
	}
	
	public void getAllResources() {
		Flux<Resource> result = client.get()
				.uri("/resource")
				.retrieve()
				.bodyToFlux(Resource.class);
		
		result.subscribe(System.out::println);
	}
}
