package es.faculdade.igts.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configurable
@EnableWebFlux
public class WebFluxConfig implements WebFluxConfigurer {
	
}
