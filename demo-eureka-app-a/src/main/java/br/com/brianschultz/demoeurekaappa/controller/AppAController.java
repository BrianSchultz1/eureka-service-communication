package br.com.brianschultz.demoeurekaappa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@RestController
public class AppAController {

    @Autowired
    private EurekaDiscoveryClient eurekaClient;

    @GetMapping("/sum")
    public String sumFromAppB() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String appBUrl = getServiceUrl();
            ResponseEntity<String> response = restTemplate.getForEntity(appBUrl + "/random", String.class);
            String appResponse = response.getBody();
            return "Response from App B: " + appResponse;
        } catch (Exception e) {
            return "Error App B" + e.getMessage();

        }
    }

    public String getServiceUrl() {
        List<ServiceInstance> instances = eurekaClient.getInstances("demo-eureka-app-b");
        if (!instances.isEmpty()) {
            return instances.get(0).getUri().toString();
        } else {
            return "Error: No instances available for demo-eureka-app-b";
        }
    }

}
