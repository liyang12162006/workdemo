package com.example.workdemo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * MongodbConfig
 *
 * @author: tianlle
 * @date: 2019/01/29
 */
@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = "com.huitongjy.exercisebank.dao.repository")
public class MongoConfig {

}
