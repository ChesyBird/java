package com.kh.practice2;

import com.kh.practice2.model.vo.Animal;
import com.kh.practice2.model.vo.Cat;
import com.kh.practice2.model.vo.Dog;

public class App {
    public static void main(String[] args) {
        //추상클래스(abstract)는 구현되기 전까지 생성이 불가능
        //new Animal();
        
        //1. 5칸 객체배열
        Animal[] animals = new Animal[5];

        //2. 각 인덱스에 무작위로 dog/cat 생성
        Dog dog1 = new Dog("하비", "푸들", 5);
        //부모타입으로 자동형변환
        //다형성: 여러가지 형태를 가질 수 있는 성질
        //자식객체가 재정의한 메서드가 실행되어지므로
        //다양한 기능을 구현할 수 있다
        animals[0] = dog1;

        animals[1] = new Cat("비아", "렉돌", "합정", "하양");
        animals[2] = new Dog("빌리", "보더콜리", 10);
        animals[3] = new Cat("야통", "코숏", "저수지", "삼색");
        animals[4] = new Cat("나비", "코숏", "합정", "턱시도");

        //3. 반복문을 통해 speak()메서드 호출
        // for(int i=0; i<animals.length; i++){
        //     animals[i].speak();
        //     System.out.println("=============================================");
        // }

        //향상for문
        for(Animal a : animals){
            a.speak();
            //객체를 출력하면 객체의 toString메서드가 호출됨
            //System.out.println(a);
            System.out.println("=============================================");
        };

    }
}
