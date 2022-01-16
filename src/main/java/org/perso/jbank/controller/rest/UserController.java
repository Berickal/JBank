package org.perso.jbank.controller.rest;

import org.perso.jbank.dto.CreateUserDTO;
import org.perso.jbank.model.User;
import org.perso.jbank.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jbank/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping(value = "")
    public ResponseEntity<User> createUser(@RequestBody CreateUserDTO createUserDTO){ return new ResponseEntity<>(this.userService.createUser(createUserDTO), HttpStatus.OK); }

    @GetMapping( value = "/allUsers")
    public ResponseEntity<Iterable<User>> findAllUsers(){ return new ResponseEntity<>(this.userService.findAllUsers(), HttpStatus.OK); }

    @GetMapping(value = "/oneUser/{id}")
    public ResponseEntity<Optional<User>> findUserById(@PathVariable("id") int id){ return new ResponseEntity<>(this.userService.findUserById(id), HttpStatus.OK); }
}
