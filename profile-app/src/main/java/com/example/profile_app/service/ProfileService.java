package com.example.profile_app.service;


import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.Random;


@Service
public class ProfileService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String[] NODES = {"http://dfs-app-a:8081/dfs", "http://dfs-app-b:8082/dfs", "http://dfs-app-c:8083/dfs"};
    private static final Random RANDOM = new Random();

    public Resource getFile(String fileName) {
        for (String node : NODES) {
            try {
                String url = node + "/obterArquivo/" + fileName;
                ResponseEntity<Resource> response = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, Resource.class);
                if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                    return response.getBody();
                }
            } catch (HttpClientErrorException.NotFound e) {
                // Continue to the next node if the file is not found
            } catch (Exception e) {
                // Handle other exceptions if necessary
                e.printStackTrace();
            }
        }
        return null;
    }

    public void saveFile(String fileName, MultipartFile file) {
        String node = NODES[RANDOM.nextInt(NODES.length)];
        try {
            String url = node + "/salvarArquivo/" + fileName;

            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "multipart/form-data");
            HttpEntity<MultipartFile> entity = new HttpEntity<>(file, headers);

            restTemplate.postForEntity(url, entity, String.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save file: " + e.getMessage(), e);
        }
    }
}