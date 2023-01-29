package id.sndbx.hibernate.relation.oneToOne;

import ib.sndbx.hibernate.relation.oneToOne.sharedKey.Address;
import ib.sndbx.hibernate.relation.oneToOne.sharedKey.Shipment;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@EnableAutoConfiguration
@ContextConfiguration(classes = SharedKeyTest.Config.class)
@DataJpaTest
public class SharedKeyTest {

    @EntityScan(basePackages = "ib.sndbx.hibernate.relation.oneToOne.sharedKey")
    @Configuration
    static class Config {
    }

    @PersistenceContext
    EntityManager manager;

    @Test
    void persistTest() {
        Address address = new Address("Jameson st.");
        manager.persist(address);

        Shipment shipment = new Shipment("item1", address); // Shipment doesn't has id generator and gets address id
        manager.persist(shipment);

        assertTrue(address.getId() != 0L);
        assertTrue(shipment.getId() != 0L);
        assertEquals(address.getId(), shipment.getId());
        manager.flush();
        manager.clear();

        Shipment foundShipment = manager.find(Shipment.class, shipment.getId());
        Address foundAddress = manager.find(Address.class, shipment.getId());

        assertNotNull(foundShipment);
        assertNotNull(foundAddress);
    }
}
