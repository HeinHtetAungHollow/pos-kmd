package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db_config.Db_Config;
import models.Employee;
import repositories.LoginRepo;
import util.mapper.MapToEmployee;

public class LoginServices implements LoginRepo {
	
	private Db_Config db_Config;
	private Employee employee;
	private MapToEmployee mapToEmployee;
	public LoginServices() {
		this.db_Config=new Db_Config();
		this.mapToEmployee=new MapToEmployee();
	}
	@Override
	public Employee login(String username, String password) {
		// TODO Auto-generated method stub
		employee=new Employee();
		try {
			PreparedStatement pst=this.db_Config.getConnection()
					.prepareStatement("SELECT * FROM employee WHERE username='"+username+"'"
							+ "AND password='"+password+"'");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				employee=mapToEmployee.mapEmployee(employee, rs);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return employee;
	}

}
