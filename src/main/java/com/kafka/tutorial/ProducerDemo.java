package com.kafka.tutorial;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("works");
		
		String bootstrapserver="127.0.0.1:9092";
		Properties kafkaProps = new Properties();
		
		kafkaProps.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapserver);
		kafkaProps.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		kafkaProps.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		KafkaProducer<String,String> producer = new KafkaProducer<String, String>(kafkaProps);
		
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("first-topic", "java producer");
		
		producer.send(record);
		
		producer.flush();
		
		producer.close();
	}

}
