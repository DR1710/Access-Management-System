package com.example.registrationlogindemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.registrationlogindemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findAllByOrderByLastNameAsc();

	public List<Employee> findByFirstNameContainsAndLastNameContainsAllIgnoreCase(String firstName, String lastName);

}
