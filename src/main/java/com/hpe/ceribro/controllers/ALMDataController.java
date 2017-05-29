package com.hpe.ceribro.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hpe.ceribro.controllers.resources.ALMData;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/alm-data")
@EnableWebSecurity
public class ALMDataController {

    @GetMapping
    public ALMData getALMData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("demoData.json");
        InputStream demoData = resource.getInputStream();
        return mapper.readValue(demoData, ALMData.class);
    }
}
