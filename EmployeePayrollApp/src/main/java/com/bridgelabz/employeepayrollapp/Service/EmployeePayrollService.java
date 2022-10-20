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
        return employeePayrollList;
    }


    /*
    * EmployeePayrollService throws EmployeePayrollException and Intercepted by EmployeePayrollExceptionHandler
    * */
    @Override
    public EmployeePayrollData getEmployeePayrollDataByID(int empId) {

        return employeePayrollList.stream().filter(employeePayrollData -> employeePayrollData.getEmpId() == empId).
                findFirst().orElseThrow(() -> new EmployeePayrollException("Employee Not Found...!"));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(employeePayrollList.size()+1,employeePayrollDTO);
        employeePayrollList.add(employeePayrollData);
        return employeePayrollRepository.save(employeePayrollData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataByID(empId);
        employeePayrollData.setName(employeePayrollDTO.name);
        employeePayrollData.setGender(employeePayrollDTO.gender);
        employeePayrollData.setSalary(employeePayrollDTO.salary);
        employeePayrollData.setStartDate(employeePayrollDTO.startDate);
        employeePayrollData.setNote(employeePayrollDTO.note);
        employeePayrollData.setProfilePic(employeePayrollDTO.profilePic);
        employeePayrollData.setDepartment(employeePayrollDTO.department);
        employeePayrollList.set(empId-1,employeePayrollData);
        return employeePayrollData;
    }


    @Override
    public void deleteEmployeePayroll(int empId) {
        employeePayrollList.remove(empId-1);
    }
}
