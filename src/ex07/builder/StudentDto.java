package ex07.builder;

// 내부객체를 통해서 외부객체를 생성한다
// 외부객체(outter class)
public class StudentDto {
    private String studentId; // 학번
    private String name;      // 이름
    private int age;          // 나이
    private String major;     // 전공 

    // 생성자
    public StudentDto(Builder builder) {
        studentId = builder.studentId;
        name = builder.name;
        age = builder.age;
        major = builder.major;
    }

    // Builder객체를 생성 후 반환
    public static Builder Builder(){
        return new Builder();
    }

    // 내부객체(inner class)
    // StudentDto객체를 초기화 할 수 있도록 필드를 가지고있어야 함
    public static class Builder{
        private String studentId; // 학번
        private String name;      // 이름
        private int age;          // 나이
        private String major;     // 전공 

        public Builder setStudentId(String studentId) { 
            this.studentId = studentId;
            return this;  // 체이닝 하려면 반환형태를 통일해줘야함!
        }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setAge(int age) {
            this.age = age;
            return this;
        }
        public Builder setMajor(String major) {
            this.major = major;
            return this;
        }
        
        public StudentDto build(){
            // StudentDto 생성 후 반환
            return new StudentDto(this);
        }
    }


}
