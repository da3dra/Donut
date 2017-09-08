package ua.step.smirnova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class DonutApp extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(DonutApp.class, args).registerShutdownHook();	
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DonutApp.class);
	}
}
