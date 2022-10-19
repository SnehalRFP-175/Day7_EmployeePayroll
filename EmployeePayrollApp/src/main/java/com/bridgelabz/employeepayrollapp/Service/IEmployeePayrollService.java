package com.bridgelabz.employeepayrollapp.Service;


import com.bridgelabz.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.Model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService  {
   List<EmployeePayrollData> getEmployeePayrollData();

   EmployeePayrollData getEmployeePayrollDataByID(int empId);

   EmployeePayrollData createEmployeePayrollData (EmployeePayrollDTO employeePayrollDTO);

   EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO);

   void deleteEmployeePayroll(int empId);
}
