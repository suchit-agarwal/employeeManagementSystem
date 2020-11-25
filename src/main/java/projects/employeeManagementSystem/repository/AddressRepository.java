package projects.employeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projects.employeeManagementSystem.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
