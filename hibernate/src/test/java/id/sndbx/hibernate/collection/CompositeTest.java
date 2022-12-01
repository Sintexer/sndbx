package id.sndbx.hibernate.collection;


import ib.sndbx.hibernate.collection.composite.Comment;
import ib.sndbx.hibernate.collection.composite.Post;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableAutoConfiguration
@ContextConfiguration(classes = CompositeTest.Config.class)
@DataJpaTest
public class CompositeTest {

    @EntityScan(basePackages = "ib.sndbx.hibernate.collection.composite")
    @Configuration
    static class Config {
    }

    @PersistenceContext
    EntityManager manager;

    @Test
    void persistTest() {
        Post post = new Post("Java#1");
        post.getComments().add(new Comment("Yay", 100));
        post.getComments().add(new Comment("Bad", 2));
        post.getComments().add(new Comment("ZZZZ", 2000));

        manager.persist(post);
        manager.flush();
        manager.detach(post);
        manager.clear(); // clear 1st layer cache to perform select

        Post foundPost = manager.find(Post.class, post.getId());
        assertEquals(post.getComments().size(), foundPost.getComments().size());
        for (Comment comment : post.getComments()) {
            assertTrue(foundPost.getComments().contains(comment));
        }
    }

}
