package ib.sndbx.hibernate.inheritance.classToTableWithSuperTable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    public Account(String name) {
        this.name = name;
    }
}
