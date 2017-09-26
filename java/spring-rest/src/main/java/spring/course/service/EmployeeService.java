package spring.course.service;


import java.util.List;

import spring.course.model.Employee;


public interface EmployeeService {
	
	Employee findById(Long id);

	Employee findByFirstName(String name);

	void saveEmployee(Employee student);

	void updateEmployee(Employee student);

	void deleteEmployeeById(Long id);

	void deleteAllEmployees();

	List<Employee> findAllEmployees();

	boolean isEmployeeExist(Employee student);
}