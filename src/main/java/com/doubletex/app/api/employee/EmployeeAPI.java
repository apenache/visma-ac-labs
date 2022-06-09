package com.doubletex.app.api.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeAPI {
    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public Employee get(@PathVariable Long id) {
        return employeeService.get(id);
    }

    @PostMapping("")
    public Employee post(@Valid @RequestBody Employee employee) {
        return employeeService.post(employee);
    }

    @PutMapping("")
    public Employee put(@Valid @RequestBody Employee employee) {
        return employeeService.put(employee);
    }

    @PutMapping("/{id}/raiseSalary")
    public Employee raiseSalary(@PathVariable Long id, @RequestParam Double newSalary) {
        return employeeService.raiseSalary(id, newSalary);
    }

    @GetMapping("")
    public Page<Employee> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "25") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return employeeService.fetchPaginated(pageNumber, pageSize, sortBy);
    }

    @GetMapping("/search")
    public Page<Employee> search(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "25") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "") String name
    ) {
        if(name.isEmpty())
            return employeeService.fetchPaginated(pageNumber, pageSize, sortBy);
        return employeeService.search(pageNumber, pageSize, sortBy, name);
    }

}

// api/employee?id=1
// api/employee/1
