package exam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exam.util.DBUtil;

public class EmployeeDao {
    List<Employee> list = new ArrayList<>();
   
    public List<Employee> findAll(){
        String sql = "SELECT * FROM EMP ORDER BY SALARY DESC";

         try (
            Connection con = DBUtil.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            while (rs.next()) {
                String empId = rs.getString(1);
                String empName = rs.getString(2);
                int salary = rs.getInt(8);
                            
                list.add(new Employee(empId, empName, salary));
            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        
    }
         return list;
}

    public static void main(String[] args) {
        EmployeeDao eDao = new EmployeeDao();
        List<Employee> list = eDao.findAll();
        for (Employee e : list) {
            System.out.println(e.toString());
        }
    }
}