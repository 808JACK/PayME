package com.example.PayME.PayME.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class DebtDTO {

    private Long id;
    private Double amount;
    private LocalDateTime createdAt;
    private String status;
}
