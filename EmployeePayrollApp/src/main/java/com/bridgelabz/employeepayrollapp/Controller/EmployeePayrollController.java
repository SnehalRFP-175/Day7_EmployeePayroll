package com.bridgelabz.employeepayrollapp.Controller;

import com.bridgelabz.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.DTO.ResponseDTO;
import com.bridgelabz.employeepayrollapp.Model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.Service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/*
* Day 7 UC5 - Retrieve all the Data of Employee Payroll by Department
* */
@RestController
@RequestMapping("/empData")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;
    @GetMapping("/Data")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData()
    {
        List<EmployeePayrollData> employeePayrollDataList = null;
        employeePayrollDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", employeePayrollDataList);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }


    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId)
    {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = employeePayrollService.getEmployeePayrollDataByID(empId);
        ResponseDTO respDTO = new ResponseDTO("Get Call Success", employeePayrollData);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataByDepartment(@PathVariable("department") String department){
        List<EmployeePayrollData> empDataList = null;
        empDataList =employeePayrollService.getEmployeePayrollByDepartment(department);
        ResponseDTO respDTO = new ResponseDTO("Get call success", empDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO)
    {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Data ", employeePayrollData);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }


    @PutMapping(path = "/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
                                                                 @Valid @RequestBody EmployeePayrollDTO empPayrollDTO)
    {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = employeePayrollService.updateEmployeePayrollData(empId,empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee payroll Data for: ", employeePayrollData);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId)
    {
        employeePayrollService.deleteEmployeePayroll(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Employee Data ", empId);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }



}


