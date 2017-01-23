package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ANANI
 */
@Entity
@Table(name = "Person")
public class Person{
	
	long id;
	String nom;
	String prenom;
	String mail;
	
	
	List<Person> friend = new ArrayList<Person>();
	Home home;
	
	public Person(){}

	public Person(String nom, String prenom, String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
                this.mail= mail;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@ManyToMany
	public List<Person> getFriend() {
		return friend;
	}

	public void setFriend(List<Person> friend) {
		this.friend = friend;
	}
	@ManyToOne(cascade = CascadeType.PERSIST)
	public Home getHome() {
		return home;
	}


	public void setHome(Home home) {
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


	@Override
	public String toString() {
		return "Person [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", friend=" + friend
				+ ", home=" + home + " ]";
	}

}
