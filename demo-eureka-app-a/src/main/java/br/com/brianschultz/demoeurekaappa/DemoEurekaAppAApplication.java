package br.com.brianschultz.demoeurekaappa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoEurekaAppAApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEurekaAppAApplication.class, args);
	}

}