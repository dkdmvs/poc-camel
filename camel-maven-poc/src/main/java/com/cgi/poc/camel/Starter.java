package com.cgi.poc.camel;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//Packaging em que vamos fazer scan dos beans(@Compoenents) para os registar no contexto.
@ComponentScan(basePackages = "com.cgi.poc.camel")
public class Starter {

	/*
	 * Registo do Contexto no Path neste caso queremos que seja /api (Segmento do
	 * contexto onde vamos publicar os nossos serviços)
	 */
	public static String CONTEXT_ROOT_ID = "api";


	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}



}
