package model;

import java.sql.Timestamp;

public class Computer {
	private String namePC;//Obligatoire
	private int nameManuf;
	private Timestamp dateB;
	private Timestamp dateF;//Supérieur à dateB
	
	public Computer(String namePC, int nameManuf, Timestamp dateIntro, Timestamp dateExit) {
		super();
		this.setNamePC(namePC);
		this.setNameManuf(nameManuf);
		this.setDateB(dateIntro);
		this.setDateF(dateExit);
	}

	public Computer() {
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

	public int getNameManuf() {
		return nameManuf;
	}

	public void setNameManuf(int nameManuf) {
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
		String computer="Name: "+ namePC + "\n Introduction : " +  dateB + "\n Discontinuation: " + dateF + "\n Company Number: "+ nameManuf;
		return computer;
	}

}
