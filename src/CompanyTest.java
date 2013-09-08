/* Kevin Rossoll
 * kwr17
 * EECS 293
 * PA1
 * Sept. 6, 2012
 */

import java.util.*;

import junit.framework.Assert;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CompanyTest {

	Company c = new Company();
	String emp1 = "Mike";
	String emp2 = "Susan";
	String emp3 = "Clyde";
	String emp4 = "Louis";
	String man1 = "Tom";
	String man2 = "Barbara";
	
	

	
	@Before
	public void setUp() throws Exception {

		//adds all employees to the company, with Barbara as the CEO
		c.add(man2, null);
		c.add(man1, man2);
		c.add(emp1, man1);
		c.add(emp2, man2);
		c.add(emp3, man2);
		c.add(emp4, man1);
		
		c.delete(emp4);
	}

	@Test
	public void testMangerOf() {
		//creates a temporary String to represent a manager in the company
		String tempMan = c.managerOf(emp1);
		
		Assert.assertEquals(man1, tempMan);
	}
	
	@Test
	public void testManagerSet() {
		//creates an array from the set of managers in the company
		Object[] tempArray = c.managerSet().toArray();
		//creates a String to represent the first manager in the array of managers
		String tempString = tempArray[0].toString();
	
		
		Assert.assertEquals(man1, tempString);
	}
	
	@Test
	public void testDepartmentOf() {
		
		//creates a new company, b with Barbara as the top manager
		Company b = c.departmentOf(man2);
		//creates a List<String> of the managers in b
		List<String> tempList = b.managersByDepartmentSize();
		//creates an array from the list of managers
		Object[] tempArray = tempList.toArray();
		//creates a String to represent the first manager in the array
		String tempMan = tempArray[0].toString();

		Assert.assertEquals(man2, tempMan);
		
		
	}
	
	@Test
	public void testManagerByDepartmentSize() {
		
		//creates a List<String> of the managers in c
		List<String> tempList = c.managersByDepartmentSize();
		//creates an array from the list of managers
		Object[] tempArray = tempList.toArray();
		//creates a String to represent the first manager in the array
		String tempMan = tempArray[0].toString();
		
		Assert.assertEquals(man1, tempMan);
	}
}
