package com.rksolutions.springbootmongodb.service;

import com.rksolutions.springbootmongodb.dto.EmployeeDto;
import com.rksolutions.springbootmongodb.entity.Employee;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
@Scope("singleton")
public interface EmployeeService
{

    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto);
    public Flux<EmployeeDto> getAllEmployees();
    public Mono<EmployeeDto> getEmployeeById(String employeeId);

    Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto,String employeeId);

    Mono<Void> deleteEmployee(String employeeId);
}
