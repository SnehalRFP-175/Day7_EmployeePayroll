package com.bridgelabz.employeepayrollapp.DTO;


import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@ToString
public class EmployeePayrollDTO {


    @NotEmpty(message = "Employee name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public String name;
    @Min(value=100 , message = "The Salary Should be more than 100")
    public long salary;

    public String gender;

    public LocalDate startDate;

    public String note;

    public String profilePic;

    public List<String> department;

}
