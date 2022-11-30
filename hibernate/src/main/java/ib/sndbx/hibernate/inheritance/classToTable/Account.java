package ib.sndbx.hibernate.inheritance.classToTable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Account {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    public Account(String name) {
        this.name = name;
    }
}
