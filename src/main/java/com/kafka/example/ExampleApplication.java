package com.kafka.example;

// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
// import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

	// @Bean
	// CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate){
	// 	return args -> {
	// 		for(int i = 0; i < 100; i++){
	// 			kafkaTemplate.send("test", "hello radit " + i);
	// 		}
	// 	};
	// }

}
