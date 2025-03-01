package com.example.PayME.PayME.services;

import com.example.PayME.PayME.dtos.ExpenseDTO;

import java.util.List;

public interface ExpenseService {
    ExpenseDTO createExpense(ExpenseDTO expenseDTO);

    ExpenseDTO getExpenseById(Long expenseId);

    List<ExpenseDTO> getExpenseByGroup(Long groupId);
}
