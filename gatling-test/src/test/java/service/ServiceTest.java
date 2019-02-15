package service;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

import model.Computer;

public class ServiceTest {
	Service service = new Service();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testListComputer() {
		//Case 1: no computer
		
		//Case 2: 1 computer
				
		//Case 3: n computer
		fail("Not yet implemented");
	}

	@Test
	public void testListCompany() {
		//Case 1: no company
		
		//Case 2: 1 company
		
		//Case 3: n companies
		fail("Not yet implemented");
	}
	
	@Test
	public void testDeleteCompany() {
		//Case 1: no computer
		
		//Case 2: 1 computer
				
		//Case 3: n computer
		fail("Not yet implemented");
	}

	@Test
	public void testAddComputer() {
		//Case -1: illegal calls
		
		//Case 0: legal calls with invalid data
				
		//Case 1: All valid inputs
		String name="Alex";
		Timestamp intro=null;
		Timestamp disc=Timestamp.valueOf("1997-07-01 00:00:00");
		int companyId = 1;
		Computer computer = new Computer (name, companyId, intro, disc);
			fail("Not yet implemented");
				
		//Case 2: intro null
				
		//Case 3: disc null
				
		//Case 4: id null
				
		//case 5: name null (invalid)
		
	}

	@Test
	public void testUpdateComputer() {
		//Case 1: All valid inputs
		
		//Case 2: intro null
				
		//Case 3: disc null
				
		//Case 4: id null
				
		//case 5: name null (invalid)
		fail("Not yet implemented");
	}

}
