package model;

import java.sql.Timestamp;

public class Computer {
	private String namePC;//Obligatoire
	private String nameManuf;
	private Timestamp dateB;
	private Timestamp dateF;//Supérieur à dateB
	
	public Computer(String namePC, String nameManuf, Timestamp dateB, Timestamp dateF) {
		super();
		this.setNamePC(namePC);
		this.setNameManuf(nameManuf);
		this.setDateB(dateB);
		this.setDateF(dateF);
	}

	public Timestamp getDateB() {
		return dateB;
	}

	public void setDateB(Timestamp dateB) {
		this.dateB = dateB;
	}

	public Timestamp getDateF() {
		return dateF;
	}

	public void setDateF(Timestamp dateF) {
		this.dateF = dateF;
	}

	public String getNameManuf() {
		return nameManuf;
	}

	public void setNameManuf(String nameManuf) {
		this.nameManuf = nameManuf;
	}

	public String getNamePC() {
		return namePC;
	}

	public void setNamePC(String namePC) {
		this.namePC = namePC;
	}
	
	@Override
	public String toString() {
		String computer="Name: "+ namePC + "/n Introduction : " +  dateB + "/n Discontinuation: " + dateF + "/n Company Name: "+ nameManuf;
		return computer;
	}

}
