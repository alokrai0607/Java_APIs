package com.employee.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer EmpId;

	private String EmpName;

	private String EmpDepartment;

	private String EmpAddress;

	private String EmpCONO;

	public Employee() {
		super();
	}

	public Employee(Integer empId, String empName, String empDepartment, String empAddress, String empCONO) {
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
