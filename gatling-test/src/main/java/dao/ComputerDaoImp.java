package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Computer;

public class ComputerDaoImp implements ComputerDao{


	@Override
	public List<Computer> listComputers() {
		List<Computer> list= new ArrayList<Computer>();
		DaoFactory factory = new DaoFactory();
		Connection connection=null;
		
		try {
			connection = factory.connectDB(connection);
			/* Création de l'objet gérant les requêtes */
			Statement statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT name, introduced, discontinued, company_id FROM computer");
	
			 while(resultat.next()) {
				 String name=resultat.getString("name");
				 int company_id=resultat.getInt("company_id");
				 Timestamp introduced=resultat.getTimestamp("introduced");
				 Timestamp discontinued=resultat.getTimestamp("discontinued");
				 Computer computer=new Computer(name, company_id, introduced, discontinued);
				 list.add(computer);
			}
			} catch ( SQLException e ) {
				System.out.println("RIP");
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
	public void deleteComputer(String computerName) {
		DaoFactory factory = new DaoFactory();
		Connection connection=null;
		
		/*String company_id=computer.getNameManuf();
		Timestamp introduced=computer.getDateB();
		Timestamp discontinued=computer.getDateF();*/
		
		try {
			connection = factory.connectDB(connection);
			/* Création de l'objet gérant les requêtes */
			String sql=("DELETE FROM computer WHERE name= ?");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, computerName);
			statement.executeUpdate();
			
			} catch ( SQLException e ) {
				System.out.println("RIP");
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
	public void updateComputer(Computer computer) {
		DaoFactory factory = new DaoFactory();
		Connection connection=null;
		
		String name=computer.getNamePC();
		int company_id=computer.getNameManuf();
		Timestamp introduced=computer.getDateB();
		Timestamp discontinued=computer.getDateF();
		
		try {
			connection = factory.connectDB(connection);
			/* Création de l'objet gérant les requêtes */
			String sql=("UPDATE computer SET introduced = ?, discontinued = ?, company_id = ? WHERE name= ?");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setTimestamp(1, introduced);
			statement.setTimestamp(2, discontinued);
			statement.setInt(3, company_id);
			statement.setString(4, name);
			statement.executeUpdate();
			} catch ( SQLException e ) {
				System.out.println("RIP");
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

	
	
	//TODO: gérer les nulls
	@Override
	public void addComputer(Computer computer) {
		DaoFactory factory = new DaoFactory();
		Connection connection=null;
		

		String name=computer.getNamePC();
		int company_id=computer.getNameManuf();
		Timestamp introduced=computer.getDateB();
		Timestamp discontinued=computer.getDateF();
		
		try {
			connection = factory.connectDB(connection);
			/* Création de l'objet gérant les requêtes */
			String sql=("INSERT INTO computer (name,introduced,discontinued,company_id) VALUES (?,?,?,?)");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setTimestamp(2, introduced);
			statement.setTimestamp(3, discontinued);
			statement.setInt(4, company_id);
			statement.executeUpdate();
			} catch ( SQLException e ) {
				System.out.println("RIP");
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
