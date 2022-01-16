package org.perso.jbank.service;

import org.perso.jbank.model.Account;
import org.perso.jbank.model.User;

import java.util.Optional;

public interface AccountService {
    Account createAccount(User user);
    Optional<Account> findAccountById(int id);
    Optional<Account> findAccountByNumber(int number);
    Optional<User> findUserByAccountNumber(int number);
    Iterable<Account> findAllAccounts();
    Account updateAccount(Account account);
    Optional<Account> deleteAccount(int id);
}
