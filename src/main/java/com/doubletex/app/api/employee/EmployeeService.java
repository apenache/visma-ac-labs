package com.doubletex.app.api.employee;

import com.doubletex.app.exceptions.DoubletexBadRequest;
import com.doubletex.app.exceptions.DoubletexNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee get(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new DoubletexNotFound(Employee.class, id));
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee post(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee put(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee raiseSalary(Long id, Double newSalary) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new DoubletexNotFound(Employee.class, id));
        validateSalaryRaise(employee, newSalary);
        DoubletexBadRequest.current().throwIfNecessary();
        employee.setSalary(newSalary);
        return employeeRepository.save(employee);
    }

    private void validateEmployee(Employee employee) {
        DoubletexBadRequest doubletexBadRequest = DoubletexBadRequest.current();
        if (employee.getFirstName().isEmpty())
            doubletexBadRequest.addValidation("firstName", "Should not be empty");
        if (employee.getLastName().isEmpty())
            doubletexBadRequest.addValidation("firstName", "Should not be empty");
    }

    public void validateSalaryRaise(Employee employee, Double newSalary) {
        DoubletexBadRequest doubletexBadRequest = DoubletexBadRequest.current();
        if(employee.getSalary() > newSalary) {
            doubletexBadRequest.addValidation("salary", "Should be a raise");
        }
    }

    public List<Employee> fetchPaginated(
            Integer pageSize,
            Integer pageNumber,
            String sortBy
    ) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return employeeRepository.findAll(pageable).getContent();
    }
}
