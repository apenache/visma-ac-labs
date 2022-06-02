package com.doubletex.app.api.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e from Employee e where lower(concat(e.firstName, ' ', e.lastName)) LIKE %?1%")
    Page<Employee> findEmployeesByNameLike(String name, Pageable pageable);

}
