package com.example.PayME.PayME.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.security.spec.ECPoint;
import java.time.LocalDateTime;

@Entity
@Table(name = "debts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebtEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private String status;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    @ManyToOne
    @JoinColumn(name = "debtor_id")
    private UserEntity debtor;

    @ManyToOne
    @JoinColumn(name = "creditor_id")
    private UserEntity creditor;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    private ExpenseEntity expense;

}
