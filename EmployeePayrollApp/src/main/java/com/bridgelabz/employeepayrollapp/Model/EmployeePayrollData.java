package com.bridgelabz.employeepayrollapp.Model;

import com.bridgelabz.employeepayrollapp.DTO.EmployeePayrollDTO;
import lombok.Data;
/*
Using Lombok insted of getter setter
*/

@Data
public class EmployeePayrollData {

    private int empId;
    private String name;
    private long salary;

    public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        this.empId = empId;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
    }


}
