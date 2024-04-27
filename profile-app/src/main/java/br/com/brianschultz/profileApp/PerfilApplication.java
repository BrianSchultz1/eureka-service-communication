package br.com.brianschultz.profileApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PerfilApplication {

	public static void main(String[] args) {
//		System.setProperty("java.rmi.server.hostname","192.168.0.105:1010");
		SpringApplication.run(PerfilApplication.class, args);
	}

}
