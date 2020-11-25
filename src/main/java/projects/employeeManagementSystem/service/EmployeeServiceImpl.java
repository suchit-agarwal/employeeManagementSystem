package projects.employeeManagementSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import projects.employeeManagementSystem.dto.EmployeeDto;
import projects.employeeManagementSystem.entity.Employee;
import projects.employeeManagementSystem.repository.EmployeeRepository;
import projects.employeeManagementSystem.utils.CustomException;
import projects.employeeManagementSystem.utils.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public EmployeeDto findEmpById(Integer empId) throws CustomException {
		if (Objects.isNull(empId))
			throw new IllegalArgumentException("Employee ID passed is null");
		Employee employee = employeeRepository.findById(empId).orElse(null);
		if (Objects.isNull(employee)) {
			throw new CustomException(HttpStatus.NO_CONTENT, "Employee doesn't exist");
		}
		return employeeMapper.entityToDto(employee);
	}

	@Override
	public List<EmployeeDto> findAllEmployees() throws CustomException {
		List<EmployeeDto> empList = new ArrayList<>();
		List<Employee> list = employeeRepository.findAll();
		if (CollectionUtils.isEmpty(list))
			throw new CustomException(HttpStatus.NO_CONTENT, "No data present");
		empList = list.stream().map(emp -> employeeMapper.entityToDto(emp)).collect(Collectors.toList());
		return empList;
	}

	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) throws Exception {
		if (Objects.isNull(employeeDto))
			throw new IllegalArgumentException("No Data passed");
		Employee entity = employeeRepository.save(employeeMapper.dtoToEntity(employeeDto));
		return employeeMapper.entityToDto(entity);
	}

	@Override
	public void deleteEmpById(Integer empId) throws CustomException {
		if (Objects.isNull(empId))
			throw new IllegalArgumentException("Employee ID passed is null");
		Employee emp = employeeRepository.findById(empId).orElse(null);
		if(Objects.isNull(emp))
			throw new CustomException(HttpStatus.NO_CONTENT, "Employee doesn't exist");
		employeeRepository.deleteById(empId);
	}

}
