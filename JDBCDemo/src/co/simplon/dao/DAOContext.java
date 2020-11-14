package co.simplon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContext;

public class DAOContext {
	
	static String urldb = "jdbc:mysql://localhost:3306/testjdbc";
	static String usern = "root";
	static String pswd = "nata0904elle0909";
	
	
	public static Connection get_Connection() throws SQLException{
		
		try {
			
			// démarrage le pilote de la database
			Class.forName("com.mysql.jdbc.Driver");
		}
		
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection connexion = DriverManager.getConnection(urldb, usern, pswd);
		System.out.println("Bon travail");
		
		// retour d'un objet de type connexion
		return connexion;
	}
	
	public PaysDAO getPaysDao() {
		return new PaysDaoImpl(this);
		
		
		
	}

	
	public static void init (ServletContext context) {

        try {
            Class.forName(context.getInitParameter("JDBC_DRIVER"));
            urldb = context.getInitParameter( "JDBC_URL");
            usern = context.getInitParameter( "JDBC_LOGIN");
            pswd = context.getInitParameter("JDBC_PASSWORD");

        } catch(Exception exception) {
            exception.printStackTrace();
        }

    }

}



	
