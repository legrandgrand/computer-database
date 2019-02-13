package controller;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.DaoFactory;
import model.Company;
import model.Computer;

/**
 * The Class Controller.
 */
public class Controller {
	
	/**
	 * Instantiates a new controller.
	 */
	public Controller() {}
	

	
	/**
	 * List company.
	 */
	public void listCompany() {
		List<Company> list = DaoFactory.getCompanyDao().listCompanies();
		Company company = new Company();
		 Iterator<Company> itr = list.iterator();
		 while(itr.hasNext()) {
			 company = (Company) itr.next();
			 System.out.println(company);
		 }
	}
	
	/**
	 * List computer.
	 */
	public void listComputer() {
		List<Computer> list = DaoFactory.getComputerDao().listComputers();
		Computer computer = new Computer();
		Iterator<Computer> itr = list.iterator();
		while(itr.hasNext()) {
			computer = (Computer) itr.next();
			System.out.println(computer);
		}
		
	}
	
	/**
	 * Delete company.
	 *
	 * @param name the name
	 */
	public void deleteCompany(String name) {
		DaoFactory.getComputerDao().deleteComputer(name);
	}
	
	/**
	 * Sets the computer name.
	 *
	 * @param sc the scanner
	 * @return the ComputerName
	 */
	public String setComputerName(Scanner sc) {
		return sc.nextLine();
	}
	
	/**
	 * Sets the computer intro.
	 *
	 * @param sc the scanner
	 * @return the timestamp
	 */
	public Timestamp setComputerIntro(Scanner sc) {
		Timestamp intro = null;
		String timestamp = null;
		timestamp=sc.nextLine();
		if(!timestamp.equals("")) {
			intro = setTimestamp(timestamp);
		}
		return intro;
	}
	
	/**
	 * Sets the computer disc.
	 *
	 * @param sc the scanner
	 * @param intro the date of introduction
	 * @return the date of discontinuation
	 */
	public Timestamp setComputerDisc(Scanner sc, Timestamp intro) {
		Timestamp discontinuation = null;
		String timestamp2 = null;	
		do {
			timestamp2=sc.nextLine();
			if(!timestamp2.equals("")) {
				discontinuation = setTimestamp(timestamp2);
				if(discontinuation.before(intro)) {
					System.out.println("The date you entered happened before the date of introduction. Please enter a valid date.");
				}
			}
			else {
				break;
			}
		} while(discontinuation.before(intro));
		
		return discontinuation;
		
	}
	
	/**
	 * Sets the computer company id.
	 *
	 * @param sc the scanner
	 * @return the Company Id
	 */
	public int  setComputerCompanyId(Scanner sc) {
		return sc.nextInt();	
	}
	
	/**
	 * Adds the computer.
	 *
	 * @param name the name
	 * @param intro the date of introduction
	 * @param discontinuation the date of discontinuation
	 * @param companyId the company id
	 * @return the computer
	 */
	public Computer addComputer(String name, Timestamp intro, Timestamp discontinuation, int companyId) {
		Computer computer=new Computer(name, companyId, intro, discontinuation);
		DaoFactory.getComputerDao().addComputer(computer);
		return computer;
	}
	
	/**
	 * Update computer.
	 *
	 * @param name the computer name
	 * @param intro the date of introduction
	 * @param discontinuation the date of discontinuation
	 * @param companyId the company id
	 * @return the computer
	 */
	public Computer updateComputer(String name, Timestamp intro, Timestamp discontinuation, int companyId) {
		Computer computer=new Computer(name, companyId, intro, discontinuation);
		DaoFactory.getComputerDao().updateComputer(computer);
		return computer;
	}
	
	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the timestamp to change
	 * @return the timestamp
	 */
	public Timestamp setTimestamp(String timestamp){	
		timestamp=timestamp+" 00:00:00";
		return Timestamp.valueOf(timestamp);
	}

}
