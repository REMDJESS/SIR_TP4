package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Home {

    long id;
    int taille;
    String nameHome;
    int nbpieces;

    List<Person> personne = new ArrayList<Person>();
    List<Heater> heater = new ArrayList<Heater>();
    List<ElectronicDevice> equipement = new ArrayList<ElectronicDevice>();

    public Home() {
        super();
    }

    public Home(int taille, int nbpieces, String nameHome) {
        this.taille = taille;
        this.nbpieces = nbpieces;
        this.nameHome = nameHome;
    }

    public Home(int taille, int nbpieces, String nameHome, List<Heater> heater ) {
        this.taille = taille;
        this.nbpieces = nbpieces;
        this.nameHome = nameHome;
        this.heater = new ArrayList<Heater>();
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getNbpieces() {
        return nbpieces;
    }

    public void setNbpieces(int nbpieces) {
        this.nbpieces = nbpieces;
    }

    public String getNameHome() {
        return nameHome;
    }

    public void setNameHome(String nameHome) {
        this.nameHome = nameHome;
    }

    @OneToMany(mappedBy = "home", cascade = CascadeType.PERSIST)
    public List<Person> getPersonne() {
        return personne;
    }

    public void setPersonne(List<Person> personne) {
        this.personne = personne;
    }

    @OneToMany(mappedBy = "home", cascade = CascadeType.PERSIST)
    public List<Heater> getHeater() {
        return heater;
    }

    public void setHeater(List<Heater> heater) {
        this.heater = heater;
    }

    @OneToMany(mappedBy = "home", cascade = CascadeType.PERSIST)
    public List<ElectronicDevice> getEquipement() {
        return equipement;
    }

    public void setEquipement(List<ElectronicDevice> equipement) {
        this.equipement = equipement;
    }

}
