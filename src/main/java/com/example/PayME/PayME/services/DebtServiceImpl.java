package com.example.PayME.PayME.services;

import com.example.PayME.PayME.dtos.DebtDTO;
import com.example.PayME.PayME.entities.DebtEntity;
import com.example.PayME.PayME.repos.DebtRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DebtServiceImpl implements DebtService {

    private final DebtRepo debtRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<DebtDTO> getUserDebt(Long userId) {
        List<DebtEntity> debtEntitiesList = debtRepo.findByDebtorIdOrCreditorId(userId, userId);
        return debtEntitiesList.stream()
                .map(debt -> modelMapper.map(debt, DebtDTO.class))  // Map each DebtEntity
                .collect(Collectors.toList());
    }
}