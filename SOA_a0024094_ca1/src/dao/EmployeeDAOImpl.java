package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	
	public EmployeeDAOImpl(DriverManagerDataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int save(Employee e) {
		String sql = "INSERT INTO details (ID, NAME, AGE, TIMESTAMP) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, e.getID(), e.getNAME(), e.getAGE(), dateFormat.format(date));
	}

	@Override
	public int update(Employee e) {
		String sql = "UPDATE details SET NAME=?, AGE=?, TIMESTAMP=? WHERE ID=?";
		return jdbcTemplate.update(sql, e.getNAME(), e.getAGE(), dateFormat.format(date), e.getID());
		
	}

	@Override
	public Employee get(Integer ID) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM DETAILS WHERE ID="+ID;
		
		ResultSetExtractor<Employee> extractor = new ResultSetExtractor<Employee>() {
			
			@Override
			public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name = rs.getString("NAME");
					Integer age = rs.getInt("AGE");
					Date timestamp = rs.getDate("TIMESTAMP");
					
					return new Employee(ID, name, age, timestamp);
				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer ID) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM DETAILS WHERE ID="+ID;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Employee> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM DETAILS";
		
		RowMapper<Employee> rowMapper = new RowMapper<Employee>() {
			
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Integer id = rs.getInt("ID");
				String name = rs.getString("NAME");
				Integer age = rs.getInt("AGE");
				Date timestamp = rs.getDate("TIMESTAMP");
				
				return new Employee(id, name, age, timestamp);
			}
			
		};
		
		return jdbcTemplate.query(sql, rowMapper);
	}

}
