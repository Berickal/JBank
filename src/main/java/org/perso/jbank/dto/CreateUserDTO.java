package org.perso.jbank.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
public class CreateUserDTO {
    private String firstname;
    private String lastname;
    private String mail;
    private int phoneNumber;
    private String nationality;
    private String birthdate;
}
