package org.perso.jbank.service;

public class AccountServiceImplementTest {
/*
    @Test
    public void FindAccountById(){
        AccountService accountService = new AccountServiceImplement();
        UserService userService = new UserServiceImplement(accountService);

        CreateUserDTO createUserDTO = new CreateUserDTO();
        createUserDTO.setFirstname("Ashley");
        createUserDTO.setLastname("Ky");
        createUserDTO.setMail("kyash@gmail.com");
        userService.createUser(createUserDTO);

        createUserDTO.setFirstname("William");
        createUserDTO.setFirstname("Ouedraogo");
        createUserDTO.setMail("williodg@gmail.com");
        userService.createUser(createUserDTO);

        Assertions.assertThat(accountService.findAccountById(1)).isNotEmpty();
        Assertions.assertThat(accountService.findAccountById(2)).isNotEmpty();
        Assertions.assertThat(accountService.findAccountById(3)).isEmpty();
    }

    @Test
    public void FindAccountByNumber(){
        AccountService accountService = new AccountServiceImplement();
        UserService userService = new UserServiceImplement(accountService);

        CreateUserDTO createUserDTO = new CreateUserDTO();
        createUserDTO.setFirstname("Ashley");
        createUserDTO.setLastname("Ky");
        createUserDTO.setMail("kyash@gmail.com");
        userService.createUser(createUserDTO);

        createUserDTO.setFirstname("William");
        createUserDTO.setLastname("Ouedraogo");
        createUserDTO.setMail("williodg@gmail.com");
        userService.createUser(createUserDTO);

        int accountNumber1 = userService.findUserById(1).orElse(null).getAccount().getAccountNumber();
        int accountNumber2 = userService.findUserById(2).orElse(null).getAccount().getAccountNumber();

        Assertions.assertThat(accountService.findAccountByNumber(accountNumber1)).isNotEmpty();
        Assertions.assertThat(accountService.findUserByAccountNumber(accountNumber2).orElse(null).getLastname()).isEqualTo("Ouedraogo");
    }

    @Test
    public void DeleteAccount(){
        AccountService accountService = new AccountServiceImplement();
        UserService userService = new UserServiceImplement(accountService);

        CreateUserDTO createUserDTO = new CreateUserDTO();
        createUserDTO.setFirstname("Ashley");
        createUserDTO.setLastname("Ky");
        createUserDTO.setMail("kyash@gmail.com");
        userService.createUser(createUserDTO);

        createUserDTO.setFirstname("William");
        createUserDTO.setLastname("Ouedraogo");
        createUserDTO.setMail("williodg@gmail.com");
        userService.createUser(createUserDTO);

        accountService.deleteAccount(1);
        Assertions.assertThat(accountService.findAccountById(1)).isEmpty();
        Assertions.assertThat(accountService.findAccountById(2)).isNotEmpty();
    }*/
}
