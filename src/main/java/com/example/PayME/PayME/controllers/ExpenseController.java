package com.example.PayME.PayME.controllers;


import com.example.PayME.PayME.dtos.ExpenseDTO;
import com.example.PayME.PayME.entities.ExpenseEntity;
import com.example.PayME.PayME.services.ExpenseService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/expense")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;
    @PostMapping
    public ResponseEntity<ExpenseDTO> createExpense(@RequestBody ExpenseDTO expenseDTO){
        return ResponseEntity.ok(expenseService.createExpense(expenseDTO));
    }

    @GetMapping("/{expenseId}")
    public ResponseEntity<ExpenseDTO> getExpenseById(@PathVariable Long expenseId){
        return ResponseEntity.ok(expenseService.getExpenseById(expenseId));
    }

    @GetMapping("/group/{groupId}/expenses")
    public ResponseEntity<List<ExpenseDTO>> getExpenseByGroup(@PathVariable Long groupId){
        return ResponseEntity.ok(expenseService.getExpenseByGroup(groupId));
    }
}
