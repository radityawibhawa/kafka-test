// package com.kafka.example.controller;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.kafka.core.KafkaTemplate;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.kafka.example.DTO.request.MessageRequest;

// @RestController
// @RequestMapping("api/message")
// public class MessageController {
    
//     @Autowired
//     private KafkaTemplate<String, String> kafkaTemplate;

//     @PostMapping
//     public void publish(@RequestBody MessageRequest request){
//         kafkaTemplate.send("test", request.message());
//     }
// }
