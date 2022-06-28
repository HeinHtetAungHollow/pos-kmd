package repositories;

import models.Employee;

public interface LoginRepo {
	Employee login(String username,String password);
}
