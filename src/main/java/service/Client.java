/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Heater;
import domain.Home;
import domain.Person;
import java.util.List;
import jpa.EntityManagerHelper;

/**
 *
 * @author ANANI
 */
public class Client {

    public List<Person> toutesLesPersonnes() {
//		String query = "select mag from Magazine as mag join fetch maf.articles";
        String query = "select p from Person as p";
        List<Person> personnes = EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        for (Person p : personnes) {
            System.out.println(p.getNom() + " " + p.getPrenom() + " " + p.getMail());
        }
        return personnes;
    }

    public List<Home> toutesLesMaisons() {
//		String query = "select mag from Magazine as mag join fetch maf.articles";
        String query = "select h from Home as h";
        List<Home> maisons = EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        for (Home h : maisons) {
            System.out.println("Nom " + h.getNameHome() + " chauffages :"+ h.getHeater()+" Nombre de pieces " + h.getNbpieces());
            for (Heater heater : h.getHeater()) {
                System.out.println(" chauffages " + heater.getNameHeater() );
            }
        }
        return maisons;
    }

    public List<Heater> tousLesChauffages() {
//		String query = "select mag from Magazine as mag join fetch maf.articles";
        String query = "select h from Heater as h";
        List<Heater> chauffages = EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        for (Heater h : chauffages) {
            System.out.println("Nom chauffage " + h.getNameHeater() + " maisons " + h.getHome());
        }
        return chauffages;
    }

}
