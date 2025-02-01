package com.SAI.stock.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@Slf4j
public class MongoDBConfig {


    public MongoClient createMongoClient() {
        return MongoClients.create("mongodb://puneetkulli:JTSOv6zR5qjvMuwb@sai-shard-00-00.81nrt.mongodb.net:27017,sai-shard-00-01.81nrt.mongodb.net:27017,sai-shard-00-02.81nrt.mongodb.net:27017/?ssl=true&replicaSet=atlas-d9geq1-shard-0&authSource=admin&retryWrites=true&w=majority&appName=Sai");
    }

    @Bean(value = "mongoTemplate")
    public MongoTemplate createMongoTemplate() {
        return new MongoTemplate(createMongoClient(), "stocks");
    }

}
