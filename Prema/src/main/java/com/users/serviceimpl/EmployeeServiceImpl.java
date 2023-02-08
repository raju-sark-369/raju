package com.users.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.users.DBUtil.DBUtil;
import com.users.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	static List<Employee> employeeList= new ArrayList();
	
	Connection connection;
	
	public EmployeeServiceImpl() throws SQLException {
		connection= DBUtil.getConnection();
	}
	
	
	

	@Override
	public List<Employee> getEmployeeData() {
		
		try {
			PreparedStatement stmt= connection.prepareStatement("select * from employee_data");
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				Employee emp=new Employee();
				emp.setEmployee_name(rs.getString(1));
				emp.setMailid(rs.getString(2));
				emp.setNumber(rs.getInt(3));
				emp.setState(rs.getString(4));
				emp.setJob_role(rs.getString(5));
				
				employeeList.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
