package br.com.brianschultz.demoeurekaappc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class DNSServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DNSServerApplication.class, args);
    }

}
