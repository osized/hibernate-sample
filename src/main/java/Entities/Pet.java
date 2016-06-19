package Entities;

import javax.persistence.*;

@Entity
@Table(name = "Pet")
public class Pet {

    public Pet(Person owner, String name) {
        this.owner = owner;
        this.name = name;
    }

    public Pet() {}

    @Override
    public String toString(){
        return "A pet with id: " + this.id + "\n" +
                "Named " + this.name + "\n" +
                "Whos owner is " + this.owner;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, updatable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person owner;


    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
