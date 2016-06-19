package Entities;

/**
 * Created by AYUdin on 5/23/2016.
 */
import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "City")
public class City {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    private String name;
    private int population;
    private List<Long> coordinates;

    public City(){}
    public City(String name, int population, Long xCoord, Long yCoord){
        this.name = name;
        this.population = population;
        this.coordinates = Arrays.asList(xCoord, yCoord);
    }
}
