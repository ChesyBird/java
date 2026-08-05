package ex04.obj;

public class Student {
    private String name;
    private String studentId;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object obj) {
        // 참조되고 있는 주소가 같은지 확인
        if(this == obj) return true;
        // 이름과 학번이 같으면 같은 객체라고 판단
        // name + "/" + studentId

        // 명시적 형변환: 만약 타입을 확인하지 않으면 예외가 발생
        // 형변환 하기 전에 변환이 가능한지 확인
        if(obj instanceof Student){
            Student s = (Student)obj;
            System.out.println("this.studentId: " + this.studentId);
            System.out.println("obj.studentId: " + s.studentId);
            // 같은지 확인
            if(studentId.equals(s.studentId)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        
        return studentId.hashCode();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
