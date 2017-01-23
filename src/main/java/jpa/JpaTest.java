package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.ElectronicDevice;
import domain.Home;
import domain.Person;

/**
 *
 * @author ANANI
 */
public class JpaTest {

    private EntityManager manager;

    public JpaTest(EntityManager manager) {
        this.manager = manager;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("example");
        EntityManager manager = factory.createEntityManager();
        JpaTest test = new JpaTest(manager);

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        try {
            test.createPerson();

        } catch (Exception e) {
            e.printStackTrace();
        }

        tx.commit();

        test.listPerson();
        test.listHome();

        manager.close();
        System.out.println("done");
    }

    
    private void createPerson() {
        int nbPerson = manager.createQuery("Select p From Person p", Person.class).getResultList().size();
        if (nbPerson == 0) {
             //List<ElectronicDevice> ed = new ArrayList<ElectronicDevice>();

            Home home1 = new Home(500, 3, "beaulieu");
            Home home2 = new Home(70, 5, "joliot");
            Home home3 = new Home(100, 6, "mirabeau");
            home1.getEquipement();
            manager.persist(home1);
            manager.persist(home2);
            manager.persist(home3);
            Person person1 = new Person("anani", "raymond", "ankor@gmail.com");
            Person person2 = new Person("Vasquez", "Antonio", "antonio@gmail.com");
            manager.persist(person1);
            manager.persist(person2);
          
        }
    }
     
    private void listPerson() {
        List<Person> listPerson = manager.createQuery("Select p From Person p", Person.class).getResultList();

        System.out.println("num of personnes:" + listPerson.size());
        for (Person next : listPerson) {
            System.out.println("next personne : " + next);
        }
    }

    private void listHome() {
        List<Home> listHome = manager.createQuery("Select p From Home p", Home.class).getResultList();

        System.out.println("num of home:" + listHome.size());
        for (Home next : listHome) {
            System.out.println("next home: " + next.getNameHome());
        }
    }

}
