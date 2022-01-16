package org.perso.jbank.service;

import org.perso.jbank.model.Account;
import org.perso.jbank.model.User;
import org.perso.jbank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AccountServiceImplement implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(User user) {
        Account account = new Account();
        account.setAccountNumber(this.accountNumberGenerator());
        account.setCurrentCredit(100000);
        return account;
    }

    @Override
    public Optional<Account> findAccountById(int id) {
        return accountRepository.findById(id);
    }

    @Override
    public Optional<Account> findAccountByNumber(int number) {
        return accountRepository.findByAccountNumber(number);
    }

    @Override
    public Optional<User> findUserByAccountNumber(int number) {
        return Optional.ofNullable(accountRepository.findByAccountNumber(number).orElse(null).getUser());
    }

    @Override
    public Iterable<Account> findAllAccounts() { return accountRepository.findAll(); }

    @Override
    public Account updateAccount(Account account) {
        accountRepository.save(account);
        return account;
    }

    @Override
    public Optional<Account> deleteAccount(int id) {
        return Optional.empty();
    }

    public int accountNumberGenerator(){
        int number = 100000;
        Random rnd = new Random();
        boolean isAllowed = true;
        Iterable<Account> accounts = this.findAllAccounts();

        while (isAllowed){
            isAllowed = false;
            number = rnd.nextInt(899999) + 100000;
            for (Account element : accounts){
                if(element.getAccountNumber() == number) isAllowed = true;
            }
        }

        return number;
    }
}
