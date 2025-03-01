package com.example.PayME.PayME.repos;

import com.example.PayME.PayME.entities.DebtEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DebtRepo extends JpaRepository<DebtEntity, Long> {
    List<DebtEntity> findByDebtorIdOrCreditorId(Long debtorId, Long creditorId);
}