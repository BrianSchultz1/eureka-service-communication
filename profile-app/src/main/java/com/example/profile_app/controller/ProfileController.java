package com.example.profile_app.controller;

import com.example.profile_app.service.ProfileService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/obter/{fileName}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileName) {
        Resource file = profileService.getFile(fileName);
        if (file != null) {
            return ResponseEntity.ok().body(file);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/salvar/{fileName}")
    public ResponseEntity<String> saveFile(@PathVariable String fileName, @RequestParam("file") MultipartFile file) {
        profileService.saveFile(fileName, file);
        return ResponseEntity.ok("Arquivo salvo com sucesso!");
    }
}