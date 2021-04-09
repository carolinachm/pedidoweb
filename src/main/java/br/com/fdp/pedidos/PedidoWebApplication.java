package br.com.fdp.pedidos;

import java.util.HashMap;


import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class PedidoWebApplication {

	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(PedidoWebApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(PedidoWebApplication.class, args);
	}

	@SuppressWarnings("serial")
	@Bean
	public org.springframework.beans.factory.config.CustomScopeConfigurer customScopeConfigurer() {
		CustomScopeConfigurer csc = new CustomScopeConfigurer();
		csc.setScopes(new HashMap<String, Object>() {
			{
				put("view", new br.com.fdp.pedidos.controller.util.ViewScope());
			}
		});
		return csc;
	}
	

}
