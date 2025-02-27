package com.example.PayME.PayME.repos;

import com.example.PayME.PayME.entities.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<ExpenseEntity,Long> {
}
