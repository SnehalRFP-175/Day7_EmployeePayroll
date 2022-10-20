package com.bridgelabz.employeepayrollapp.Service;

import com.bridgelabz.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.Exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.Model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.Repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{

    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    @Autowired
    EmployeePayrollRepository employeePayrollRepository;


    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }


    /*
    * EmployeePayrollService throws EmployeePayrollException and Intercepted by EmployeePayrollExceptionHandler
    * */
    @Override
    public EmployeePayrollData getEmployeePayrollDataByID(int empId) {

        return employeePayrollRepository.findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee Not Present......!"));    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(employeePayrollDTO);
        return employeePayrollRepository.save(employeePayrollData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataByID(empId);
        employeePayrollData.updateEmployeeData(employeePayrollDTO);
        return employeePayrollRepository.save(employeePayrollData);
    }


    @Override
    public void deleteEmployeePayroll(int empId) {
        EmployeePayrollData empData = this.getEmployeePayrollDataByID(empId);
        employeePayrollRepository.delete(empData);
    }
}
