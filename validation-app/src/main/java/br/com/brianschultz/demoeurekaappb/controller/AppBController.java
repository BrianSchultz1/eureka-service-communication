package br.com.brianschultz.demoeurekaappb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
public class AppBController {
    @Autowired
    private EurekaDiscoveryClient eurekaClient;

    @GetMapping("/random")
    public int sumFromAppC() {

        try {
            RestTemplate restTemplate = new RestTemplate();
            String appCUrl = getServiceUrl();
            ResponseEntity<Integer> response = restTemplate.getForEntity(appCUrl + "/random", Integer.class);
            int randomNumberFromAppC = response.getBody();
            int randomNumberFromAppB = new Random().nextInt(100);
            return randomNumberFromAppC + randomNumberFromAppB;
        } catch (Exception e) {
            return -1;
        }

    }

    public String getServiceUrl() {
        List<ServiceInstance> instances = eurekaClient.getInstances("demo-eureka-app-c");
        if (!instances.isEmpty()) {
            return instances.get(0).getUri().toString();
        } else {
            return "Error: No instances available for demo-eureka-app-c";
        }
    }

}