package com.example.PayME.PayME.controllers;


import com.example.PayME.PayME.dtos.DebtDTO;
import com.example.PayME.PayME.repos.DebtRepo;
import com.example.PayME.PayME.services.DebtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/debt")
@RequiredArgsConstructor
public class DebtController {

    private final DebtService debtService;
    @GetMapping("/{userId}")
    public ResponseEntity<List<DebtDTO>> getUserDebt(@PathVariable Long userId){
        return ResponseEntity.ok(debtService.getUserDebt(userId));
    }
}
