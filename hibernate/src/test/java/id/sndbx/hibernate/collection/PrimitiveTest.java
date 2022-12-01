package id.sndbx.hibernate.collection;


import ib.sndbx.hibernate.collection.primitive.Post;
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
@ContextConfiguration(classes = PrimitiveTest.Config.class)
@DataJpaTest
public class PrimitiveTest {

    @EntityScan(basePackages = "ib.sndbx.hibernate.collection.primitive")
    @Configuration
    static class Config {
    }

    @PersistenceContext
    EntityManager manager;

    @Test
    void persistTest() {
        Post post = new Post("Java#1");
        post.getComments().add("Cool!");
        post.getComments().add("Exciting");
        post.getComments().add("Boring...");
        post.getTags().add("#Java");
        post.getTags().add("#Learn");
        post.getTags().add("#Spring");

        manager.persist(post);
        manager.flush();

        post.getComments().add("First!");
        post.getTags().add("#ForgottenTag");
        manager.flush();

        post.getComments().add("Yolo");
        post.getComments().add("PUBG");
        post.getComments().add("PUBG2");
        post.getTags().add(0, "Nothing");
        manager.flush();

        post.getComments().remove("Yolo");
        post.getTags().remove("Nothing");
        manager.flush();
        manager.detach(post);

        manager.clear(); // clear 1st layer cache to perform select

        Post foundPost = manager.find(Post.class, post.getId());
        assertEquals(post.getComments().size(), foundPost.getComments().size());
        for (int i = 0; i < post.getComments().size(); i++) {
            assertEquals(post.getComments().get(i), foundPost.getComments().get(i));
        }
        for (int i = 0; i < post.getTags().size(); i++) {
            // order is saved even without @OrderColumn
            assertEquals(post.getTags().get(i), foundPost.getTags().get(i));
            assertTrue(foundPost.getTags().contains(post.getTags().get(i)));
        }
    }

}
