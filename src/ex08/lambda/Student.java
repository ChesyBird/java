package ex08.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
@Setter
@Getter
@ToString
*/
@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int score;
    private boolean check;

    public Student(String name, int score, StudentFilter filter){
        this.name = name;
        this.score = score;

        this.check = filter.test(this);
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    boolean check(StudentFilter filter){
        // 필드에 저장
        return filter.test(this);
    }
    // 필터를 이용해서 합격여부를 판단한다
    void check2(StudentFilter filter){
        // 필드에 저장
        check = filter.test(this);
    }
}
