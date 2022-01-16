package org.perso.jbank.service;

import org.perso.jbank.dto.CreateTransactionDTO;
import org.perso.jbank.model.Account;
import org.perso.jbank.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    Transaction createTransaction(CreateTransactionDTO transactiondto);
    Optional<Transaction> findTransactionById(int id);
    List<Transaction> findAllTransactionOfAccount(Account account);
    List<Transaction> findSentTransactionOfAccount(Account account);
    List<Transaction> findReceiveTransactionAccount(Account account);
    Iterable<Transaction> findAllTransactions();
    Transaction updateTransaction(Transaction transaction);
    Optional<Transaction> deleteTransaction(int id);
}
