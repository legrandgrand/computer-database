package dao;

import java.util.List;

import model.Computer;

public interface ComputerDao {
	
	public List<Computer> ListComputers();
	public void DeleteComputers(Computer computer);
	public void UpdateComputers(Computer computer);	
	public void AddComputers(Computer computer);
	

}
