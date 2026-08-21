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

-- auto commit 확인
-- auto commit : 쿼리의 실행결과가 바로 반영
-- 1: true, 0: false
SELECT @@autocommit;
-- 1. 쿼리를 통해서 변경
-- 트랜젝션 처리(여러개의 실행쿼리를 하나로 묶는 작업) DML문장(입력 수정 삭제)만 해당
SET AUTOCOMMIT = 0; -- 오토커밋 해제
COMMIT; -- 작업내용 DB반영
ROLLBACK; -- 취소
-- 2. 워크벤치의 설정을 통해서 변경

-- 부서코드가 D5인 직원의 사번, 이름, 입사일 조회(급여가 높은 순으로 내림차순 정렬 - ORDER BY)
-- ORDER BY 컬럼이름 [ASC/DESC]
-- ASC : 오름차순. 기본값(생략가능)
-- DESC : 내림차순
SELECT		EMP_ID, EMP_NAME, HIRE_DATE, SALARY
FROM		EMP
WHERE		DEPT_ID = 'D5'
-- 날짜를 문자열로 작성시 : /, -
-- 2025-05-25, 2025/05/25, 20250525
-- 날짜 비교 : 문자열 형식으로 넣어주어도 자동 형변환이 됨
AND			HIRE_DATE > '2017-01-01'
ORDER BY	SALARY DESC; -- DESC: 내림차순 정렬. 기본은 오름차순

-- 중복제거
SELECT	DISTINCT DEPT_ID
FROM EMP;

-- 검색 - LIKE(조건절)
-- 성이 김씨이거나 이메일에 E가 포함된 사원을 조회
-- 컬럼이름 LIKE '김%' : 김으로 시작하는
-- 컬럼이름 LIKE '%김' : 김으로 끝나는 
-- 컬럼이름 LIKE '%김%' : 김을 포함하는
-- 제목, 내용, 작성자 검색에 자주 사용..
SELECT	*
FROM	EMP
WHERE	EMP_NAME LIKE '김%'
OR		EMAIL LIKE '%E%';

-- _ : 한글자
SELECT	*
FROM	EMP
WHERE	EMP_NAME LIKE '_용%';

-- 이메일에 언더바가 포함된 사원
-- 와일드카드 : 아무 문자나 와도 된다는 특수기호
-- ESCAPE : 와일드카드를 검색어 등으로 사용할 때 $뒤에 있는 문자에게 있는 용도를 없애고 문자로서 탈출시킴
-- '%$_%' ESCAPE '$'
-- '%_%' 형태로 쓸 경우 와일드카드문자로서 사용됨
SELECT	*
FROM		EMP
WHERE		EMAIL LIKE '%$_%' ESCAPE '$'
ORDER BY	EMP_ID DESC;

-- _없는 이메일 삽입
DESC EMP;
INSERT INTO	EMP (EMP_ID, EMAIL) VALUES ('300', 'abc@bbb.com');

-- 이씨가 아닌 사원
SELECT	*
FROM	EMP
WHERE	EMP_NAME NOT LIKE '이%';

SELECT	*
FROM	EMP
WHERE	DEPT_ID != 'D8';

-- IN : 여러 값 중 하나와 일치하면
-- 부서코드가 D1, D2, D3인 사원
SELECT	*
FROM	EMP
-- WHERE	DEPT_ID = 'D1' OR DEPT_ID = 'D2' OR DEPT_ID = 'D3';
WHERE	DEPT_ID IN ('D1', 'D2', 'D3');

-- 사원테이블에서 사용중인 부서코드 조회
-- D3이 존재하는지 확인
SELECT DISTINCT DEPT_ID FROM EMP ORDER BY DEPT_ID;

-- 보너스를 받지 않는 사원 : IS NULL
-- 보너스를 받는 사원 : IS NOT NULL
-- NULL은 비교연산자를 사용할 수 없다
SELECT	*
FROM	EMP
WHERE	BONUS IS NULL;
