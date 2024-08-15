package tech.amg.transactions_service.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.amg.transactions_service.domain.entity.Transaction;
import tech.amg.transactions_service.repo.TransactionRepo;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransactionRepo transactionRepo;

    @GetMapping
    public List<Transaction> getAllTransactions(){
        return transactionRepo.findAll();
    }

    public Transaction getTransactionById(ObjectId id){
        return transactionRepo.findTransactionByTransactionId(id);
    }

}
