package org.perso.jbank.dto;

import lombok.Data;

@Data
public class UpdateUserDTO {
    private String firstname;
    private String lastname;
    private String nationality;
    private String password;
    private String newPassword;
}
