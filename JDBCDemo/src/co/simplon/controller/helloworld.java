package co.simplon.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.model.Pays;
import co.simplon.dao.*;



@WebServlet(urlPatterns = "/helloworld", loadOnStartup = 1)

public class helloworld extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    
    private PaysDAO paysDao;

    public void init() throws ServletException {

        DAOContext daoContext = new DAOContext();
        this.paysDao = daoContext.getPaysDao();
    }
    
    
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// récupération de la liste des pays
		request.setAttribute("Lpays", paysDao.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/country.jsp").forward(request, response);
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Pays pays = new Pays();
		
		pays.setNom(request.getParameter("nom"));
		paysDao.ajouter(pays);
		request.setAttribute("Lpays", paysDao.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/country.jsp").forward(request, response);

	}

}
