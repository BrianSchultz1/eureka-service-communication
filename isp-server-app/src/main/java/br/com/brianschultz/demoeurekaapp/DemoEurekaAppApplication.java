package br.com.brianschultz.demoeurekaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class DemoEurekaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEurekaAppApplication.class, args);
	}

}
