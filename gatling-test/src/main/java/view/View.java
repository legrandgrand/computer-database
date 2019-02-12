package view;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.CompanyDaoImp;
import dao.ComputerDaoImp;
import model.Company;
import model.Computer;

public class View {
	
	private CompanyDaoImp companyDao;
	private ComputerDaoImp computerDao;
	
	public View(CompanyDaoImp companyDao, ComputerDaoImp computerDao) {
		this.companyDao=companyDao;
		this.computerDao=computerDao;
		System.out.print("Welcome to the computer database program.");
		mainMenu();
		
	}
	
	
	
	public void mainMenu() {
		System.out.println("What would you like to do?"
				+ "\n1. List Manufacturer companies."
				
				+ "\n2. List Computer database."
				+ "\n3. Add a Computer to the database."
				+ "\n4. Delete a Computer from the database."
				+ "\n5. Update a Computer in the database."
				+ "\n6. Exit program.");
		int userChoice = 0; 
		Scanner sc = new Scanner(System.in);
		userChoice = sc.nextInt();
		System.out.println("Choix user: "+ userChoice);
		switch (userChoice) {
		case 1:
			listCompanies();
			break;
		case 2:
			listComputers();
			break;
		case 3:
			addComputer();
			break;
		case 4:
			deleteComputer();
			break;
		case 5:
			updateComputer();
			break;
		case 6:
			sc.close();
			System.exit(0);
		default:
			System.out.println("Not a valid statement.");
			mainMenu();
			break;
		}		
	}

		
	public void listCompanies() {
		System.out.println("We will now list all companies of manufacturers.");
		List<Company> list = companyDao.listCompanies();
		Company company = new Company();
		 Iterator<Company> itr = list.iterator();
		 while(itr.hasNext()) {
			 company = (Company) itr.next();
			 System.out.println(company);
		 }
		 
		 mainMenu();
	}
	
	public void listComputers() {
		System.out.println("We will now list all computers of the database.");
		List<Computer> list = computerDao.listComputers();
		Computer computer = new Computer();
		 Iterator<Computer> itr = list.iterator();
		 while(itr.hasNext()) {
			 computer = (Computer) itr.next();
			 System.out.println(computer);
		 }
		mainMenu();
	}
	
	
	//TODO: gérer les nulls/exceptions
	private void addComputer() {
		Timestamp intro = null;
		Timestamp discontinuation = null;
		String timestamp = null;
		
		System.out.println("We will now add a new computer."
				+ "Please enter the computer's name you want to add");
		Scanner sc = new Scanner(System.in);
		String name=sc.nextLine();
		
		System.out.println("Please enter the date of introduction. Format should be YYYY-MM-DD. (If the date is unknown, just press enter.)");
		timestamp=sc.nextLine();
		if(timestamp != null) {
			timestamp=timestamp+"00:00:00";
			intro = Timestamp.valueOf(timestamp);
		}
			
		System.out.println("Please enter the date of discontinuation. Format should be YYYY-MM-DD. (If the date is unknown or the computer is still continuing, just press enter.)");		
		timestamp=sc.nextLine();
		if(timestamp != null) {//Doesn't work. need to find value where that works
			timestamp=timestamp+"00:00:00";
			discontinuation = Timestamp.valueOf(timestamp);
		}
		
		System.out.println("Please enter the company's name");//TODO for now, only enter id. get the id that correspond to the name
		int company_id = sc.nextInt();
		
		Computer computer=new Computer(name, company_id, intro, discontinuation);
		computerDao.addComputer(computer);
		System.out.println(computer + " a été rajouté");
		mainMenu();
	}

	
	//TODO: gérer les nulls/exceptions
	private void deleteComputer() {
		System.out.println("We will now delete a computer from the database."
				+ "Please enter the computer's name you want to delete.");
		Scanner sc = new Scanner(System.in);
		String computerName=sc.nextLine();
		computerDao.deleteComputer(computerName);
		System.out.println(computerName + "a été supprimé");
		mainMenu();
	}

	
	//TODO: gérer les nulls/exceptions
	private void updateComputer() {
		Timestamp intro = null;
		Timestamp discontinuation = null;
		String timestamp = null;
		
		System.out.println("We will now update a computer from the database."
				+ "\nPlease enter the computer's name you want to update.");
		Scanner sc = new Scanner(System.in);
		String name=sc.nextLine();
		
		System.out.println("Please enter the date of introduction you want to update. Format should be YYYY-MM-DD. (If the date is unknown, just press enter.)");
		timestamp=sc.nextLine();
		if(timestamp != null) {
			timestamp=timestamp+"00:00:00";
			intro = Timestamp.valueOf(timestamp);
		}
		
		System.out.println("Please enter the date of discontinuation you want to update. Format should be YYYY-MM-DD. (If the date is unknown or the computer is still continuing, just press enter.)");		
		timestamp=sc.nextLine();
		if(timestamp != null) {//Doesn't work. need to find value where that works
			timestamp=timestamp+"00:00:00";
			discontinuation = Timestamp.valueOf(timestamp);
		}
		
		System.out.println("Please enter the company's name you want to update");//TODO for now, only enter id. get the id that correspond to the name
		int company_id = sc.nextInt();
		
		Computer computer=new Computer(name, company_id, intro, discontinuation);
		computerDao.updateComputer(computer);
		System.out.println(computer + " a été mis à jour");
		mainMenu();
	}




	
	

}
