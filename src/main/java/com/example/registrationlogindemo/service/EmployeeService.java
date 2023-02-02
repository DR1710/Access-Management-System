package com.example.registrationlogindemo.service;

import java.util.List;

import com.example.registrationlogindemo.entity.Employee;

public interface EmployeeService {

	public void deleteById(int id);

	public List<Employee> findAll();

	public Employee findById(int id);

	public void save(Employee employee);

	public List<Employee> searchBy(String firstName, String lastName);

}
