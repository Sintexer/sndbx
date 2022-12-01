package ib.sndbx.hibernate.inheritance.classToTableWithSuperTable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter
@Setter
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "USER_ID")
public class UserAccount extends Account {

    private String surname;

    public UserAccount(String name, String surname) {
        super(name);
        this.surname = surname;
    }
}
