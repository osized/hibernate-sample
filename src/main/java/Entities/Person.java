package Entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by AYUdin on 4/21/2016.
 */

@Entity
@Table(name = "Person")
public class Person {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @OneToMany
    @JoinColumn(name = "person_id")
    private List<Pet> pets;

    @Column(name = "person_name")
    private String name;

    @Column(name = "description")
    private String description;



    @Override
    public String toString(){
        return "A person with id: " + this.id + "\n" +
                "Named " + this.name + "\n" +
                "description: " + this.description;
    }



    public Person(){}

    public Person(String name, String description){
        this.name = name;
        this.description = description;
    }


    public void setDescription(String description) {
        this.description = description;
    }
}
