package ex05.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ex05.dto.DeptDTO;
import ex05.util.DBUtil;

// 자바 애플리케이션에서 데이터베이스(DB)에 접근하여 CRUD(조회,삽입,수정,삭제)
public class DeptDao {
    // 접.제 반환타입 이름 (매개타입 매개이름){}
    /**
     * DB로부터 부서정보를 조회후 리스트 변환
     * 
     * @return List<DeptDTO>
     */
    public List<DeptDTO> findAll(){ 
        List<DeptDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM DEPT";

        try (
            // DB 조회 방법
            // 1. 데이터베이스 연결 
            // - 접속정보(ip, port, DB이름, userId, password)를 이용해서 Connection 객체 생성
            // 2. 쿼리 질의 - Statement 객체 생성
            // 3. 질의결과 객체에 담아주기
            Connection con = DBUtil.getConnection();
            Statement stmt = con.createStatement();
            // 결과집합을 받아올 때 사용
            // select(조회) - 결과집합
            // insert, update, delete - 숫자를 반환(처리된 데이터의 건수)
            ResultSet rs = stmt.executeQuery(sql);
            ){
            //    =>계층간 데이터 이동을 위해
            //      controller - service - dao(mapper)
            // 오류가 발생할 소지가 많은 부분!!
            // 이름으로 접근 시 오타발생, 데이터 누락, 코드의 중복, 자원의 미반납 등..
            //  -> 프레임워크: 쿼리만 작성하면 나머지는 자동으로 처리
            
            // .next() : 다음 행이 있다면 true, 없으면 false를 반환
            while (rs.next()) {
                // 데이터를 꺼내서 변수에 저장하고 객체를 만들어줌
                String deptId = rs.getString(1);
                String deptTitle = rs.getString("dept_title");
                String locationId = rs.getString(3);

                list.add(new DeptDTO(deptId, deptTitle, locationId));

            };

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

}
