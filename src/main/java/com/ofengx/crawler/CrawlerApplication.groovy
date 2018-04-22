package com.ofengx.crawler

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class CrawlerApplication {

    static void main(String[] args) {
        SpringApplication.run(CrawlerApplication.class, args)
    }
}
