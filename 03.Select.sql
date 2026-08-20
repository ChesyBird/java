-- select 컬럼명 [, 컬럼명, ...]
-- from 테이블명
-- where 조건식; 생략 가능

-- emp 테이블의 모든 데이터를 조회
select 	*
from 	emp;

-- emp테이블에서 사원의 이름과 급여만 조회
select EMP_NAME, SALARY from emp;

-- 쿼리작성은 웬만하면 대문자!
SELECT	EMP_NAME, SALARY
FROM	EMP
WHERE	EMP_NAME = '김민혜'; -- 문자열은 ''로 감싸줍니다

-- 급여가 350만원 이상인 사람을 조회
-- WHERE : 조건절
-- WHERE 절의 조건이 TRUE 인 행만 조회가 된다
SELECT	EMP_NAME, SALARY
FROM	EMP
WHERE	SALARY >= 3500000; 

-- 급여가 350만원 이상이고 부서가 회계관리부이거나 총무부인 사람을 조회
-- 1. 부서코드 확인하기 -> D2 , D1
SELECT	*
FROM	DEPT;

SELECT	EMP_NAME, SALARY, DEPT_ID
FROM	EMP
WHERE	SALARY >= 3500000  -- 조건을 연산자(AND, OR)를 이용해서 연결
AND		(DEPT_ID = 'D2'
OR		DEPT_ID = 'D9')
;

-- 별칭 : 컬럼 이름에 연산식, 함수식이 들어간 경우 조회된 결과 컬럼명에 별칭을 줄 수 있다
-- 별칭을 작성할 때 AS키워드가 이용가능(생략 가능)
-- 연봉계산 * + _ /
-- 월급여 * 12
SELECT	EMP_NAME 사원명, SALARY * 12 '연 봉' -- 별칭에 특수문자나 공백이 들어가려면 따옴표로 감싸야함
FROM	EMP;

SELECT	EMP_NAME, SALARY, BONUS FROM EMP;

-- 집계함수를 이용해서 사원의 수를 세기 -21명
SELECT	COUNT(*) FROM EMP;

-- 급여 + (급여*보너스)
-- NULL : 연산이 불가능하다
-- NULL을 다른 값으로 치환하는 함수로 변경 : IFNULL(컬럼이름, 변경할값)
SELECT	EMP_NAME, SALARY, IFNULL(BONUS, 0), SALARY*IFNULL(BONUS, 0) 보너스, SALARY+(SALARY*IFNULL(BONUS, 0)) '보너스를 포함한 급여'
FROM	EMP;

-- || 문자열 연결 (자바의 +)
SELECT	CONCAT(EMP_NAME, '님의 연봉은 ', SALARY * 12, '원 입니다.') 연봉, CONCAT(FLOOR(SALARY+(SALARY*IFNULL(BONUS, 0))), '원') 보너스월급 -- FLOOR : 소숫점버림함수
FROM	EMP;

-- 인사관리부 소속 사원
-- 급여가 150만원 이상이고 300만원 이하인 사람
-- BETWEEN A AND B 범위의 조건
-- NOT BETWEEN : 반대가 된다!
SELECT	*
FROM	EMP
WHERE	DEPT_ID = 'D1'
AND		SALARY BETWEEN 1500000 AND 3000000;