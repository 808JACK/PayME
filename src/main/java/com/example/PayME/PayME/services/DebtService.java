package com.example.PayME.PayME.services;

import com.example.PayME.PayME.controllers.DebtController;
import com.example.PayME.PayME.dtos.DebtDTO;

import java.util.List;

public interface DebtService {
    List<DebtDTO> getUserDebt(Long userId);
}
