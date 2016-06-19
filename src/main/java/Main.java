import Entities.Person;
import Entities.Pet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by AYUdin on 4/21/2016.
 */
public class Main {

    public static void main(String[] args){
        DAO dao = new DAO();
        Person vasya = new Person("Vasiliy", "Description of Vasya");
        Pet bobique = new Pet(vasya, "Bobique");
        bobique.setOwner(vasya);
        dao.saveEntity(vasya);
        dao.saveEntity(bobique);
        List<Object> pets = dao.readObjects("Pet", 4);
        List<Object> persons = dao.readObjects("Person");

        for (Object pet: pets){
            System.out.println("Read object: " + pet.toString());
        }


    }
}
