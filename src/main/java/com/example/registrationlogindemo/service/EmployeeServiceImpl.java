package com.example.registrationlogindemo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registrationlogindemo.entity.Employee;
import com.example.registrationlogindemo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);

	public EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		logger.debug("Deleting employee id " + id);
		employeeRepository.deleteById(id);

	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		
		logger.debug("finding employee by its id "+id);

		Optional<Employee> result = employeeRepository.findById(id);

		if (!result.isPresent()) {
			logger.debug("Could not find employee id " + id);
			throw new RuntimeException("Did not find employee " + id);
		}
		return result.get();

	}

	@Override
	@Transactional
	public void save(Employee employee) {
		
		if(employee == null || employee.getId() == 0) {
			throw new RuntimeException("empty data passed");
		}
		
		employeeRepository.save(employee);

		logger.debug("save complete for employee " + employee);

	}

	@Override
	@Transactional
	public List<Employee> searchBy(String firstName, String lastName) {

		return employeeRepository.findByFirstNameContainsAndLastNameContainsAllIgnoreCase(firstName, lastName);
	}

}
