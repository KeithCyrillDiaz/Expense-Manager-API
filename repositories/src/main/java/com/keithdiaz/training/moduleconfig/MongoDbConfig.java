package com.keithdiaz.training.moduleconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.keithdiaz.training.repositories")
public class MongoDbConfig {
    
}
