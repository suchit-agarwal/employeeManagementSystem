package projects.employeeManagementSystem.service;

import java.util.List;

import projects.employeeManagementSystem.dto.EmployeeDto;
import projects.employeeManagementSystem.utils.CustomException;

public interface EmployeeService {
	public EmployeeDto findEmpById(Integer empId) throws CustomException;

	public List<EmployeeDto> findAllEmployees() throws CustomException;

	public EmployeeDto addEmployee(EmployeeDto employeeDto) throws Exception;

	public void deleteEmpById(Integer empId) throws CustomException;
}
