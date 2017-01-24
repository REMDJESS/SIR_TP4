package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author ANANI
 */
@Entity
public class Heater {

    long id;
    String nameHeater;

    Home home;

    public Heater() {
    }

    public Heater( String nameHeater, Home home) {
        this.nameHeater = nameHeater;
        this.home = home;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameHeater() {
        return nameHeater;
    }

    public void setNameHeater(String nameHeater) {
        this.nameHeater = nameHeater;
    }

    @ManyToOne
    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "Heater [id=" + id + ", marque=" + nameHeater + ", home=" + home + " ]";
    }
}
