package com.ERP.models.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name="employees")
@Table(name="employees")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Employee implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String office;
    private String department;
    private LocalDate admission_date;
    private BigDecimal salary;

}
