package es.faculdade.igts.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;

import com.helger.commons.io.resource.ClassPathResource;

@SuppressWarnings("deprecation")
public class AppConfig {

	public static PropertyPlaceholderConfigurer getPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer placeholderConfigurer =
				new PropertyPlaceholderConfigurer();
		placeholderConfigurer.setLocation((Resource) new ClassPathResource("application.properties"));
		placeholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
		return placeholderConfigurer;
	}
	
}
