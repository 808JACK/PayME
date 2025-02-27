package com.example.PayME.PayME.repos;

import com.example.PayME.PayME.entities.DebtEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtRepo extends JpaRepository<DebtEntity,Long> {
}
