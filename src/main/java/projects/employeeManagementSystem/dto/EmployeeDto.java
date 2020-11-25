package projects.employeeManagementSystem.dto;

import java.io.Serializable;

import lombok.Data;
import projects.employeeManagementSystem.entity.Address;

@Data
public class EmployeeDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Address address;
	private Long phoneNumber;
	private String email;
}
