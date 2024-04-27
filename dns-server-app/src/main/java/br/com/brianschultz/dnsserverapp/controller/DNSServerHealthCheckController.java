package br.com.brianschultz.demoeurekaappc.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class DNSServerHealthCheckController {

    @Value("${spring.service-discovery-app}")
    private String applicationDiscoveryURI;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/health")
    public String healthy() {
        return "Sou o DNS Server e estou online: " + LocalDateTime.now();
    }

    @GetMapping("/getRegisteredApplications")
    public String getRegisteredApplications() {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(applicationDiscoveryURI))
                    .GET()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .build();
            HttpResponse<String> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
            return response.body().toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }
}
