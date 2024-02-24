package com.project.employee.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.employee.exception.ResourceNotFoundException;
import com.project.employee.model.Employee;
import com.project.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public ResponseEntity<Employee> getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id: " + id));
		return ResponseEntity.ok(employee);
	}
	
	public ResponseEntity<Employee> updateEmployeeById(Long id, Employee employee) {
		Employee employeeToUpdate = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id: " + id));
		
		employeeToUpdate.setFirstName(employee.getFirstName());
		employeeToUpdate.setLastName(employee.getLastName());
		employeeToUpdate.setEmailId(employee.getEmailId());
		
		Employee updatedEmployee = employeeRepository.save(employeeToUpdate);
		
		return ResponseEntity.ok(updatedEmployee);
	}
	
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id: " + id));
		employeeRepository.delete(employee);
		Map<String, Boolean> messageAfterDelete = new HashMap<>();
		messageAfterDelete.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(messageAfterDelete);
	}
}
