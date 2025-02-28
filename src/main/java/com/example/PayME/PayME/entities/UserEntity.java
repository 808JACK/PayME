package com.example.PayME.PayME.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_group",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private List<GroupEntity> groups= new ArrayList<>();

    public void addGroup(GroupEntity group) {
        groups.add(group);
        group.getUsers().add(this);
    }


    @OneToMany(mappedBy = "payer")
    private List<ExpenseEntity> expenses = new ArrayList<>();

    public void addExpenses(ExpenseEntity expense){
        expenses.add(expense);
        expense.setPayer(this);
    }

    @OneToMany(mappedBy = "debtor")
    private  List<DebtEntity> debt_owned = new ArrayList<>();

    @OneToMany(mappedBy = "creditor")
    private List<DebtEntity> debt_owning = new ArrayList<>();

    public void addDebt(DebtEntity debt){
        debt_owned.add(debt);
        debt.setDebtor(this);
    }

    private void addCredit(DebtEntity credit){
        debt_owning.add(credit);
        credit.setCreditor(this);
    }
}
