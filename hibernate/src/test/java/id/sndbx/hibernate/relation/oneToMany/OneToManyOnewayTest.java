package id.sndbx.hibernate.relation.oneToMany;

import ib.sndbx.hibernate.relation.oneToMany.oneway.Bag;
import ib.sndbx.hibernate.relation.oneToMany.oneway.Item;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@EnableAutoConfiguration
@ContextConfiguration(classes = OneToManyOnewayTest.Config.class)
@DataJpaTest
public class OneToManyOnewayTest {

    @EntityScan(basePackages = "ib.sndbx.hibernate.relation.oneToMany.oneway")
    @Configuration
    static class Config {
    }

    @PersistenceContext
    EntityManager manager;

    @Test
    void easyAddTest() {
        Bag bag = new Bag();
        Item a = new Item(null, "a");
        bag.getItems().add(a);
        manager.persist(a);
        manager.persist(bag);
        manager.flush();

        bag.getItems().add(new Item(null, "b")); // add without saving
        manager.merge(bag);
    }

}
