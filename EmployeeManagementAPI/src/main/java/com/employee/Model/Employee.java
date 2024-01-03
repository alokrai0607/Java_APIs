package com.employee.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer EmpId;

	@NotEmpty(message = "Employee Name is Mandatory")
	private String EmpName;

	@NotEmpty(message = "Employee Department is Manedetory")
	private String EmpDepartment;

	@NotEmpty(message = "Employee Address is Manedetory")
	private String EmpAddress;

	@NotEmpty(message = "Employee Contact is Manedetory")
	@Size(min = 10, max = 10)
	private String EmpCONO;

	public Employee() {
		super();
	}

	public Employee(Integer empId, @NotEmpty(message = "Employee Name is Mandatory") String empName,
			@NotEmpty(message = "Employee Department is Manedetory") String empDepartment,
			@NotEmpty(message = "Employee Address is Manedetory") String empAddress,
			@NotEmpty(message = "Employee Contact is Manedetory") @Size(min = 10, max = 10) String empCONO) {
		super();
		EmpId = empId;
		EmpName = empName;
		EmpDepartment = empDepartment;
		EmpAddress = empAddress;
		EmpCONO = empCONO;
	}

	public Integer getEmpId() {
		return EmpId;
	}

	public void setEmpId(Integer empId) {
		EmpId = empId;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public String getEmpDepartment() {
		return EmpDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		EmpDepartment = empDepartment;
	}

	public String getEmpAddress() {
		return EmpAddress;
	}

	public void setEmpAddress(String empAddress) {
		EmpAddress = empAddress;
	}

	public String getEmpCONO() {
		return EmpCONO;
	}

	public void setEmpCONO(String empCONO) {
		EmpCONO = empCONO;
	}

	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", EmpName=" + EmpName + ", EmpDepartment=" + EmpDepartment
				+ ", EmpAddress=" + EmpAddress + ", EmpCONO=" + EmpCONO + "]";
	}

}
