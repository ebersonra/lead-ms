package br.com.leads.ms.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"br.com.leads.ms"})
@EnableJpaRepositories(basePackages = {"br.com.leads.ms.repository"})
@EntityScan(basePackages = {"br.com.leads.ms.entity"})
@PropertySource("classpath:application.properties")
@Configuration
public class LeadMsConfig {
}
