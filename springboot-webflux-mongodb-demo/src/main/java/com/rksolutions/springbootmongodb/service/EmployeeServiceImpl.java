package com.rksolutions.springbootmongodb.service;

import com.rksolutions.springbootmongodb.dto.EmployeeDto;
import com.rksolutions.springbootmongodb.entity.Employee;
import com.rksolutions.springbootmongodb.mapper.EmployeeMapper;
import com.rksolutions.springbootmongodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class EmployeeServiceImpl implements EmployeeService {
  @Autowired
  EmployeeRepository employeeRepository;
    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
         Mono<Employee> savedEmployee = employeeRepository.save(employee);
        return savedEmployee.map(EmployeeMapper::mapToEmployeeDto);
    }

    @Override
    public Flux<EmployeeDto> getAllEmployees() {
         Flux<Employee> employeeFlux       = employeeRepository.findAll();
        return employeeFlux.map(EmployeeMapper::mapToEmployeeDto);
    }

    @Override
    public Mono<EmployeeDto> getEmployeeById(String employeeId) {
        Mono<Employee> employeeMono= employeeRepository.findById(employeeId);

        return employeeMono.map(EmployeeMapper::mapToEmployeeDto);
    }

    @Override
    public Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String employeeId) {
            Mono<Employee> employeeMono = employeeRepository.findById(employeeId);
        return employeeMono.flatMap((existingEmployee) ->{
            existingEmployee.setEmail(employeeDto.getEmail());
            existingEmployee.setFirstName(employeeDto.getFirstName());
            existingEmployee.setLastName(employeeDto.getLastName());
            return employeeRepository.save(existingEmployee);
        } ).map((EmployeeMapper::mapToEmployeeDto));
    }

    @Override
    public Mono<Void> deleteEmployee(String employeeId) {
        return employeeRepository.deleteById(employeeId);
    }
}
