package com.kekellisson.componentGenerator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import freemarker.template.Version;

@Configuration
@ComponentScan("com.kekellisson.componentGenerator")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

	@Bean
	public Version getVersionConfig() {
		return freemarker.template.Configuration.VERSION_2_3_29;
	}
}
