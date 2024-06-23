package br.com.brianschultz.demoeurekaappa.controller;

import br.com.brianschultz.demoeurekaappa.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/dfs")
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/obterArquivo/{fileName}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileName) {
        Resource file = fileService.getFile(fileName);
        if (file != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(file);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/salvarArquivo/{fileName}")
    public ResponseEntity<String> saveFile(@PathVariable String fileName, @RequestParam("file") MultipartFile file) {
        fileService.saveFile(fileName, file);
        return ResponseEntity.ok("Arquivo salvo com sucesso!");
    }
}