package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Computer;

public class ComputerDaoImp implements ComputerDao{



	@Override
	public List<Computer> ListComputers() {
		List<Computer> list= new ArrayList<Computer>();
		DaoFactory factory = new DaoFactory();
		Connection connection=null;
		
		try {
			connection = factory.ConnectDB(connection);
			/* Création de l'objet gérant les requêtes */
			Statement statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT id, name, introduced, discontinued, company_id FROM computer");
	
			 while(resultat.next()) {
				 int id=resultat.getInt("id");
				 String name=resultat.getString("name");
				 String company_id=resultat.getString("company_id");
				 Timestamp introduced=resultat.getTimestamp("introduced");
				 Timestamp discontinued=resultat.getTimestamp("discontinued");
				 Computer computer=new Computer(name, company_id, introduced, discontinued);
				 list.add(computer);
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

	@Override
	public void DeleteComputers(Computer computer) {
		List<Computer> list= new ArrayList<Computer>();
		DaoFactory factory = new DaoFactory();
		Connection connection=null;
		
		String name=computer.getNamePC();
		String company_id=computer.getNameManuf();
		Timestamp introduced=computer.getDateB();
		Timestamp discontinued=computer.getDateF();
		
		try {
			connection = factory.ConnectDB(connection);
			/* Création de l'objet gérant les requêtes */
			Statement statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery("DELETE FROM computer WHERE id=");
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
		
	}

	@Override
	public void UpdateComputers(Computer computer) {
		List<Computer> list= new ArrayList<Computer>();
		DaoFactory factory = new DaoFactory();
		Connection connection=null;
		
		String name=computer.getNamePC();
		String company_id=computer.getNameManuf();
		Timestamp introduced=computer.getDateB();
		Timestamp discontinued=computer.getDateF();
		
		try {
			connection = factory.ConnectDB(connection);
			/* Création de l'objet gérant les requêtes */
			Statement statement = connection.createStatement();
			int resultat = statement.executeUpdate("UPDATE computer SET +id, name, introduced, discontinued, company_id WHERE");
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
		
	}

	@Override
	public void AddComputers(Computer computer) {
		DaoFactory factory = new DaoFactory();
		Connection connection=null;
		
		String name=computer.getNamePC();
		String company_id=computer.getNameManuf();
		Timestamp introduced=computer.getDateB();
		Timestamp discontinued=computer.getDateF();
		
		try {
			connection = factory.ConnectDB(connection);
			/* Création de l'objet gérant les requêtes */
			Statement statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery("INSERT INTO computer" + "VALUES (" + name + ", " + company_id + ", " + introduced + "," + discontinued+ ")");
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
		
	}	
	
}
