package ib.sndbx.hibernate.relation.elementCollection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    @ElementCollection
    private Collection<Item> items = new ArrayList<>();
}
