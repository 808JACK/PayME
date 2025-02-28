package com.example.PayME.PayME.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupName;
    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "groups")
    private List<UserEntity> users = new ArrayList<>();

    public void addUser(UserEntity user){
        users.add(user);
        user.getGroups().add(this);
    }

    @OneToMany(mappedBy = "group")
    private List<ExpenseEntity> expenseEntities = new ArrayList<>();

    public void addExpense(ExpenseEntity expense){
        expenseEntities.add(expense);
        expense.setGroup(this);
    }

    @OneToMany(mappedBy = "group" )
    private List<DebtEntity> debtEntities = new ArrayList<>();

    public void addDebt(DebtEntity debt){
        debtEntities.add(debt);
        debt.setGroup(this);
    }


}
