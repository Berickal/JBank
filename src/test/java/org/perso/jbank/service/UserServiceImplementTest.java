package org.perso.jbank.service;


public class UserServiceImplementTest {
    /*@Test
    public void TestCreateUser(){
        CreateUserDTO createUserDTO = new CreateUserDTO();
        createUserDTO.setFirstname("Ashley");
        createUserDTO.setLastname("Ky");
        createUserDTO.setMail("kyash@gmail.com");
        createUserDTO.setNationality("Burkinabe");
        createUserDTO.setPhoneNumber(70231302);
        createUserDTO.setBirthday(LocalDate.now());

        UserService userService = new UserServiceImplement(new AccountServiceImplement());
        User createdUser = userService.createUser(createUserDTO);
        Assertions.assertThat(createdUser).isNotNull();
        Assertions.assertThat(createdUser.getId()).isNotNull();
        Assertions.assertThat(createdUser.getLastname()).isEqualTo("Ky");
        //Assertions.assertThat(createdUser.getAccount()).isNotNull();
    }

    @Test
    public void TestFindUser(){
        UserService userService = new UserServiceImplement(new AccountServiceImplement());

        CreateUserDTO createUserDTO = new CreateUserDTO();
        createUserDTO.setFirstname("Ashley");
        createUserDTO.setLastname("Ky");
        createUserDTO.setMail("kyash@gmail.com");
        userService.createUser(createUserDTO);

        createUserDTO.setFirstname("William");
        createUserDTO.setFirstname("Ouedraogo");
        createUserDTO.setMail("williodg@gmail.com");
        userService.createUser(createUserDTO);

        Assertions.assertThat(userService.findUserById(1)).isNotEmpty();
        Assertions.assertThat(userService.findUserById(2)).isNotEmpty();
        Assertions.assertThat(userService.findUserById(3)).isEmpty();
    }

    @Test
    public void TestDeleteUser(){
        UserService userService = new UserServiceImplement(new AccountServiceImplement());

        CreateUserDTO createUserDTO = new CreateUserDTO();
        createUserDTO.setFirstname("Ashley");
        createUserDTO.setLastname("Ky");
        createUserDTO.setMail("kyash@gmail.com");
        userService.createUser(createUserDTO);

        createUserDTO.setFirstname("William");
        createUserDTO.setFirstname("Ouedraogo");
        createUserDTO.setMail("williodg@gmail.com");
        userService.createUser(createUserDTO);

        userService.deleteUser(1);
        Assertions.assertThat(userService.findUserById(1)).isEmpty();
        Assertions.assertThat(userService.findUserById(2)).isNotEmpty();
    }*/
}
