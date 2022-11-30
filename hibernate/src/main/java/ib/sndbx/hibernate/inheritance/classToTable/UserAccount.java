package ib.sndbx.hibernate.inheritance.classToTable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserAccount extends Account {

    private String surname;

    public UserAccount(String name, String surname) {
        super(name);
        this.surname = surname;
    }
}
