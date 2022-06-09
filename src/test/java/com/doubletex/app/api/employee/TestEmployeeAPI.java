package com.doubletex.app.api.employee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Alexandru Enache
 * @date 09.06.2022
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class TestEmployeeAPI {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeRepository employeeRepository;


    private final Employee employee1 = new Employee(1L, "Tyrion", "Lannister", 60.5);
    private final Employee employee2 = new Employee(2L, "Minato", "Namikaze", 80.5);
    private final Employee employee3 = new Employee(3L, "Severus", "Snape", 40.5);
    private final Employee employee4 = new Employee(4L, "Levi", "Ackerman", 50.0);
    private final Employee employee5 = new Employee(5L, "Wanda", "Maximoff", 90.0);
    private final Employee employee6 = new Employee(6L, "Lara", "Croft", 70.0);

    @Test
    public void employeeFindById_thenReturn200() throws Exception {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee1));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Tyrion"));

    }

    @Test
    public void employeeFindAll_thenReturn200() throws Exception {

        List<Employee> employees = List.of(employee1, employee2, employee3, employee4, employee5, employee6);
        Page<Employee> page = new PageImpl(employees);
        when(employeeRepository.findAll(PageRequest.of(0, 25, Sort.by("id")))).thenReturn(page);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(6)));

    }
}
