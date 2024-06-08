package org.example.lab7_20211688.beans;

public class EmployeesB {
    private int employee_id;
    private String fullNameEmployee;
    private String email;
    private String hireDate;
    private String jobId;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public EmployeesB() {

    }

    public EmployeesB(String email, int employee_id, String fullNameEmployee, String hireDate,String jobId) {
        this.email = email;
        this.employee_id = employee_id;
        this.fullNameEmployee = fullNameEmployee;
        this.hireDate = hireDate;
        this.jobId = jobId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFullNameEmployee() {
        return fullNameEmployee;
    }

    public void setFullNameEmployee(String fullNameEmployee) {
        this.fullNameEmployee = fullNameEmployee;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
}
