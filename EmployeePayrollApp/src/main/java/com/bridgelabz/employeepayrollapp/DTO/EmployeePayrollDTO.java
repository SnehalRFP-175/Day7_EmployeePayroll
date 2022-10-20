package com.bridgelabz.employeepayrollapp.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@ToString
public class EmployeePayrollDTO {


    @NotEmpty(message = "Employee name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public String name;

    @NotEmpty(message = "Gender cannot be Null")
    @Pattern(regexp = "Male|Female", message = "Gender needs to be Male or Female")
    public String gender;

    @Min(value=500 , message = "The Salary Should be more than 100")
    public long salary;


    // @JsonFormat(pattern= "dd/MMM/yyyy")
    @NotNull(message = "Start Date cannot be empty")
    @PastOrPresent(message = "Start Date Should Be Past or Present")
    public LocalDate startDate;

    @NotBlank(message = "Note cannot be Blank")
    public String note;

    @NotBlank(message = "Note cannot be Blank")
    public String profilePic;

    @NotEmpty(message = "Department Cannot be Null")
    public List<String> department;

}
