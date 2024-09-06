package com.example.hr.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.hr.entity.Employee;
import com.example.hr.mapper.EmployeeMapper;

public interface Employteerepository extends CrudRepository<Employee, Long> {


	List<Employee> findByName(String name);

	List<Employee> findByEmployeeId(String name);

	@Query(value = "SELECT id , name, salary, 'true' as is_create FROM employees where name"
			+ " like :empName and salary >= :empSalary" , rowMapperClass = EmployeeMapper.class)
	List<Employee> findByNameAndSalary(@Param("empName")String name, @Param("empSalary") Double salary);
	
	
	@Modifying
	@Query(value = "update employees set salary = :salary where id = :id ")
	int updateSalary (Double salary, Long id);
	
	
}
