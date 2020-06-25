package com.cgi.poc.camel;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cgi.poc.camel.bean.ServiceBean;

@Component
public class RouteDefinition extends RouteBuilder {

	// Contexto de Origem para criar o rest neste caso queremos que seja o nosso
	public static String CONTEXT_ROOT_ID = "api";

	@Value("${server.port}")
	String serverPort;

	@Override
	public void configure() {

		// Criar o nosso webService de entrada
		rest("/api/").id("webservice1").get("/userdata").bindingMode(RestBindingMode.auto).type(ServiceBean.class).to("direct:rota1");

		// Definir a primeira rota
		from("direct:rota1").routeId("rota1").log("Route #1 Reached!")
				.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201)).to("direct:rota2");

		// Definir a segunda rota
		from("direct:rota2").routeId("rota2").log("Route #2 Reached!").setHeader(Exchange.HTTP_RESPONSE_CODE,
				constant(201));
	}
}
