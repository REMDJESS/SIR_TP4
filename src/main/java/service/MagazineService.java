package service;

import java.util.List;

import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import domain.Article;
import domain.Magazine;
import jpa.EntityManagerHelper;


@Path("/magazine")
public class MagazineService {

	// Q1 et dicsussion Q12
	@GET
	@Produces()
	public List<Magazine> tousLesMagazines() {
//		String query = "select mag from Magazine as mag join fetch maf.articles";
		String query = "select mag from Magazine as mag";
			List<Magazine> mags = EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
		
		for (Magazine m : mags){
			for (Article a : m.getArticles()){
				System.out.println(a.getTitle());
			}
		}
		
		return mags;
	}

	// Q2
	public List<Magazine> tousLesMagazinesLinuxMag() {
		String query = "select mag from Magazine as mag wHeRe" + " mag.title = 'LinuxMag'";
		return EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
	}

	// Q3
	public List<Magazine> tousLesMagazinesLinuxMagOuMisc() {
		String query = "select mag from Magazine as mag " + "wHeRe mag.title = 'LinuxMag' or mag.title = 'MISC'";
		return EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
	}

	// Q4
	public List<Magazine> tousLesMagazinesDontPrixEntre3et5() {
		String query = "select mag from Magazine as mag " + "wHeRe mag.prix between 3 and 5";
		// String query = "select mag from Magazine as mag "
		// + "wHeRe mag.prix > 3 and mag.prix < 5";
		return EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
	}

	// Q5
	public List<Magazine> tousLesMagazinesDontPrixEntre3et5ou7() {
		String query = "select mag from Magazine as mag " + "wHeRe mag.prix between 3 and 5 or mag.prix = 7";
		// String query = "select mag from Magazine as mag "
		// + "wHeRe mag.prix > 3 and mag.prix < 5 or mag.prix = 7";
		return EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
	}

	// Q6
	public List<Magazine> tousLesMagazinesDontLeTitreCommenceParL() {
		String query = "select mag from Magazine as mag " + "wHeRe mag.title like 'L%'";
		return EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
	}

	// Q6bis
	public List<Magazine> tousLesMagazinesDontLeTitreIDeuxiemePosition() {
		String query = "select mag from Magazine as mag " + "wHeRe mag.title like '_I__'";
		return EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
	}

	// Q7
	public List<Magazine> tousLesMagazinesDontLeTitreestSoitSoitSoit() {
		String query = "select mag from Magazine as mag " + "wHeRe mag.title IN ('LinuxMag', 'MISC', 'Marianne')";
		return EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
	}

	// Q8
	public List<Magazine> tousLesMagazinesSansArticle() {
		String query = "select mag from Magazine as mag " + "wHeRe mag.articles is empty";
		return EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
	}

	// Q9
	public List<Magazine> tousLesMagazinesSansEditeur() {
		String query = "select mag from Magazine as mag " + "wHeRe mag.publisher is null";
		return EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
	}

	// Q10
	public List<Magazine> tousLesMagazinesDontEditeurEstDiamond() {
		String query = "select mag from Magazine as mag " + "wHeRe mag.publisher.name = 'Diamond'";
		return EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
	}

	// Q11
	public List<Magazine> tousLesMagazinesContenantArticleEcritParJMJ() {
		String query = "select mag from Magazine as mag join mag.articles as art" +
	"wHeRe art.auteur.name = 'Jean-Marc Jézéquel'";
		return EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
	}
	// Q11bis
	public List<Magazine> tousLesMagazinesContenantArticleEcritParJMJbis() {
		String query = "select distinct a.magazine from Article as a" +
	"wHeRe a.auteur.name = 'Jean-Marc Jézéquel'";
		return EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
	}

	
	// Q12
	public List<Magazine> tousLesMagazinesContenantArticlePrecharge() {
		String query = "select mag from Magazine as mag join fetch mag.articles where mag.title = 'LinuxMag'";
		return EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
	}

	// Q13
	public List<Magazine> tousLesMagazinesDontLeTitreLongeur4() {
		String query = "select mag from Magazine as mag "
				+ "where Length(mag.title) = 4";
		return EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
	}

	// Q14
	public List<Magazine> tousLesMagazinesDontLeTitreContientIenDeuxieme() {
		String query = "select mag from Magazine as mag "
				+ "where substring(mag.title,2,1) = 'I'";
		return EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
	}
	
	//Q15 requête polymorphique donc on récupère des instances de magazines
	//ou sous classes de magazine

	// Q16
	public List<Magazine> tousLesMagazinesDontLeTitreetPrixParametre(String titre
			, int prix) {
		String query = "select mag from Magazine as mag "
				+ "where mag.title = :titre and m.prix = :prix";
		/*return EntityManagerHelper.getEntityManager().createQuery(query)
				.setParameter("titre", titre)
				.setParameter("prix", prix).getResultList();*/
		
		Query q = EntityManagerHelper.getEntityManager().createQuery(query);
		q.setParameter("titre", titre);
		q.setParameter("prix", prix);
		return q.getResultList();
	}

	// Q16 à ne pas faire injection SQL
	public List<Magazine> tousLesMagazinesDontLeTitreetPrixParametreAEviter(String titre
			, int prix) {
		String query = "select mag from Magazine as mag "
				+ "where mag.title = "+titre+ " and m.prix = "+ prix;
		return EntityManagerHelper.getEntityManager().createQuery(query)
				.getResultList();
		
	}

	// Q17
	public List<Magazine> tousLesMagazinesDontLeTitreetPrixParametreNameQuery(String titre
			, int prix) {
		return EntityManagerHelper.getEntityManager().
				createNamedQuery("touslesmagazinesdontlenomettitresontparametres")
				.setParameter("titre", titre)
				.setParameter("prix", prix).getResultList();
		
	}

	// Q18
	public List<Magazine> troisPremierMagazineParOrdreCroissant() {
		String query = "select mag from Magazine as mag order by mag.prix ASC";
		return EntityManagerHelper.getEntityManager().createQuery(query)
				.setFirstResult(1).setMaxResults(3).getResultList();
	}



	
}
