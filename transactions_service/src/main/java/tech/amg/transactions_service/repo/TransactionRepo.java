package tech.amg.transactions_service.repo;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tech.amg.transactions_service.domain.entity.Transaction;

import java.util.List;

@Repository
public interface TransactionRepo extends MongoRepository<Transaction,Long> {

    List<Transaction> findTransactionsByUserEmail(String email);

    Transaction findTransactionByTransactionId(ObjectId id);

}
