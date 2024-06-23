package br.com.brianschultz.demoeurekaappa;

import br.com.brianschultz.demoeurekaappa.service.FileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// Pequeno exemplo de teste a ser usado no projeto, esse pre verifica o arquivo
public class FileServiceTests {
    @Autowired
    private final FileService fileService;

    public FileServiceTests(FileService fileService) {
        this.fileService = fileService;
    }

    @Test
    void testSaveAndRetrieveFile() {
        String fileName = "testFile.txt";
        String content = "Conteúdo do arquivo de teste.";
        MultipartFile multipartFile = new MockMultipartFile(fileName, content.getBytes());

        fileService.saveFile(fileName, multipartFile);

        Resource resource = fileService.getFile(fileName);

        // Verifica o file
        assertNotNull(resource);
        assertEquals(fileName, resource.getFilename());
    }
}

