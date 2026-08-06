package ex05;

import java.util.List;

import ex05.dao.EmpDao;
import ex05.dto.EmpDTO;

public class DaoApp {
    public static void main(String[] args) {
        // 스태틱으로 만들어져있는 메서드는 new로 받아와야함~
        EmpDao empDao = new EmpDao();
        List<EmpDTO> list = empDao.findAll();

        // System.out.println(list);
        for(EmpDTO e : list){
            System.out.println(e);
        }
        
    }
}
