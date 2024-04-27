package br.com.brianschultz.validation.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ValidacaoApplication {
	public static void main(String[] args) {
		SpringApplication.run(ValidacaoApplication.class, args);
	}

}