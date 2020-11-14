package co.simplon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import co.simplon.model.Pays;

public class PaysDaoImpl implements PaysDAO{

    private DAOContext daoContext;

    //constructeur
    public PaysDaoImpl(DAOContext daoContext) {
        this.daoContext = daoContext;
    }

    @Override 
    public void ajouter(Pays pays) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
        	
        	// exploitation de la méthode get_Connection de DAOContext.java
            connexion = DAOContext.get_Connection();
            
            preparedStatement = connexion.prepareStatement("INSERT INTO pays(nom) VALUES(?);");
            preparedStatement.setString(1, pays.getNom());
            
            // finalisation - exécution du status connexion
            preparedStatement.executeUpdate();
            
            
            // autre méthode offrant une plus grande manipulation des valeurs id et nom
            //preparedStatement = connexion.prepareStatement("INSERT INTO pays(id, nom) VALUES(?,?);");
            //preparedStatement.setInt(1, pays.getId());
            //preparedStatement.setString(2, pays.getNom());


        } catch (SQLException e) {

            e.printStackTrace();
        }
    }





@Override 
    public List<Pays> lister() {

        List<Pays> Lpays = new ArrayList<Pays>();

        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        
        try {
            connexion = DAOContext.get_Connection();
            statement = connexion.createStatement();

  
            resultat = statement.executeQuery("SELECT id, nom FROM testjdbc.pays;");


        while(resultat.next()) {

            int id = resultat.getInt("id");
            String nom = resultat.getString("nom");

            Pays pays = new Pays(id,nom);
            pays.setId(id);
            pays.setNom(nom);
            Lpays.add(pays);

        }

        }

        catch (SQLException e) {
            e.printStackTrace();

        }

// retour de la liste Pays
        return Lpays;


			}
     }
   