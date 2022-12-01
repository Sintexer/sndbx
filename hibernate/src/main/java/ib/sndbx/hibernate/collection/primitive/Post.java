package ib.sndbx.hibernate.collection.primitive;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private List<String> tags = new ArrayList<>();

    @OrderColumn(name = "comment_index")
    @ElementCollection
    private List<String> comments = new ArrayList<>();

    public Post(String title) {
        this.title = title;
    }
}
