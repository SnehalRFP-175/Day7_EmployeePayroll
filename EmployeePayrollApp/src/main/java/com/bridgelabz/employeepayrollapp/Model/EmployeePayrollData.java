package com.bridgelabz.employeepayrollapp.Model;


import com.bridgelabz.employeepayrollapp.DTO.EmployeePayrollDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;
/*
Using Lombok insted of getter setter
*/

@Data
@NoArgsConstructor
@Entity
@Table(name = "employee_payroll")
public class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empId")
    private int empId;
    @Column(name = "name")
    private String name;
    private String gender;
    private long salary;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    @ElementCollection
    @CollectionTable(name = "employee_department",joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> department;

    public EmployeePayrollData( EmployeePayrollDTO employeePayrollDTO) {
        this.updateEmployeeData(employeePayrollDTO);
    }
    public void updateEmployeeData(EmployeePayrollDTO employeePayrollDTO) {
        this.empId = empId;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.startDate = employeePayrollDTO.startDate;
        this.note = employeePayrollDTO.note;
        this.profilePic = employeePayrollDTO.profilePic;
        this.department = employeePayrollDTO.department;

    }
}
