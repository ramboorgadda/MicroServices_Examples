package com.rksolutions.springbootmongodb.controller;

import com.rksolutions.springbootmongodb.dto.EmployeeDto;
import com.rksolutions.springbootmongodb.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
@Configuration
@ComponentScan("com.rksolutions.springbootmongodb")
public class EmployeeController {

    private EmployeeService employeeService;


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){

        return employeeService.saveEmployee(employeeDto).onErrorReturn(employeeDto);
    }
@GetMapping("{id}")
    public Mono<EmployeeDto> findEmployeeById(@PathVariable("id") String employeeId){

        return employeeService.getEmployeeById(employeeId);
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<EmployeeDto> updateEmployee(@PathVariable("id") String employeeId, @RequestBody EmployeeDto employeeDto){

        return employeeService.updateEmployee(employeeDto,employeeId);
    }
}
