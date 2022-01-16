package org.perso.jbank.controller.rest;

import org.perso.jbank.model.Account;
import org.perso.jbank.model.User;
import org.perso.jbank.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/jbank/account")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) { this.accountService = accountService; }

    @GetMapping("/getByID/{id}")
    ResponseEntity<Optional<Account>> getAccountByID(@RequestParam("id") int id){
        return new ResponseEntity<>(this.accountService.findAccountById(id), HttpStatus.OK);
    }

    @GetMapping("/getByNumber/{number}")
    ResponseEntity<Optional<Account>> getAccountByNumber(@RequestParam("number") int number){
        return new ResponseEntity<>(this.accountService.findAccountByNumber(number), HttpStatus.OK);
    }

    @GetMapping( value = "/allAccounts")
    public ResponseEntity<Iterable<Account>> findAllUsers(){ return new ResponseEntity<>(this.accountService.findAllAccounts(), HttpStatus.OK); }
}
