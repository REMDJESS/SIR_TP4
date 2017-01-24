package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.JpaTest;

@WebServlet(name = "userinfo", urlPatterns = { "/UserInfo" })


public class UserInfo extends HttpServlet {
	 EntityManagerFactory factory ;
	 EntityManager manager;
	 
	@Override
public void init(ServletConfig config) throws ServletException {
	// TODO Auto-generated method stub
	super.init(config);
     factory = Persistence
            .createEntityManagerFactory("example");
    manager = factory.createEntityManager();
    JpaTest test = new JpaTest(manager);

    EntityTransaction tx = manager.getTransaction();
    tx.begin();

}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<HTML>\n<BODY>\n" + "<H1>Recapitulatif des informations</H1>\n" + "<UL>\n" + " <LI>Nom: "
				+ request.getParameter("name") + "\n" + " <LI>Prenom: " + request.getParameter("firstname") + "\n"
				+ " <LI>Age: " + request.getParameter("age") + "\n" + "</UL>\n" + "</BODY></HTML>");
	}
	
}
