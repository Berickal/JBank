package org.perso.jbank.repository;

import org.perso.jbank.model.Account;
import org.perso.jbank.model.Transaction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Integer> {

    @Transactional
    public List<Transaction> findByFromAccount(Account account);

    @Transactional
    public List<Transaction> findByToAccount(Account account);

}
