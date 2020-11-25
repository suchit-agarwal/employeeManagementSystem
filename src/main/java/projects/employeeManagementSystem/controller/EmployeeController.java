package projects.employeeManagementSystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projects.employeeManagementSystem.dto.EmployeeDto;
import projects.employeeManagementSystem.service.EmployeeService;
import projects.employeeManagementSystem.utils.CustomException;

@RestController
@RequestMapping(value = "/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(value = "id") Integer empId)
			throws CustomException {
		try {
			EmployeeDto employee = employeeService.findEmpById(empId);
			if (Objects.isNull(employee))
				return ResponseEntity.noContent().build();
			return ResponseEntity.ok(employee);
		} catch (CustomException e) {
			if (e.getHttpStatus() == HttpStatus.NO_CONTENT)
				return ResponseEntity.noContent().build();
			throw e;
		}
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<EmployeeDto> findAll() throws Exception {
		List<EmployeeDto> list = new ArrayList<>();
		try {
			list = employeeService.findAllEmployees();
			return list;
		} catch (CustomException e) {
			if (e.getHttpStatus() == HttpStatus.NO_CONTENT)
				return list;
			throw e;
		}
	}

	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) throws Exception {
		return ResponseEntity.ok(employeeService.addEmployee(employeeDto));
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEmployeeById(@PathVariable(value = "id") Integer empId) throws Exception {
		try {
			employeeService.deleteEmpById(empId);
			return ResponseEntity.ok("Employee " + empId + " deleted successfully");
		} catch (CustomException e) {
			if (e.getHttpStatus() == HttpStatus.NO_CONTENT)
				return ResponseEntity.ok("Employee " + empId + " does not exist");
			throw e;
		}
	}
}
