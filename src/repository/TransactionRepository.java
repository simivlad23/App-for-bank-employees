package repository;

import model.Transaction;

public interface TransactionRepository {

    Transaction create(Transaction transaction);
}
