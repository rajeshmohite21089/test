package net.guides.springboot2.springboot2jpacrudexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.model.User;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	@Query("SELECT u from Employee u where u.firstName LIKE :firstName")
	public List<Employee> getEmployeeByFirstName(@Param("firstName") String firstName);
}
