package org.perso.jbank.service;

public class TransactionServiceImplementTest {
    /*@Test
    public void TestCreateTransaction(){
        AccountService accountService = new AccountServiceImplement();
        UserService userService = new UserServiceImplement(accountService);
        TransactionService transactionService = new TransactionServiceImplement(accountService);

        CreateUserDTO createSentUserDTO = new CreateUserDTO();
        createSentUserDTO.setFirstname("Ashley");
        createSentUserDTO.setLastname("Ky");
        createSentUserDTO.setMail("kyash@gmail.com");
        userService.createUser(createSentUserDTO);

        CreateUserDTO createReceiverUserDTO = new CreateUserDTO();
        createReceiverUserDTO.setFirstname("William");
        createReceiverUserDTO.setFirstname("Ouedraogo");
        createReceiverUserDTO.setMail("williodg@gmail.com");
        userService.createUser(createReceiverUserDTO);

        CreateTransactionDTO transactionDTO = new CreateTransactionDTO();
        transactionDTO.setFromAccountNumber(userService.findUserById(1).orElse(null).getAccount().getAccountNumber());
        transactionDTO.setToAccountNumber(userService.findUserById(2).orElse(null).getAccount().getAccountNumber());
        transactionDTO.setAmount(60000);
        transactionService.createTransaction(transactionDTO);

        Assertions.assertThat(accountService.findAccountByNumber(userService.findUserById(1).orElse(null).getAccount().getAccountNumber()).orElse(null).getCurrentCredit()).isEqualTo(40000);
        Assertions.assertThat(accountService.findAccountByNumber(userService.findUserById(2).orElse(null).getAccount().getAccountNumber()).orElse(null).getCurrentCredit()).isEqualTo(160000);
        //We try to send again 60000 CFA although there is not enough credit (40000 CFA)
        Assertions.assertThat(transactionService.createTransaction(transactionDTO)).isNull();
    }*/
}
