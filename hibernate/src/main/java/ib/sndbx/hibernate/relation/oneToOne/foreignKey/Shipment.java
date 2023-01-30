package ib.sndbx.hibernate.relation.oneToOne.foreignKey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Shipment {

    @Id
    @GeneratedValue
    private Long id;

    private String itemName;

    @OneToOne(optional = false,
    cascade = CascadeType.PERSIST)
    @JoinColumn(unique = true)
    private Address shipmentAddress;

    public Shipment(String itemName, Address shipmentAddress) {
        this.itemName = itemName;
        this.shipmentAddress = shipmentAddress;
    }
}
