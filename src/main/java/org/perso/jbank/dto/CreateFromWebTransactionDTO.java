package org.perso.jbank.dto;

import lombok.Data;

@Data
public class CreateFromWebTransactionDTO {
    private int toAccountNumber;
    private int amount;
    private String password;
}
