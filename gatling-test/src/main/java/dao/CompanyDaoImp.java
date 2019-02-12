package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Company;
//Add function to find the company's id with the company name
public class CompanyDaoImp implements CompanyDao {
	
	@Override
	public List<Company> listCompanies() {
		List<Company> list= new ArrayList<Company>();
		DaoFactory factory = new DaoFactory();
		Connection connection=null;
		try {
			connection = factory.connectDB(connection);
			String sql = "SELECT id, name FROM company";
			/* Création de l'objet gérant les requêtes */
			Statement statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery(sql);
	
			 while(resultat.next()) {
				 //int id=resultat.getInt("id");
				 String name=resultat.getString("name");
				 Company company=new Company(name);
				 list.add(company);		 
			}
			} catch ( SQLException e ) {
				System.out.println("RIP");
		    } finally {
		        if ( connection != null ) {
		                try {
		                	System.out.println("RIP2");
							connection.close();
						} catch (SQLException e) {
							System.out.println("RIP3");
							e.printStackTrace();
						}
		    }
	    }

		return list;
	}
	

}
