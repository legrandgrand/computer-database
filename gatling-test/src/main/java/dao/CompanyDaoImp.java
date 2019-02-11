package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Company;

public class CompanyDaoImp implements CompanyDao {
	
	@Override
	public List<Company> ListCompany() {
		List<Company> list= new ArrayList<Company>();
		DaoFactory factory = new DaoFactory();
		Connection connection=null;
		try {
			connection = factory.ConnectDB(connection);
			/* Création de l'objet gérant les requêtes */
			Statement statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT id, name FROM company");
	
			 while(resultat.next()) {
				 int id=resultat.getInt("id");
				 String name=resultat.getString("name");
				 Company company=new Company(name);
				 list.add(company);
			}
			} catch ( SQLException e ) {
		    } finally {
		        if ( connection != null ) {
		                try {
							connection.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
		    }
	    }

		return list;
	}
	

}
