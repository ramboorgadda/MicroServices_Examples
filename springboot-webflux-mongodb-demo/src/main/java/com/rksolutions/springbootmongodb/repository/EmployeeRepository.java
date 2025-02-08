package com.rksolutions.springbootmongodb.repository;

import com.rksolutions.springbootmongodb.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee,String> {
}
