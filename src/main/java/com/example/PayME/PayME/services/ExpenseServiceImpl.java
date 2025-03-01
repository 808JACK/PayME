package com.example.PayME.PayME.services;

import com.example.PayME.PayME.dtos.DebtDTO;
import com.example.PayME.PayME.dtos.ExpenseDTO;
import com.example.PayME.PayME.entities.DebtEntity;
import com.example.PayME.PayME.entities.ExpenseEntity;
import com.example.PayME.PayME.entities.GroupEntity;
import com.example.PayME.PayME.entities.UserEntity;
import com.example.PayME.PayME.exceptions.ResourceNotFoundException;
import com.example.PayME.PayME.repos.DebtRepo;
import com.example.PayME.PayME.repos.ExpenseRepo;
import com.example.PayME.PayME.repos.GroupRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService{

    private final ModelMapper modelMapper;
    private final ExpenseRepo expenseRepo;
    private final GroupRepo groupRepo;
    private final DebtRepo debtRepo;
    @Override
    public ExpenseDTO createExpense(ExpenseDTO expenseDTO) {
        ExpenseEntity expense = modelMapper.map(expenseDTO,ExpenseEntity.class);

        GroupEntity group = groupRepo.findById(expenseDTO.getGroupId())
                .orElseThrow(() -> new ResourceNotFoundException("group id not found"));
        expense.setGroup(group);

        expense = expenseRepo.save(expense);

        List<UserEntity> groupUsers = group.getUsers();
        int userCount = groupUsers.size();

        double splitAmount = expense.getAmount().doubleValue()/userCount;

        UserEntity payer = expense.getPayer();
        for(UserEntity user : groupUsers){
            if(!user.equals(payer)){
                DebtEntity debt = new DebtEntity();
                debt.setAmount(splitAmount);
                debt.setGroup(group);
                debt.setDebtor(user);
                debt.setCreditor(payer);
                debt.setExpense(expense);
                debt.setStatus("pending");
                debtRepo.save(debt);
                expense.addDebt(debt);
            }
        }

        expenseRepo.save(expense);

        return modelMapper.map(expense, ExpenseDTO.class);
    }

    @Override
    public ExpenseDTO getExpenseById(Long expenseId) {
        ExpenseEntity expense = expenseRepo.findById(expenseId)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found"));
        return modelMapper.map(expense, ExpenseDTO.class);
    }

    @Override
    public List<ExpenseDTO> getExpenseByGroup(Long groupId) {
        GroupEntity groupEntity = groupRepo.findById(groupId)
                .orElseThrow(() -> new ResourceNotFoundException("Expense for this group not found"));

        List<ExpenseEntity> expenseEntities = groupEntity.getExpenseEntities();

        return expenseEntities.stream().map(expense -> modelMapper.map(expense, ExpenseDTO.class))
                .collect(Collectors.toList());

    }

}
