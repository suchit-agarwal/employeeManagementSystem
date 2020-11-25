package projects.employeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projects.employeeManagementSystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
