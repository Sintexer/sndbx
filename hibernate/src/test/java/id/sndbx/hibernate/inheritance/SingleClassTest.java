package id.sndbx.hibernate.inheritance;


import ib.sndbx.hibernate.inheritance.singleClass.Account;
import ib.sndbx.hibernate.inheritance.singleClass.AdminAccount;
import ib.sndbx.hibernate.inheritance.singleClass.UserAccount;
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
@ContextConfiguration(classes = SingleClassTest.Config.class)
@DataJpaTest
public class SingleClassTest {

    @EntityScan(basePackages = "ib.sndbx.hibernate.inheritance.singleClass")
    @Configuration
    static class Config {
    }

    @PersistenceContext
    EntityManager manager;

    @Test
    void persistTest() {
        Account admin = new AdminAccount("Dot", 2L);
        manager.persist(admin);
        Account user = new UserAccount("Don", "Simon");
        manager.persist(user);

        assertTrue(admin.getId() != 0L);
        assertTrue(user.getId() != 0L);

        manager.flush();
        manager.clear(); // clear 1st layer cache to perform select

        assertNotNull(manager);

        AdminAccount adminAccount = manager.find(AdminAccount.class, admin.getId());
        assertNotEquals(adminAccount.getPrivilegeType(), 0);
        UserAccount userAccount = manager.find(UserAccount.class, user.getId());
        assertNotEquals(userAccount.getSurname(), "");

        // Can query for abstract type
        assertDoesNotThrow(() -> manager.find(Account.class, 1L));
    }

}
