package util.mapper;

import java.sql.ResultSet;

import models.Employee;

public class MapToEmployee {
	public Employee mapEmployee(Employee employee,ResultSet rs) {
		try {
            employee.setEmp_id(rs.getInt("emp_id"));
            employee.setEmp_name(rs.getString("emp_name"));
            employee.setEmp_phone(rs.getString("emp_phone"));
            employee.setEmp_mail(rs.getString("emp_email"));
            employee.setEmp_address(rs.getString("emp_address"));
            employee.setUsername(rs.getString("username"));
            employee.setRole(rs.getString("role"));
            employee.setActive(rs.getBoolean("active"));
        } catch (Exception e) {
            e.printStackTrace();
        }
		return employee;
	}
}
