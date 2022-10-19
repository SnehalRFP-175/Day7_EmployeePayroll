package com.bridgelabz.employeepayrollapp.Model;

import com.bridgelabz.employeepayrollapp.DTO.EmployeePayrollDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
/*
Using Lombok insted of getter setter
*/

@Data
public class EmployeePayrollData {

    private int empId;
    private String name;
    private long salary;

    private String gender;

    private LocalDate startDate;

    private String note;

    private String profilePic;

    private List<String> department;

    public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
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
