package com.deo.thymeleafdbdemo.dao;




import com.deo.thymeleafdbdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //thats all ...no need to write any code!!!
}