package com.doubletex.app.api.employee;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id = 0L;
    @NotNull
    @NotEmpty
    private String firstName = "";
    @NotNull
    @NotEmpty
    private String lastName = "";
    @PositiveOrZero
    private double salary = 0;
}
