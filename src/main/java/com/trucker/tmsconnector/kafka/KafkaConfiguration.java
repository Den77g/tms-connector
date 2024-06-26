package com.trucker.tmsconnector.kafka;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {

    /*@Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;


    public KafkaAdmin kafkaAdmin(){
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }*/

    /*@Bean
    public NewTopic newTopic(){
        return new NewTopic("tms-connector", 1, (short) 1);
    }
*/

   /* @Bean
    public NewTopic newTopic(){
        return TopicBuilder.name("tms-connector")
                *//*.partitions(1)
                .replicas(1)*//*
                .build();
    }*/

}
