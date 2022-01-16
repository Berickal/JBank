package org.perso.jbank.service;

import org.perso.jbank.dto.ConnexionUserDTO;
import org.perso.jbank.dto.CreateUserDTO;
import org.perso.jbank.dto.UpdateUserDTO;
import org.perso.jbank.model.Account;
import org.perso.jbank.repository.UserRepository;
import org.perso.jbank.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImplement implements UserService{

    private final AccountService accountService;
    @Autowired
    private UserRepository userRepository;

    public UserServiceImplement(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public User connexionUser(ConnexionUserDTO connexionUserDTO) {
        Optional<User> user = userRepository.findByMail(connexionUserDTO.getMail());
        if (!user.isPresent()) return null;
        else if(user.get().getPassword().equals(connexionUserDTO.getPassword())){ return user.get(); }
        return null;
    }

    @Override
    public User createUser(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setFirstname(createUserDTO.getFirstname());
        user.setLastname(createUserDTO.getLastname());
        user.setNationality(createUserDTO.getNationality());
        user.setMail(createUserDTO.getMail());
        user.setPhoneNumber(createUserDTO.getPhoneNumber());
        user.setBirthdate(createUserDTO.getBirthdate());
        user.setPassword(this.generatePassword());
        user.setAccount(this.accountService.createAccount(user));
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findUserByMail(String mail) { return userRepository.findByMail(mail); }

    @Override
    public Iterable<User> findAllUsers() { return userRepository.findAll(); }

    @Override
    public User updateUser(User user, UpdateUserDTO updateUserDTO) {
        if(!updateUserDTO.getFirstname().isBlank() && !updateUserDTO.getFirstname().isEmpty()) user.setFirstname(updateUserDTO.getFirstname());
        if(!updateUserDTO.getLastname().isBlank() && !updateUserDTO.getLastname().isEmpty()) user.setLastname(updateUserDTO.getLastname());
        if(!updateUserDTO.getNationality().isBlank() && !updateUserDTO.getNationality().isEmpty()) user.setNationality(updateUserDTO.getNationality());
        user.setPassword(updateUserDTO.getNewPassword());
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> deleteUser(int id) {
        Optional<User> findUser = this.findUserById(id);
        userRepository.deleteById(id);
        return findUser;
    }

    /**
     *
     * @return: Random Number in String's format from '0000' to '9999'
     */
    public String generatePassword(){
        Random rdn = new Random();
        int intFormatPassword = rdn.nextInt(9999);
        return String.format("%04d", intFormatPassword);
    }
}
