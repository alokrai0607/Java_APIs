package com.employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Model.Employee;
import com.employee.Service.EmployeeService;


@RestController
public class EmpController {

	@Autowired
	private EmployeeService empService;

	@PostMapping("/savemployee")
	public ResponseEntity<?> postEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(empService.postEmp(employee), HttpStatus.CREATED);

	}
	
	@GetMapping("/employee")
	public ResponseEntity<?> getAllEmployee(){
		return new ResponseEntity<>(empService.getAllEmployee(),HttpStatus.OK);
	}
	
	@GetMapping("/employee/{EmpId}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Integer EmpId){
		return new ResponseEntity<>(empService.getEmployeeById(EmpId),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteemployee/{EmpId}")
	public ResponseEntity<?> deleteEmpById(@PathVariable Integer EmpId){
		return new ResponseEntity<>(empService.DeleteEmployeeById(EmpId),HttpStatus.OK);
	}
	
	@PutMapping("/updatemployee/{EmpId}")
	public ResponseEntity<?> updateEmployeeDetail(@PathVariable Integer EmpId , @RequestBody Employee employee){
		Employee exEmp = empService.getEmployeeById(EmpId);
		
		if(exEmp == null) {
			return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
		}
		exEmp.setEmpName(exEmp.getEmpName());
		exEmp.setEmpDepartment(exEmp.getEmpDepartment());
		exEmp.setEmpAddress(exEmp.getEmpAddress());
		exEmp.setEmpCONO(exEmp.getEmpCONO());
		
		Employee emp = empService.postEmp(exEmp);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	

}
