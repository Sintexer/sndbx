package ib.sndbx.hibernate.inheritance.classToTable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AdminAccount extends Account {

    private long privilegeType;

    public AdminAccount(String name, long privilegeType) {
        super(name);
        this.privilegeType = privilegeType;
    }
}
