package model;

import java.util.Date;

public class Employee {
	private int ID;
	private String NAME;
	private int AGE;
	private Date TIMESTAMP;

	public Employee(int iD, String nAME, int aGE, Date tIMESTAMP) {
		ID = iD;
		NAME = nAME;
		AGE = aGE;
		TIMESTAMP = tIMESTAMP;
	}


	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public int getAGE() {
		return AGE;
	}

	public void setAGE(int aGE) {
		AGE = aGE;
	}

	public Date getTIMESTAMP() {
		return TIMESTAMP;
	}

	public void setTIMESTAMP(Date tIMESTAMP) {
		TIMESTAMP = tIMESTAMP;
	}


	@Override
	public String toString() {
		return "Employee [ID=" + ID + ", NAME=" + NAME + ", AGE=" + AGE + ", TIMESTAMP=" + TIMESTAMP + "]";
	}
	
	
}
