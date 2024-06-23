package br.com.brianschultz.demoeurekaappa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;
import java.util.logging.Logger;

@Service
public class FileService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String[] NODES = {"http://dfs-app-b:8082", "http://dfs-app-c:8083"};
    private static final Random RANDOM = new Random();

    public Resource getFile(String fileName) {
        for (String node : NODES) {
            try {
                URI uri = new URI(node + "/dfs/obterArquivo/" + fileName);
                Resource resource = restTemplate.getForObject(uri, Resource.class);
                if (resource != null && resource.exists()) {
                    return resource;
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed to get file: " + e.getMessage(), e);            }
        }
        return null;
    }

    public void saveFile(String fileName, MultipartFile file) {
        String node = NODES[RANDOM.nextInt(NODES.length)];
        try {
            URI uri = new URI(node + "/dfs/salvarArquivo/" + fileName);
            restTemplate.postForObject(uri, file, String.class);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Invalid URI syntax: " + node, e);
        }
    }
}