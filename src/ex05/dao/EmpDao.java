package ex05.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ex05.dto.EmpDTO;
import ex05.util.DBUtil;

// 데이터베이스에 접근해서 쿼리의 질의결과를 반환받아오는 역할
public class EmpDao {

    // 사원의 정보를 조회하고 리스트를 반환하는 메서드
    public List<EmpDTO> findAll(){
        List<EmpDTO> list = new ArrayList<>();

        // 사원 정보를 조회하는 쿼리
        // ORDER BY 정렬컬럼 DESC(내림차순)
        String sql = "SELECT * FROM EMP ORDER BY SALARY DESC";
        
        // try문의 () 안에 생성된 객체는 try문을 벗어나면 반납을 자동으로 해줌
        try (
            // 1. connection 연결
            Connection con = DBUtil.getConnection();
            // 2.쿼리 질의
            Statement stmt = con.createStatement();
            // 3.질의결과 결과집합(ResultSet)을 반환
            ResultSet rs = stmt.executeQuery(sql);
        ){
            while (rs.next()) {
                String empId = rs.getString(1);
                String empName = rs.getString(2);
                int salary = rs.getInt(8);
                // dto생성 및 리스트에 담기
                list.add(new EmpDTO(empId, empName, salary));
            }
            

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            
        }
        
        return list;
    };


    // 테이블 이름만 바꾼 쿼리로 다른 것도 가능!
}
