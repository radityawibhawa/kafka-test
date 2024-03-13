package com.kafka.example.DTO.response;

import java.util.UUID;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class OrderResponse {
    private String id;
    private UUID orderId;
    private String food;
    private String restaurant;
    private Integer harga;
}
