package ib.sndbx.hibernate.relation.oneToOne.sharedKey;

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
    private Long id;

    private String itemName;

    @OneToOne(optional = false)
    @PrimaryKeyJoinColumn
    private Address shipmentAddress;

    public Shipment(String itemName, Address shipmentAddress) {
        id = shipmentAddress.getId();
        this.itemName = itemName;
        this.shipmentAddress = shipmentAddress;
    }
}
