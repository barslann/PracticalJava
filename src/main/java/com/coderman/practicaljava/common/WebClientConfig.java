package com.coderman.practicaljava.common;

import org.apache.http.HttpHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.awt.*;


@Configuration
public class WebClientConfig {
    @Bean(name = "webClientElasticsearch")
    public WebClient webClientElasticSearch(){
        return WebClient.builder()
                .baseUrl("http://localhost:9200")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
    }
}
