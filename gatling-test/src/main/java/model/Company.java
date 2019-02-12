package model;

public class Company {
	
	private String nameCompany;



	public Company(String nameCompany) {
		super();
		this.setNameCompany(nameCompany);
	}

	public Company() {
		// TODO Auto-generated constructor stub
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	@Override
	public String toString() {
		return "Company:" + nameCompany;
	}
}
