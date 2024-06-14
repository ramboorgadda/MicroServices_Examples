package com.RkExample.springboot_jpa_crud_example.controller;

import com.RkExample.springboot_jpa_crud_example.exception.ResourceNotFoundException;
import com.RkExample.springboot_jpa_crud_example.model.Employee;
import com.RkExample.springboot_jpa_crud_example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
@GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException
    {
        Employee employee =  employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Resource is not found for this Id"+employeeId));
        return  ResponseEntity.ok().body(employee);
    }
 @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {

           return ResponseEntity.status(HttpStatus.CREATED).body(employeeRepository.save(employee));
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") long employeeId ,@RequestBody Employee employeeDtls) throws ResourceNotFoundException {
        Employee employee =  employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employeed is not found "+employeeId));
        employee.setFirstName(employeeDtls.getFirstName());
        employee.setLastName(employeeDtls.getLastName());
        employee.setEmail(employeeDtls.getEmail());
        Employee updatedemployee = employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedemployee);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String,Boolean> deleteEmployee(@PathVariable(value = "id") long employeeId) throws ResourceNotFoundException {
      Employee employee =employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("employee does not exists "+employeeId));
       employeeRepository.delete(employee);
       Map<String,Boolean> response = new HashMap<>();
       response.put("DELETED",Boolean.TRUE);
       return response;
   }
}
