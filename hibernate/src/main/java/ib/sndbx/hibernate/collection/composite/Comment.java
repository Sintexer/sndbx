package ib.sndbx.hibernate.collection.composite;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Comment {

    @Column(nullable = false)
    private String content;

    private long likes;

}
