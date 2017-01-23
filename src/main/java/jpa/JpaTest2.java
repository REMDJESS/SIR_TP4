package jpa;

import domain.Heater;
import domain.Home;
import domain.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import service.Client;

public class JpaTest2 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        EntityManager manager = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {

            Person person3 = new Person("atta", "ferdinand", "popstar@gmail.com");
            Person person4 = new Person("camara", "pascal", "aigle@gmail.com");

            manager.persist(person3);
            manager.persist(person4);
           
            Home home1 = new Home(500, 3, "beaulieu");
            Home home2 = new Home(70, 5, "joliot");
            Home home3 = new Home(100, 6, "mirabeau");
            home1.getEquipement();
            manager.persist(home1);
            manager.persist(home2);
            manager.persist(home3);
            Heater heater1 = new Heater("heater 1",home1);
            Heater heater2 = new Heater("heater 2",home1 );
            Heater heater3 = new Heater("heater 2_1",home2 );
            Heater heater4 = new Heater("heater 2_2",home2 );

            manager.persist(heater1);
            manager.persist(heater2);
            manager.persist(heater3);
            manager.persist(heater4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

//        Client personnes = new Client();
//        System.out.println("P = " + personnes.toutesLesPersonnes());
        Client m = new Client();
        System.out.println("H = " + m.toutesLesMaisons());
//        Client h = new Client();
//        System.out.println( "Chauffages = "  + h.tousLesChauffages());
        manager.close();
        EntityManagerHelper.closeEntityManagerFactory();
        //		factory.close();
    }

}
