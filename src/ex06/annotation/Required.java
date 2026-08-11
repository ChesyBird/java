package ex06.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 어노테이션 정의
// 1. 정의
// 2. 확인하고 기능 정의
// 메타어노테이션 - 어노테이션의 어노테이션.
// 어노테이션을 정의하기 위해 사용하는 어노테이션
@Target(ElementType.FIELD) // 어디에 붙일것인가 - 필드, 메서드, 클래스(의 선언부)
@Retention(RetentionPolicy.RUNTIME) // 언제까지 남겨둘(유지시킬) 것인가
// 어노테이션 정의
public @interface Required {

}
