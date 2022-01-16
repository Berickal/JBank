package org.perso.jbank.controller.rest;

import org.perso.jbank.dto.CreateTransactionDTO;
import org.perso.jbank.model.Account;
import org.perso.jbank.model.Transaction;
import org.perso.jbank.service.AccountService;
import org.perso.jbank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jbank/transaction")
public class TransactionController {

    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    public TransactionController(TransactionService transactionService) { this.transactionService = transactionService; }

    @PostMapping(value = "")
    public ResponseEntity<Transaction> createTransaction(@RequestBody CreateTransactionDTO createTransactionDTO){ return new ResponseEntity<>(this.transactionService.createTransaction(createTransactionDTO), HttpStatus.OK); }

    @GetMapping( value = "/allAccounts")
    public ResponseEntity<Iterable<Transaction>> findAllTransaction(){ return new ResponseEntity<>(this.transactionService.findAllTransactions(), HttpStatus.OK); }

    @GetMapping(value = "/sendTransaction/{number}")
    public ResponseEntity<List<Transaction>> findSendTransactionById(@PathVariable("number") int number){
        Account account = this.accountService.findAccountByNumber(number).get();
        return new ResponseEntity<>(this.transactionService.findSentTransactionOfAccount(account), HttpStatus.OK);
    }

    @GetMapping(value = "/receiveTransaction/{number}")
    public ResponseEntity<List<Transaction>> findReceiveTransactionById(@PathVariable("number") int number){
        Account account = this.accountService.findAccountByNumber(number).get();
        return new ResponseEntity<>(this.transactionService.findReceiveTransactionAccount(account), HttpStatus.OK);
    }
}
