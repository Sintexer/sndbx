package id.sndbx.hibernate.inheritance.classToTable;


import ib.sndbx.hibernate.inheritance.classToTable.Account;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@EnableAutoConfiguration
@ContextConfiguration(classes = ClassToTableConfig.class)
@DataJpaTest
public class ClassToTableInheritanceTest {

    private static final Logger log = LoggerFactory.getLogger(ClassToTableInheritanceTest.class);

    @PersistenceContext
    EntityManager manager;

    @Test
    void persistTest() {
        Account firstAccount = new Account("Alice");
        Account secondAccount = new Account("Pavel");
        manager.persist(firstAccount);
        manager.persist(secondAccount);

        log.info("first: {}", firstAccount.getId());
        log.info("first: {}", secondAccount.getId());

        Account found1Account = manager.find(Account.class, firstAccount.getId());
        Account found2Account = manager.find(Account.class, secondAccount.getId());
        log.info("1 Account name: {}", found1Account.getName());
        log.info("2 Account name: {}", found2Account.getName());

        assertNotEquals(found1Account.getName(), found2Account.getName());
    }

}
