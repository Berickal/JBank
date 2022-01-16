package org.perso.jbank.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "transaction_app")
public class Transaction {
    @Id
    @SequenceGenerator(name = "transactionIdSequence", sequenceName = "transactionIdSequence", initialValue = 1)
    @GeneratedValue(generator = "transactionIdSequence")
    private int id;
    @OneToOne
    @JoinColumn(name = "from_account", referencedColumnName = "id")
    private Account fromAccount;
    private int fromAccountAmount;
    @OneToOne
    @JoinColumn(name = "to_account", referencedColumnName = "id")
    private Account toAccount;
    private int toAccountAmount;
    private int mount;
    private LocalDate createAt;
}
