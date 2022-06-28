package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import db_config.Db_Config;
import models.Employee;
import repositories.EmployeeRepo;
import util.mapper.MapToEmployee;

public class EmployeeServices implements EmployeeRepo {
	private Db_Config db_Config;
	private MapToEmployee mapToEmployee;

	public EmployeeServices() {
		this.db_Config = new Db_Config();
		this.mapToEmployee = new MapToEmployee();
	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = this.db_Config.getConnection().prepareStatement(
					"INSERT INTO employee (emp_name, emp_phone, emp_email, emp_address, active) VALUES (?, ?, ?, ?, ?)");
			pst.setString(1, employee.getEmp_name());
			pst.setString(2, employee.getEmp_phone());
			pst.setString(3, employee.getEmp_mail());
			pst.setString(4, employee.getEmp_address());
			pst.setBoolean(5, true);
			//pst.setString(6, employee.getRole());

			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
			if (e instanceof SQLIntegrityConstraintViolationException) {
				JOptionPane.showMessageDialog(null, "Already exists");
			}
		}

	}

	@Override
	public void updateEmployee(String id, Employee employee) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = this.db_Config.getConnection().prepareStatement(
					"UPDATE employee SET emp_name=?,emp_phone=?,emp_email=?,emp_address=?,username=?,password=?,role=? WHERE emp_id='"+id+"'");
			pst.setString(1, employee.getEmp_name());
			pst.setString(2, employee.getEmp_phone());
			pst.setString(3, employee.getEmp_mail());
			pst.setString(4, employee.getEmp_address());
			pst.setString(5, employee.getUsername());
			System.out.println(employee.getUsername());
			pst.setString(6, employee.getPassword());
			System.out.println(employee.getPassword());
			pst.setString(7, employee.getRole().toString());
			
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if (e instanceof SQLIntegrityConstraintViolationException) {
				JOptionPane.showMessageDialog(null, "Already exists");
			}
		}

	}

	@Override
	public List<Employee> loadAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employeeList = new ArrayList<>();

		try (Statement st = this.db_Config.getConnection().createStatement()) {
			String query = "SELECT * FROM employee";

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Employee employee = new Employee();
				employeeList.add(mapToEmployee.mapEmployee(employee, rs));
			}
			st.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return employeeList;
	}

	@Override
	public void deleteEmployee(String id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst=this.db_Config.getConnection()
					.prepareStatement("DELETE FROM employee WHERE emp_id='"+id+"'");
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public Employee findEmployeeById(String id) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		try (Statement st = this.db_Config.getConnection().createStatement()) {
			String query = "SELECT * FROM employee WHERE emp_id='" + id + "'";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				employee=this.mapToEmployee.mapEmployee(employee, rs);
			}
			st.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return employee;
	}

}
