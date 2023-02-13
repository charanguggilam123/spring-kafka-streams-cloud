package com.example.demo.config;

import java.util.List;
import java.util.function.Function;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gsc.demo.entity.AlertConsumerEvent;
import com.gsc.demo.entity.CustomerEvent;

@Configuration
public class KafkaStreamProcessor {
	
	private List<String> alertSubscribedConsumer = List.of("Sai Charan Guggilam", "Rahul");

	private static final Logger LOG = LoggerFactory.getLogger(KafkaStreamProcessor.class);
	
	@Bean
	Function<KStream<String, CustomerEvent>,KStream<String, AlertConsumerEvent>> eventProcessor(){
		return inputStream -> inputStream.peek((k,v)->{
			LOG.info("message listened::{} ", v);
			
		}).filter((key,event)->{
			return alertSubscribedConsumer.stream().anyMatch(event.getName()::equalsIgnoreCase);
		}).map((key,value)->{
			return new KeyValue<>(key, new AlertConsumerEvent(value.getName(), value.getEmail(), value.getMobile()));
		}).peek((k,v)->System.out.println(v.getCustomerName()));
	}

}
