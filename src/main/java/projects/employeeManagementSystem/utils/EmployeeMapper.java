package projects.employeeManagementSystem.utils;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import projects.employeeManagementSystem.dto.EmployeeDto;
import projects.employeeManagementSystem.entity.Employee;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {
	@Mappings({ @Mapping(source = "id", target = "id"), @Mapping(source = "name", target = "name"),
			@Mapping(source = "address.addrLine1", target = "address.addrLine1"),
			@Mapping(source = "address.addrLine2", target = "address.addrLine2"),
			@Mapping(source = "address.city", target = "address.city"),
			@Mapping(source = "address.state", target = "address.state"),
			@Mapping(source = "address.country", target = "address.country"),
			@Mapping(source = "address.pincode", target = "address.pincode"),
			@Mapping(source = "phoneNumber", target = "phoneNumber"), 
			@Mapping(source = "email", target = "email") })
	EmployeeDto entityToDto(Employee employee);

	@InheritInverseConfiguration(name = "entityToDto")
	Employee dtoToEntity(EmployeeDto employeeDto);
}
