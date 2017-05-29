package com.hpe.ceribro.services;

import com.hpe.ceribro.entities.Webhook;
import com.hpe.ceribro.repositories.WebhooksRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.security.PermitAll;
import java.util.List;

@Service
public class WebhooksService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WebhooksRepository webhooksRepository;

    @PermitAll
    @Transactional(readOnly = true)
    public List<Webhook> readWebhooks(String domain, String project, String module) {
        return webhooksRepository.findByDomainAndProjectAndModule(domain, project, module);
    }

    @PermitAll
    @Transactional(readOnly = true)
    public List<Webhook> readWebhooks(String domain, String project) {
        return webhooksRepository.findByDomainAndProject(domain, project);
    }

    @PermitAll
    @Transactional(readOnly = true)
    public List<Webhook> readWebhooks(String domain) {
        return webhooksRepository.findByDomain(domain);
    }

    @PermitAll
    @Transactional(readOnly = true)
    public List<Webhook> readWebhooks() {
        return webhooksRepository.findAll();
    }

    @PermitAll
    @Transactional
    public Webhook createWebhook(Webhook webhook) {
        return webhooksRepository.save(webhook);
    }

    @PermitAll
    @Transactional
    public boolean deleteWebhook(Long webhookId) {
        Webhook webhook = webhooksRepository.findOne(webhookId);
        if (webhook == null) {
            logger.warn("webhook {} not found", webhookId);
            return false;
        }
        webhooksRepository.delete(webhook);
        return true;
    }
}
