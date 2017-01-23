package domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ANANI
 */
@Entity
public class ElectronicDevice {

	long id;
	int consommation;
	
	Home home;
	
	public ElectronicDevice(){}
	
	public ElectronicDevice(long id, int consommation, Home home) {
		this.id = id;
		this.consommation = consommation;
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

	public int getConsommation() {
		return consommation;
	}

	public void setConsommation(int consommation) {
		this.consommation = consommation;
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	@Override
	public String toString() {
		return "ElectronicDevice [id=" + id + ", consommation=" + consommation + ", home=" + home + "]";
	}
}
