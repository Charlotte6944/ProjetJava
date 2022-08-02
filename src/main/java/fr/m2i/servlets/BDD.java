package fr.m2i.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.m2i.models.Personne;

/**
 * Servlet implementation class BDD
 */
@WebServlet("/BDD")
public class BDD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String BDD = "jdbc:mysql://localhost:3306/sakila";
	private static final String LOGIN = "root";
	private static final String MDP = "FormationM2i";
	
	private static final String PAGE = "/WEB-INF/pages/BDD.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BDD() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/* Chargement driver */
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			/* Connexion à la base de données */
			Connection connection = DriverManager.getConnection(BDD, LOGIN, MDP);
			Statement statement = connection.createStatement();
			
			/* Exécution commande */
			ResultSet rs = statement.executeQuery("select first_name, last_name from actor");

			ArrayList liste = new ArrayList<Personne>();
			
			while(rs.next()) {
				System.out.println(rs.getString("first_name") + "---" + rs.getString("last_name"));
				liste.add(new Personne(rs.getString("first_name"), rs.getString("last_name")));
			}
			
			request.setAttribute("liste", liste);
			
			/* Fermer liaison DB */
			rs.close();
			statement.close();
			connection.close();
			
		} catch(SQLException e) {
			System.out.print(e);
		}
		
		this.getServletContext()
		.getRequestDispatcher(PAGE)
		.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
