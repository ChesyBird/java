package exam;

public class Employee {
    private String empId;
    private String empName;
    private Integer salary;

    public Employee(String empId, String empName, Integer salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    public String getEmpId() {
        return empId;
    }
    public String getEmpName() {
        return empName;
    }
    public Integer getSalary() {
        return salary;
    }
    @Override
    public String toString() {
        return "사번: %s, 이름: %s, 급여: %d".formatted(empId, empName, salary);

    }
    
}
