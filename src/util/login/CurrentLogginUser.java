package util.login;

import models.Employee;

public class CurrentLogginUser {
	private static Employee employee;
	
	private CurrentLogginUser() {
		
	}

	public static Employee getCurrentUser() {
		return employee;
	}

	public static void setCurrentUser(Employee employee) {
		CurrentLogginUser.employee = employee;
	}
	
	
}
