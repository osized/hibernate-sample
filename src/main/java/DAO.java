import Entities.Person;
import Entities.Pet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Collections;
import java.util.List;

/**
 * Created by AYUdin on 5/13/2016.
 */
public class DAO {

    SessionFactory factory;

    public DAO() {

        try {
            factory = new Configuration().
                    configure().
                    addAnnotatedClass(Person.class).
                    addAnnotatedClass(Pet.class).
                    buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public boolean saveEntity(Object entityToSave) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(entityToSave);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    public List<Object> readObjects(String nameOfTable) {

        List<Object> objects = Collections.emptyList();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            objects = session.createQuery("from " + nameOfTable).list();

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return objects;
    }

    public List<Object> readObjects(String nameOfTable, int id) {

        List<Object> objects = Collections.emptyList();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            objects = session.createQuery("from " + nameOfTable + " where id=" + id).list();

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return objects;
    }
}
