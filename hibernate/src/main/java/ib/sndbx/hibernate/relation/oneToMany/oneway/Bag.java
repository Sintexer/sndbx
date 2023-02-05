package ib.sndbx.hibernate.relation.oneToMany.oneway;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bag {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private Collection<Item> items = new ArrayList<>();
}
