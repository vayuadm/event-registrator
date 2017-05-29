package com.hpe.ceribro.repositories;

import com.hpe.ceribro.entities.Webhook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WebhooksRepository extends JpaRepository<Webhook, Long> {

    List<Webhook> findByDomainAndProjectAndModule(String domain, String project, String module);

    List<Webhook> findByDomainAndProject(String domain, String project);

    List<Webhook> findByDomain(String domain);
}
