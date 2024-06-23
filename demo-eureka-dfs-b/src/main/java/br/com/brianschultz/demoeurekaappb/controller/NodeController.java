package br.com.brianschultz.demoeurekaappb.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;



@RestController
@RequestMapping("/dfs")
public class NodeController {

    private static final String STORAGE_DIR = "/tmp/dfsapp/";

    static {
        File directory = new File(STORAGE_DIR);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    @GetMapping("/obterArquivo/{fileName}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileName) throws IOException {
        File file = new File(STORAGE_DIR + fileName);
        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }
        byte[] content = Files.readAllBytes(file.toPath());
        Resource resource = (Resource) new ByteArrayResource(content);
        return ResponseEntity.ok(resource);
    }

    @PostMapping("/salvarArquivo/{fileName}")
    public ResponseEntity<String> saveFile(@PathVariable String fileName, @RequestParam("file") MultipartFile file) throws IOException {
        File storageFile = new File(STORAGE_DIR + fileName);
        try (FileOutputStream fos = new FileOutputStream(storageFile)) {
            fos.write(file.getBytes());
        }
        return ResponseEntity.ok("Arquivo salvo com sucesso!");
    }
}