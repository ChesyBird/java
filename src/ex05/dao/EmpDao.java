package ex05.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ex05.dto.EmpDTO;
import ex05.util.DBUtil;

// 데이터베이스에 접근해서 쿼리의 질의결과를 반환
// xxxDao
// Data Axxess Object의
//  자바 애플리케이션에서 데이터베이스(DB)에 접근하여 데이터의 조회, 삽입, 수정, 삭제(CRUD)
// 작업을 전담하는 객체(클래스)를 의미
public class EmpDao {

    // 사원의 정보를 조회하고 리스트를 반환하는 메서드
    // xxxDTO
    // Data Transfer Object
    // 데이터를 계층 간에 전달하기 위해 순수하게 데이터를 담아두는 바구니
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
                // 입사일
                LocalDate hire = rs.getDate("hire_date").toLocalDate();
                // 퇴사일
                String entDate = rs.getString("ent_Date");
                            
                // dto생성 및 리스트에 담기
                list.add(new EmpDTO(empId, empName, salary, "", hire, entDate));
            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
        }
        
        return list;
    }

    // 사원 조회 - 사원반환
    // 사원이 없으면 - null
    public EmpDTO find(String name) {
        // ;은 문장 맨 마지막에만!
        String sql = "SELECT * FROM EMP WHERE EMP_NAME = '%s'".formatted(name);

        EmpDTO emp = null;
        try (
            // 1. connection 연결
            Connection con = DBUtil.getConnection();
            // 2.쿼리 질의
            Statement stmt = con.createStatement();
            // 3.질의결과 결과집합(ResultSet)을 반환
            ResultSet rs = stmt.executeQuery(sql);
        ){
            if(rs.next()){
                String empId = rs.getString(1);
                String empName = rs.getString(2);
                int salary = rs.getInt(8);
                // 입사일
                LocalDate hire = rs.getDate("hire_date").toLocalDate();
                // 퇴사일
                String entDate = rs.getString("ent_Date");
                
                // 한명의 사원 정보를 반환
                return new EmpDTO(empId, empName, salary, "", hire, entDate);            
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emp;

        // 에러를 발생
        // throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

	public int updateEntYn(String empId) {
        int res = 0;
        String sql = "UPDATE `EMP` SET `ENT_YN`='Y' WHERE 'EMP_ID'='%s'".formatted(empId);
		 try (
            // 1. connection 연결
            Connection con = DBUtil.getConnection();
            // 2.쿼리 질의
            Statement stmt = con.createStatement();
            // 3.질의결과 결과집합(ResultSet)을 반환
        ){
            // int타입은 try()안에 쓸 수 없다!
            res = stmt.executeUpdate(sql);

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
	};


    // 테이블 이름만 바꾼 쿼리로 다른 것도 가능!
}
