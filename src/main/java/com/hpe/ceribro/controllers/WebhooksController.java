package com.hpe.ceribro.controllers;

import com.hpe.ceribro.entities.Webhook;
import com.hpe.ceribro.services.WebhooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/webhooks")
@EnableWebSecurity
public class WebhooksController {

    @Autowired
    private WebhooksService webhooksService;

    @GetMapping(value = "/{domain}/{project}/{entity}")
    public List<Webhook> getWebhooks(@PathVariable String domain,
                                     @PathVariable String project,
                                     @PathVariable String entity) throws IOException {
        return webhooksService.readWebhooks(domain, project, entity);
    }

    @GetMapping(value = "/{domain}/{project}")
    public List<Webhook> getWebhooks(@PathVariable String domain,
                                     @PathVariable String project) throws IOException {
        return webhooksService.readWebhooks(domain, project);
    }

    @GetMapping(value = "/{domain}")
    public List<Webhook> getWebhooks(@PathVariable String domain) throws IOException {
        return webhooksService.readWebhooks(domain);
    }

    @GetMapping
    public List<Webhook> getWebhooks() throws IOException {
        return webhooksService.readWebhooks();
    }

    @PostMapping
    public Webhook createWebhook(@RequestBody @Valid Webhook webhook) {
        return webhooksService.createWebhook(webhook);
    }

    @DeleteMapping(value = "/{webhookId}")
    public ResponseEntity deleteWebhook(@PathVariable Long webhookId) {
        if (webhooksService.deleteWebhook(webhookId)) {
            return new ResponseEntity<>(OK);
        }
        // Webhook not found
        return new ResponseEntity<>(NOT_FOUND);
    }

}
