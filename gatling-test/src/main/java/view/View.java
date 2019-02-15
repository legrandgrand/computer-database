package view;

import java.sql.Timestamp;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Controller;
import model.Computer;

/**
 * The Class View.
 */
public class View {
	
	/** The controller. */
	private Controller controller;
	
	/**
	 * Instantiates a new view.
	 *
	 * @param controller the controller
	 */
	public View(Controller controller) {
		this.controller=controller;
		System.out.print("Welcome to the computer database program.");
		mainMenu();	
	}
	
	
	
	/**
	 * Main menu.
	 */
	public void mainMenu() {
		System.out.println("What would you like to do?"
				+ "\n1. List Manufacturer companies."			
				+ "\n2. List Computer database."
				+ "\n3. Add a Computer to the database."
				+ "\n4. Delete a Computer from the database."
				+ "\n5. Update a Computer in the database."
				+ "\n6. Exit program."); 
		Scanner sc = new Scanner(System.in);
		try {
			int userChoice = sc.nextInt();
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
		} catch ( InputMismatchException e ) {
			System.out.println("Not a valid input.");
			
			mainMenu();
		}
	
	}

		
	/**
	 * List companies.
	 */
	public void listCompanies() {
		System.out.println("We will now list all companies of manufacturers.");
		 controller.listCompany();
		 mainMenu();
	}
	
	/**
	 * List computers.
	 */
	public void listComputers() {
		System.out.println("We will now list all computers of the database.");
		controller.listComputer();
		mainMenu();
	}
	
	
	/**
	 * Adds the computer.
	 */
	private void addComputer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("We will now add a new computer."
				+ "Please enter the computer's name you want to add");
		String name=controller.setComputerName(sc);
		
		
		System.out.println("Please enter the date of introduction. Format should be YYYY-MM-DD. (If the date is unknown, just press enter.)");
		try {
			Timestamp intro = controller.setComputerIntro(sc);
		
			System.out.println("Please enter the date of discontinuation. Format should be YYYY-MM-DD. (If the date is unknown or the computer is still continuing, just press enter.)");		
			Timestamp discontinuation = controller.setComputerDisc(sc,intro);
		
			System.out.println("Please enter the company's number");
			int companyId = controller.setComputerCompanyId(sc);
			
			Computer computer = controller.addComputer(name, intro, discontinuation, companyId);
			System.out.println(computer + " a été rajouté");
			
			mainMenu();
		} catch (IllegalArgumentException e) {
			System.out.println("The argument you entered doesn't have the correct format. Please try again.");
	
			addComputer();
		} catch ( InputMismatchException e ) {
			System.out.println("Not a valid input. Please try again.");
			addComputer();
				
		}
	}

	
	/**
	 * Delete computer.
	 */
	private void deleteComputer() {
		System.out.println("We will now delete a computer from the database."
				+ "Please enter the computer's name you want to delete.");
		Scanner sc = new Scanner(System.in);
		String computerName=sc.nextLine();
		controller.deleteComputer(computerName);	
		System.out.println(computerName + "a été supprimé");
		mainMenu();
	}

	/**
	 * Update computer.
	 */
	private void updateComputer() {
		
		System.out.println("We will now update a computer from the database."
				+ "\nPlease enter the computer's name you want to update.");
		Scanner sc = new Scanner(System.in);
		String name=sc.nextLine();
		
		System.out.println("Please enter the date of introduction you want to update. Format should be YYYY-MM-DD. (If the date is unknown, just press enter.)");
		try{
			Timestamp intro = controller.setComputerIntro(sc);
			
			System.out.println("Please enter the date of discontinuation you want to update. Format should be YYYY-MM-DD. (If the date is unknown or the computer is still continuing, just press enter.)");		
			Timestamp discontinuation = controller.setComputerDisc(sc, intro);
			
			System.out.println("Please enter the company's name you want to update");
			int companyId = controller.setComputerCompanyId(sc);
			
			//int companyId = DaoFactory.getCompanyDao().getCompany(companyName); //TODO: handle null/wrong values
			Computer computer = controller.updateComputer(name, intro, discontinuation, companyId);
			System.out.println(computer + " a été mis à jour");
			
			mainMenu();
			} catch (IllegalArgumentException e) {
				System.out.println("The argument you entered doesn't have the correct format. Please try again.");
				updateComputer();
			}catch ( InputMismatchException e ) {
				System.out.println("Not a valid input. Please try again.");
				updateComputer();
		}
	}


	
	

}
