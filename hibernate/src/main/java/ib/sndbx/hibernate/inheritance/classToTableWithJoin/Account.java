package ib.sndbx.hibernate.inheritance.classToTableWithJoin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Account {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    public Account(String name) {
        this.name = name;
    }
}
