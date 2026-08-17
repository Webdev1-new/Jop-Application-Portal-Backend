package com.microservice.job.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class KafkaConfig {

	@Bean
	public NewTopic newTopic() {		
		return TopicBuilder.name("kafkademo")
				.partitions(3)
				.replicas(1)
				.build();
	}
		
	@Bean
	public Map<String,Object> producerConfig(){		
		Map<String,Object> mapss = new HashMap<>();
		mapss.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		mapss.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		mapss.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return mapss;
	}
	
	@Bean
	public ProducerFactory<String,Object> producerFactory(){
		return new DefaultKafkaProducerFactory<>(producerConfig());
	}
	
	@Bean
	public KafkaTemplate<String,Object> kafkaTemplate(){
		return new KafkaTemplate<String,Object>(producerFactory());
	}
}
