package com.example.PayME.PayME.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Data
@Getter
@Setter
public class ExpenseDTO {

    private Long id;
    private LocalDateTime createdAt;
    private String description;
    private Double amount;
    private String status;
    private String splitRule;
    private String currency;
    private Long groupId;
    private Long payerId;
}
