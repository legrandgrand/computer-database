package dao;

import java.util.List;

import model.Computer;

public interface ComputerDao {
	
	public List<Computer> listComputers();
	public void deleteComputer(String computerName);
	public void updateComputer(Computer computer);	
	public void addComputer(Computer computer);	

}
