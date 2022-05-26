package com.doubletex.app.api.employee;

import lombok.RequiredArgsConstructor;
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
    public Optional<Employee> get(@PathVariable Long id) {
        return employeeService.get(id);
    }

    @PostMapping("")
    public Employee post(@Valid @RequestBody Employee employee) {
        return employeeService.post(employee);
    }

    @PutMapping("/{id}/raiseSalary")
    public Employee raiseSalary(@PathVariable Long id, @RequestParam Double newSalary) {
        return employeeService.raiseSalary(id, newSalary);
    }

    @GetMapping
    public List<Employee> getAllEmployees(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "25") Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy
    ) {
        return employeeService.getAllEmployees(pageNumber, pageSize, sortBy);
    }
}

// api/employee?id=1
// api/employee/1
