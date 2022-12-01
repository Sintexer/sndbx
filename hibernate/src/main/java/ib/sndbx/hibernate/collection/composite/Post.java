package ib.sndbx.hibernate.collection.composite;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    @ElementCollection
    private Set<Comment> comments = new HashSet<>();

    public Post(String title) {
        this.title = title;
    }
}
