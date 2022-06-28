package repositories;

import java.util.List;

import models.Employee;

public interface EmployeeRepo {
	void saveEmployee(Employee employee);
	
	void updateEmployee(String id,Employee employee);
	
	List<Employee> loadAllEmployees();
	
	void deleteEmployee(String id);
	
	Employee findEmployeeById(String id);
}
