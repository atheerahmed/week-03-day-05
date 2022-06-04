package com.example.banksystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class CustomerDTO {
    private Integer bankId;
    private Integer customerId;
    private String username;
}
