package com.employee.Service;

import java.util.List;

import com.employee.Model.Employee;

public interface EmployeeService {

	Employee postEmp(Employee employee);

	List<Employee> getAllEmployee();

	Employee getEmployeeById(Integer EmpId);

	Employee UpdateEmployeeById(Integer EmpId, Employee employee);

	boolean DeleteEmployeeById(Integer EmpId);

}
