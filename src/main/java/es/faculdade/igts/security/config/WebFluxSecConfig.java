package es.faculdade.igts.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@EnableWebFluxSecurity
public class WebFluxSecConfig {
	
	 @Bean
	    public MapReactiveUserDetailsService userDetailsService() {
	        @SuppressWarnings("deprecation")
			UserDetails user = User.withDefaultPasswordEncoder()
	            .username("user")
	            .password("user")
	            .roles("USER")
	            .build();
	        return new MapReactiveUserDetailsService(user);
	    }
	 
	 	@Bean
	    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
	        http
	            .authorizeExchange()
	                .anyExchange().authenticated()
	                .and()
	            .httpBasic().and()
	            .formLogin();
	        return http.build();
	    }
	 	
	 	
}
