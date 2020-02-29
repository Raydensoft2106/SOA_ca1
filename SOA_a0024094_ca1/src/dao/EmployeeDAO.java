package dao;

import java.util.List;

import model.Employee;

public interface EmployeeDAO {
	public int save(Employee employee);
	
	public int update(Employee employee);
	
	public Employee get(Integer ID);
	
	public int delete(Integer ID);
	
	public List<Employee> list();

}
