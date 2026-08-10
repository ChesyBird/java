package ex05.dto;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpDTO {
    String empId;
    String empName;
    int salary;
    String empNo;
    
    public String getEmpNo(){
        return empNo;
    }

    public void setEmpNo(String empNo){
        this.empNo = empNo;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "%s %s %s %s".formatted(empId, empName, salary, empNo);
    }

}
