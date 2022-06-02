package com.doubletex.app.api.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeAPI {
    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public Employee get(@PathVariable Long id) {
        return employeeService.get(id);
    }

    @GetMapping()
    public List<Employee> findAll() {
        return employeeService.findAll();
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
    public List<Employee> getAllEmployees(
            @RequestParam(defaultValue = "25") Integer pageSize,
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return employeeService.fetchPaginated(pageSize, pageNumber, sortBy);
    }

}

// api/employee?id=1
// api/employee/1
