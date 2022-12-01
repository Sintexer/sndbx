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
@PrimaryKeyJoinColumn(name = "ADMIN_ID")
public class AdminAccount extends Account {

    private long privilegeType;

    public AdminAccount(String name, long privilegeType) {
        super(name);
        this.privilegeType = privilegeType;
    }
}
