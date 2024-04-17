package org.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "employee_details")
public class EmployeeDetails {
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpSal(float empSal) {
        this.empSal = empSal;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public void setEmpState(String empState) {
        this.empState = empState;
    }

    public Integer getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public Float getEmpSal() {
        return empSal;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public String getEmpState() {
        return empState;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;
    private String empName;
    private Float empSal;
    private Integer empAge;
    private String empState;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    private String remarks;

    // Constructors, getters, and setters
}