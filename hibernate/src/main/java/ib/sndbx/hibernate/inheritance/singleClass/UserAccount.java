package ib.sndbx.hibernate.inheritance.singleClass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("USER")
@Entity
public class UserAccount extends Account {

    private String surname;

    public UserAccount(String name, String surname) {
        super(name);
        this.surname = surname;
    }
}
