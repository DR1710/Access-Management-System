package com.example.registrationlogindemo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.registrationlogindemo.entity.Employee;
import com.example.registrationlogindemo.repository.EmployeeRepository;
import com.example.registrationlogindemo.service.EmployeeService;

@SpringBootTest
class EmployeeTest {

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@BeforeEach
	void setUp() throws Exception {

		Optional<Employee> employee = Optional.of(new Employee(1, "sunil", "patra", "test@test.com"));
		Mockito.when(employeeRepository.findById(1)).thenReturn(employee);
		
		Optional<Employee> employee2 = Optional.of(new Employee(2, "test2", "test2", "test@test2.com"));
		Mockito.when(employeeRepository.findById(2)).thenReturn(employee2);

	}

	@Test
	public void testEmployeeEmailExist() {
		
		String email = "test@test.com";
		Employee emp = employeeService.findById(1);
		System.out.println("emp..."+emp);
		assertEquals(email, emp.getEmail());
		
	}
	
	@Test
	public void testEmployeeEmailExist2() {
		
		String email = "test2@test.com";
		Employee emp = employeeService.findById(2);
		System.out.println("emp2..."+emp);
		assertEquals(email, emp.getEmail());
	}
	
	
	

}
