package org.perso.jbank.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "account_app")
public class Account {
    @Id
    @SequenceGenerator(name = "accountIdSequence", sequenceName = "accountIdSequence", initialValue = 1)
    @GeneratedValue(generator = "accountIdSequence")
    private int id;
    private int accountNumber;
    private int currentCredit;
    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "account")
    @JoinColumn(name = "user_app", referencedColumnName = "id")
    private User user;
}

