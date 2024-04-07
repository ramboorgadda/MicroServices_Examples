package com.eazybites.EmployeeJDBCCrud;

import com.eazybites.EmployeeJDBCCrud.model.Employee;
import com.eazybites.EmployeeJDBCCrud.repository.EmployeeJDBCRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeJdbcCrudApplication implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeJDBCRepository employeeJDBCRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeJdbcCrudApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

       logger.info("Inserting --> {}",employeeJDBCRepository.insert(new Employee(10003,"Rama","Boorgadda","ramboorgadda@gmail.com")));
        //logger.info("Inserting --> {}",employeeJDBCRepository.insert(new Employee(10002,"Rk","Rk1","Rk1@gmail.com")));
       // logger.info("Inserting --> {}",employeeJDBCRepository.insert(new Employee(10003,"Raj","Raj2","Raj1@gmail.com")));

        logger.info("Employee id 10001 -> {}", employeeJDBCRepository.findById(10001));

    }
}
