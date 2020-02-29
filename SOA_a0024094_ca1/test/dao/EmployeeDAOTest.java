package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import model.Employee;

class EmployeeDAOTest {
	private DriverManagerDataSource dataSource;
	private EmployeeDAO dao;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	
	@BeforeEach
	void setupBeforeEachh() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3307/employee");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		
		dao = new EmployeeDAOImpl(dataSource);
	}
	
	@Test
	void testSave() {
		Employee employee = new Employee(125, "Mike Doe", 35, date);
		int result = dao.save(employee);
		
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Employee employee = new Employee(125, "Mike James Doe", 34, date);
		int result = dao.update(employee);
		
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 124;
		Employee e = dao.get(id);
		if(e != null) {
			System.out.println(e);
		}
		
		assertNotNull(e);
	}

	@Test
	void testDelete() {
		Integer id = 125;
		
		int result = dao.delete(id);
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Employee> listEmployees = dao.list();
		
		for(Employee eEmployee : listEmployees) {
			System.out.println(eEmployee);
		}
		
		assertTrue(listEmployees.isEmpty());
	}

}
