package com.RkExample.springboot_jpa_crud_example.repository;

import com.RkExample.springboot_jpa_crud_example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
