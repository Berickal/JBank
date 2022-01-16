package org.perso.jbank.service;

import org.perso.jbank.dto.ConnexionUserDTO;
import org.perso.jbank.dto.CreateUserDTO;
import org.perso.jbank.dto.UpdateUserDTO;
import org.perso.jbank.model.User;

import java.util.Optional;

public interface UserService {
    User connexionUser(ConnexionUserDTO connexionUserDTO);
    User createUser(CreateUserDTO createUserDTO);
    Optional<User> findUserById(int id);
    Optional<User> findUserByMail(String mail);
    Iterable<User> findAllUsers();
    User updateUser(User user, UpdateUserDTO updateUserDTO);
    Optional<User> deleteUser(int id);
}
