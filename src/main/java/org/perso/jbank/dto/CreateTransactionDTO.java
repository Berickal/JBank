package org.perso.jbank.dto;

import lombok.Data;

@Data
public class CreateTransactionDTO {
    private int fromAccountNumber;
    private int toAccountNumber;
    private int amount;
}
