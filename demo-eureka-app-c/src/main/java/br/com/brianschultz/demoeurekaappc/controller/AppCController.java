package br.com.brianschultz.demoeurekaappc.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class AppCController {
    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/random")
    public int getRandomNumber() {
        return new Random().nextInt(100);

    }
}
