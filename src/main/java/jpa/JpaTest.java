package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Magazine;
import service.MagazineService;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			
			Magazine mag1 = new Magazine();
			mag1.setPrix(4);
			mag1.setTitle("LinuxMag");
			manager.persist(mag1);
			
			Magazine mag2 = new Magazine();
			mag2.setPrix(2);
			mag2.setTitle("LinuxMag");
			manager.persist(mag2);
			
			Magazine mag3 = new Magazine();
			mag3.setPrix(7);
			mag3.setTitle("MISC");
			manager.persist(mag3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		MagazineService magService = new MagazineService();
		System.out.println("Q1 = " +magService.tousLesMagazines().size());
		System.out.println("Q2 = " +magService.tousLesMagazinesLinuxMag().size());
		System.out.println("Q3 = " +magService.tousLesMagazinesLinuxMagOuMisc().size());
		System.out.println("Q4 = " +magService.tousLesMagazinesDontPrixEntre3et5().size());
		System.out.println("Q5 = " +magService.tousLesMagazinesDontPrixEntre3et5ou7().size());
		System.out.println("Q6 = " +magService.tousLesMagazinesDontLeTitreCommenceParL().size());
		System.out.println("Q6bis = " +magService.tousLesMagazinesDontLeTitreIDeuxiemePosition().size());
		System.out.println("Q7 = " +magService.tousLesMagazinesDontLeTitreestSoitSoitSoit().size());
		System.out.println("Q8 = " +magService.tousLesMagazinesSansArticle().size());
		System.out.println("Q9 = " +magService.tousLesMagazinesSansEditeur().size());
		System.out.println("Q10 = " +magService.tousLesMagazinesDontEditeurEstDiamond().size());
		
		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}
	

}
