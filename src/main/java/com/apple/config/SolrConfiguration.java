package com.apple.config;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableSolrRepositories(basePackages = "com.apple.repos", multicoreSupport = true, schemaCreationSupport = true)
@PropertySource("classpath:application.properties")
public class SolrConfiguration {

	static final String SOLR_HOST = "solr.host";

	@Resource
	private Environment environment;

	@Bean
	public SolrClient solrClient() {
		String solrHost = environment.getRequiredProperty(SOLR_HOST);
		return new HttpSolrClient(solrHost);
	}

	@Bean
	public SolrTemplate solrTemplate(SolrClient client) throws Exception {
		return new SolrTemplate(client);
	}

}