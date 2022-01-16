package org.perso.jbank.repository;

import org.perso.jbank.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AccountRepository extends PagingAndSortingRepository<Account, Integer> {

    @Transactional
    Optional<Account> findByAccountNumber(int accountNumber);
}
