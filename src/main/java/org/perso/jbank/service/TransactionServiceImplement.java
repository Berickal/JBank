package org.perso.jbank.service;

import org.perso.jbank.dto.CreateTransactionDTO;
import org.perso.jbank.model.Account;
import org.perso.jbank.model.Transaction;
import org.perso.jbank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImplement implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    private final AccountService accountService;

    public TransactionServiceImplement(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public Transaction createTransaction(CreateTransactionDTO transactionDto) {
        Transaction transaction = new Transaction();
        Optional<Account> fromAccount = accountService.findAccountByNumber(transactionDto.getFromAccountNumber());
        Optional<Account> toAccount = accountService.findAccountByNumber(transactionDto.getToAccountNumber());

        if((fromAccount.orElse(null).getCurrentCredit() < transactionDto.getAmount()) ||
                (fromAccount.orElse(null).getAccountNumber() == toAccount.orElse(null).getAccountNumber()))
            return null;

        transaction.setFromAccount(fromAccount.orElse(null));
        transaction.setFromAccountAmount(fromAccount.orElse(null).getCurrentCredit());
        transaction.setToAccount(toAccount.orElse(null));
        transaction.setToAccountAmount(toAccount.orElse(null).getCurrentCredit());
        transaction.setMount(transactionDto.getAmount());
        transaction.setCreateAt(LocalDate.now());
        transactionRepository.save(transaction);

        fromAccount.orElse(null).setCurrentCredit(fromAccount.orElse(null).getCurrentCredit()-transactionDto.getAmount());
        toAccount.orElse(null).setCurrentCredit(toAccount.orElse(null).getCurrentCredit()+transactionDto.getAmount());
        accountService.updateAccount(fromAccount.orElse(null));
        accountService.updateAccount(toAccount.orElse(null));

        return transaction;
    }

    @Override
    public Optional<Transaction> findTransactionById(int id) { return transactionRepository.findById(id); }

    @Override
    public List<Transaction> findAllTransactionOfAccount(Account account) {
        return null;
    }

    @Override
    public List<Transaction> findSentTransactionOfAccount(Account account) { return transactionRepository.findByFromAccount(account); }

    @Override
    public List<Transaction> findReceiveTransactionAccount(Account account) { return transactionRepository.findByToAccount(account); }

    @Override
    public Iterable<Transaction> findAllTransactions() { return transactionRepository.findAll(); }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
        return transaction;
    }

    @Override
    public Optional<Transaction> deleteTransaction(int id) {
        return Optional.empty();
    }
}
