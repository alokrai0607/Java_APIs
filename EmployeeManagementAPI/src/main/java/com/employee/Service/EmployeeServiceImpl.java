package com.employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.Model.Employee;
import com.employee.Repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public Employee postEmp(Employee employee) {
		Employee a = empRepo.save(employee);
		return a;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> emp = empRepo.findAll();
		return emp;
	}

	@Override
	public Employee getEmployeeById(Integer EmpId) {
		return empRepo.findById(EmpId).orElse(null);
	}

	@Override
	public Employee UpdateEmployeeById(Integer EmpId, Employee employee) {
		if (empRepo.existsById(EmpId)) {
			Employee existingEmployee = empRepo.findById(EmpId).orElse(null);
			if (existingEmployee != null) {
				existingEmployee.setEmpName(employee.getEmpName());
				existingEmployee.setEmpDepartment(employee.getEmpDepartment());
				existingEmployee.setEmpAddress(employee.getEmpAddress());
				existingEmployee.setEmpCONO(employee.getEmpCONO());
				empRepo.save(existingEmployee);
				return existingEmployee;
			}
		}
		return null; 
	}

	@Override
	public boolean DeleteEmployeeById(Integer EmpId) {
		Optional<Employee> empfind = empRepo.findById(EmpId);
		if (empfind.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

}
