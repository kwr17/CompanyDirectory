/* Kevin Rossoll
 * kwr17
 * EECS 293
 * PA1
 * Sept. 6, 2012
 */

import java.util.*;
public class Company {

	private Map<String, String> manager;
	
	/**
	 * This is a constructor that creates an empty company
	 */
	public Company()
	{
		manager = new HashMap<String, String>();
	}
	
	/**
	 * This method adds an employee to the company and indicates his or her manager
	 * @param employee This is the employee to be added to the company.
	 * @param manager1 This is the manager of the newly added employee.
	 */
	void add (String employee, String manager1)
	{
		manager.put(employee, manager1);
	}
	
	/**
	 * This method deletes an employee from the company. If the employee
	 * doesn't exist, then a NullPointerException will be thrown.
	 * @param employeeThis is the employee to be removed from the company
	 */
	void delete (String employee)
	{
		if (manager.containsKey(employee))
		{
			manager.remove(employee);
		}
		else
		{
			throw new NullPointerException();
		}
	}
	
	/**
	 * This method provides the manager of the given employee.
	 * @param employee This is the employee for whom the name of his or her manager is desired.
	 * @return This method returns the name of the manager of the subordinate employee.
	 */
	String managerOf (String employee)
	{
		
		return manager.get(employee);
		
	}
	
	/**
	 * This method provides a set containing all of the managers, without repeats.
	 * @return This method returns a set of all the managers.
	 */
	Set<String> managerSet()
	{
		Collection<String> m = manager.values();
		Object[] empSet = m.toArray();
		Set<String> manSet = null;
		
		//find the manager for each employee in the empSet
		for (int i = 0; empSet.length > i; i++)
		{
			String temp = empSet[i].toString();
			
			//add manager to the manSet if he or she is not already in the set
			if (manSet.contains(temp) != true)
				{
				manSet.add(temp);
				}
			else
			{	
				//do nothing: manager is not added if he or she is already contained in the set
			}
		}
		return null;
		
	}
	
	/**
	 * This method creates a new Company with the specified manager and subordinates
	 * @param manager1 This is the manager who will be at the head of the created Company
	 * @return This method returns a Company.
	 */
	Company departmentOf (String manager1)
	{
		Company newComp = new Company();
		Collection<String> values = manager.values();
		Object[] mans = values.toArray();
		String[] emps = null;
		
		
		for (int i = 0; mans.length > i; i++)
		{
			if (mans[i] == manager1)
			{
				String temp = emps[i];
				newComp.manager.put(manager1, temp);
			}
		}
		
		
		return newComp;
		
	}
	
	/**
	 * This method creates a list of all the managers and puts them in order by the size of their departments.
	 * @return This returns a list of the managers in order of the number of their subordinates.
	 */
	List<String> managersByDepartmentSize()
	{
		//creates a collection from the manager names and turn it into an array
		Collection<String> m = manager.values();
		Object[] names = m.toArray();
		TreeMap<String, Integer> newMap = null;
		
		//finds the manager for each employee in the empSet
		for (int i = 0; m.size() > i; i++)
		{
			String temp = names[i].toString();
			
			//adds manager to the manSet if he or she is not already in the set
			if (newMap.containsValue(temp) != true)
				{
				newMap.put(temp, 1);
				}
			else
			{
				//determines how many subordinates a manager had before this employee
				int subordinates = newMap.get(temp);
				//adds one employee to this manager's total
				subordinates += 1;
				//remove the manager from the map so he or she can be replaced with he appropriate number of subordinates
				newMap.remove(temp);
				//reinstate the manager with the correct number of subordinates
				newMap.put(temp, subordinates);
			}
		}
		
		//creates an empty list for the managers to be added into
		List<String> manList = null;
		
		//creates a collection of all the keys in the map of managers
		Collection<String> manColl= newMap.keySet();
		
		//creates an array of strings from the list of all managers
		Object[] manArray = manColl.toArray();
		
		//transfers the names of the managers from the manArray to the manList so they can be return as a List<String>
		for (int i = 0; newMap.size() > i; i++)
		{
			String tempName = manArray[i].toString();
			manList.add(tempName);
		}
		
		
		return manList;
		
	}
}
