package ex05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ex05.dto.EmpDTO;



public class App {
    // throws : 예외를 호출한 곳으로 위임
    // 호출한 곳에서 메서드를 처리해야 한다
    
    // 접속정보 필드로 정의 -> git에 노출될 위험 有 -> 프로퍼티 파일로 옮겨 정리
    private static final String URL =
            "jdbc:mysql://43.201.71.210:3306/HR?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "1234"; // 본인 MySQL 비밀번호로 수정

    public static void main(String[] args){
        // 예외를 발생시킬 소지가 있는 메서드인 경우
        // ctrl + 클릭으로 확인할 수 있음
        // 1. 나도 던진다(throws) - 프로그램의 비정상적 종료
        // 2. try-catch - 권장!

            try {
                // 라이브러리가 추가되었는지 확인하는 역할 - 클래스가 있는지 없는지
                // 클래스가 없는 경우 ClassNotFoundException 예외 발생
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("ex05.util.DBUtil 확인");
                // DB Connection 얻어오기- 인증
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
                // 쿼리 실행
                ResultSet rs = stmt.executeQuery("SELECT * FROM EMP");

                // 리스트 생성
                List<EmpDTO> list = new ArrayList<>();
                // 반복문을 이용해서 여러 사원의 정보를 읽어올 수 있도록 처리
                while (rs.next()) {
                    // 컬럼이름, 순서
                    // getString : 데이터를 문자열로 반환
                    // getInt : 데이터를 숫자로 반환
                    String empId = rs.getString("EMP_ID");
                    String empName = rs.getString(2);
                    int salary = rs.getInt("SALARY");
    
                    EmpDTO emp = new EmpDTO(empId, empName, salary, "", null, "");
                    // 리스트에 데이터를 추가
                    list.add(emp);
                    System.out.println("%s %s %s".formatted(empId, empName, salary));
                    
                }

                // 리스트에 들어있는 요소의 갯수
                System.out.println(list.size());
                System.out.println(list);
            } catch (ClassNotFoundException e) {
                System.out.println("라이브러리를 확인해주세요");
               
                e.printStackTrace();
            } catch (SQLException e){
                System.out.println();
                e.printStackTrace();
            } 
    

        System.out.println("프로그램 종료");

    }
}
