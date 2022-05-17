package com.doubletex.app.recap;

import com.doubletex.app.api.employee.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Alexandru Enache
 * @date 17.05.2022
 */

public class StreamRecap {

    static Employee employee1;
    static Employee employee2;
    static Employee employee3;
    static Employee employee4;
    static Employee employee5;
    static List<Employee> employeeList;
    static {
        employee1 = new Employee(1L, "Unu", "Unu", 60.5);
        employee2 = new Employee(2L, "Cineva", "Ceva", 80.5);
        employee3 = new Employee(3L, "Altcineva", "Altceva", 40.5);
        employee4 = new Employee(4L, "NuStiu", "Nume", 50.0);
        employee5 = new Employee(4L, "Inca", "Unu", 50.0);
        employeeList = List.of(employee1, employee2, employee3, employee4, employee5);
    }


    public static void main(String[] args) {
        Employee employeeWithMinSalary = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

//        Employee employeeWithMinSalary = employeeList.stream()
//                .min(Comparator.comparingDouble(Employee::getSalary))
//                .orElseThrow(() -> new RuntimeException("No Employees"));

        System.out.println(employeeWithMinSalary);

        Employee employeeWithMaxSalary = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .skip(employeeList.size() - 1)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

//        Employee employeeWithMaxSalary = employeeList.stream()
//                .max(Comparator.comparingDouble(Employee::getSalary))
//                .orElseThrow(() -> new RuntimeException("No Employees"));

        System.out.println(employeeWithMaxSalary);

        List<String> firstNames = employeeList.stream()
                .map(Employee::getFirstName)
                .collect(Collectors.toList());

        System.out.println(firstNames);

        List<Employee> employeesWithSalaryBiggerThan50 = employeeList.stream()
                .filter(employee -> employee.getSalary() > 50.0)
                .collect(Collectors.toList());

        System.out.println(employeesWithSalaryBiggerThan50);

        long countOfEmployeesWithSalaryBiggerThan50 = employeesWithSalaryBiggerThan50.stream().count();

        System.out.println(countOfEmployeesWithSalaryBiggerThan50);

        List<Double> distinctSalaries = employeeList.stream()
                .map(Employee::getSalary)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(distinctSalaries);
    }

}
