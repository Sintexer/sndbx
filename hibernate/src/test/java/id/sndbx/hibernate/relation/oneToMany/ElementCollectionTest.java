package id.sndbx.hibernate.relation.oneToMany;

import ib.sndbx.hibernate.relation.elementCollection.Bag;
import ib.sndbx.hibernate.relation.elementCollection.Item;
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
@ContextConfiguration(classes = ElementCollectionTest.Config.class)
@DataJpaTest
public class ElementCollectionTest {

    @EntityScan(basePackages = "ib.sndbx.hibernate.relation.elementCollection")
    @Configuration
    static class Config {
    }

    @PersistenceContext
    EntityManager manager;

    @Test
    void persistTest() {
        Bag bag = new Bag();
        manager.persist(bag); // Cascade persist

        manager.flush();
        manager.clear();
    }

    @Test
    void beforeFlushAdd() {
        Bag bag = new Bag();
        manager.persist(bag); // Cascade persist
        Item a = new Item(null, "A");
        Item b = new Item(null, "B");
        Item c = new Item(null, "C");
        Item d = new Item(null, "D");
        manager.persist(a);
        manager.persist(b);
        manager.persist(c);
        manager.persist(d);
        bag.getItems().add(a);
        bag.getItems().add(b);
        bag.getItems().add(c);
        bag.getItems().add(d);
        manager.merge(bag);
        manager.flush();
        manager.clear();

        Bag bag2 = manager.find(Bag.class, bag.getId());
        Assertions.assertEquals(4L, bag2.getItems().size());
        Assertions.assertNotNull(bag2.getItems().stream().findAny().get().getId());
    }

    @Test
    void addTest() {
        Bag bag = new Bag();
        Item a = new Item(null, "A");
        manager.persist(a);
        bag.getItems().add(a);
        manager.persist(bag);
        manager.flush();
        manager.clear();

        Bag bag2 = manager.find(Bag.class, bag.getId());
        Item b = new Item(null, "B");
        manager.persist(b);
        bag2.getItems().add(b);
        manager.flush();

        Bag bag3 = manager.find(Bag.class, bag.getId());
        Assertions.assertEquals(2, bag3.getItems().size());
    }
}
