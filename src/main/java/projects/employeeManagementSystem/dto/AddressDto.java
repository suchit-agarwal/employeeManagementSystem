package projects.employeeManagementSystem.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AddressDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String addrLine1;
	private String addrLine2;
	private String city;
	private String state;
	private String country;
	private String pincode;
}
