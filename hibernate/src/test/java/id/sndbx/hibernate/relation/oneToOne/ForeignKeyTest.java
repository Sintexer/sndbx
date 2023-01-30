package id.sndbx.hibernate.relation.oneToOne;

import ib.sndbx.hibernate.relation.oneToOne.foreignKey.Address;
import ib.sndbx.hibernate.relation.oneToOne.foreignKey.Shipment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@EnableAutoConfiguration
@ContextConfiguration(classes = ForeignKeyTest.Config.class)
@DataJpaTest
public class ForeignKeyTest {

    @EntityScan(basePackages = "ib.sndbx.hibernate.relation.oneToOne.foreignKey")
    @Configuration
    static class Config {
    }

    @PersistenceContext
    EntityManager manager;

    @Test
    void persistTest() {
        Address address = new Address("Jameson st.");
        Shipment shipment = new Shipment("item1", address);
        // Shipment and address has separate id generators
        manager.persist(shipment); // Cascade persist
        Assertions.assertNotNull(shipment.getId());
        Assertions.assertNotNull(address.getId());
        Assertions.assertNotNull(shipment.getShipmentAddress());
        Assertions.assertNotNull(shipment.getShipmentAddress().getId());
        Assertions.assertEquals(shipment.getShipmentAddress().getId(), address.getId());

        manager.flush();
        manager.clear();
    }
}
