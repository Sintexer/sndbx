package ib.sndbx.hibernate.inheritance.singleClass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("ADMIN")
@Entity
public class AdminAccount extends Account {

    private long privilegeType;

    public AdminAccount(String name, long privilegeType) {
        super(name);
        this.privilegeType = privilegeType;
    }
}
