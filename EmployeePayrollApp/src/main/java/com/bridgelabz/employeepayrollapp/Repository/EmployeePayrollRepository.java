package com.bridgelabz.employeepayrollapp.Repository;
import com.bridgelabz.employeepayrollapp.Model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Integer> {
}