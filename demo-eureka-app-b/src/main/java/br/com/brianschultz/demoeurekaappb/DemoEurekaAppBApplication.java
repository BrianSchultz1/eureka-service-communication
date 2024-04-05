package br.com.brianschultz.demoeurekaappb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoEurekaAppBApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEurekaAppBApplication.class, args);
	}

}
