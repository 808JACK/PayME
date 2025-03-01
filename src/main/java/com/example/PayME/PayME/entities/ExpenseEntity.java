package com.example.PayME.PayME.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "expenses")
public class ExpenseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private String description;
    private Double amount;
    private String status;
    private String splitRule;
    private String currency;

    @ManyToOne
    @JoinColumn(name = "payer_id") // Foreign key to users table
    private UserEntity payer;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    @OneToMany(mappedBy = "expense")
    private List<DebtEntity> debts = new ArrayList<>();

    public void addDebt(DebtEntity debt){
        debts.add(debt);
        debt.setExpense(this);
    }
    public void setExpenseAmount(Double expenseAmount) {
        this.amount = expenseAmount;  // Sets debt amount tied to expense
    }


}
