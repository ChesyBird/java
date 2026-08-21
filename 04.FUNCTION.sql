-- 단일행함수 : 행마다 함수를 적용
-- 그룹함수 : 여러개의 행을 하나로 처리

-- 집계함수
-- COUNT, SUM, AVG, MAX, MIN
SELECT COUNT(*) FROM EMP; -- 조건에 맞는 전체 행의 갯수
SELECT COUNT(EMP_ID) FROM EMP;
SELECT COUNT(BONUS) FROM EMP; -- 컬럼의 값이 NULL이 아닌 컬럼의 갯수를 세어줌

-- 부서가 배정된 사원의 수
SELECT * FROM EMP WHERE DEPT_ID IS NULL;
SELECT COUNT(DEPT_ID) FROM EMP;

-- 총 급여의 합
SELECT CONCAT (SUM(SALARY), '원') 총급여 FROM EMP;

-- 급여가 가장 높은 사원, 가장 낮은 사원
SELECT MAX(SALARY) FROM EMP;
-- 서브쿼리 : 쿼리 안에 쿼리를 작성
SELECT	EMP_NAME 이름, SALARY 급여
FROM	EMP
WHERE	SALARY = (SELECT MAX(SALARY) FROM EMP)
OR		SALARY = (SELECT MIN(SALARY) FROM EMP);

-- 평균보다 더 많이 받는 사원
SELECT	EMP_NAME 사원명, SALARY 급여
FROM	EMP
WHERE	SALARY > (SELECT avg(SALARY) FROM EMP);

SELECT SUM(SALARY),              -- 65616240
	   AVG(SALARY),
       -- 소수점이하 반올림
       ROUND(AVG(SALARY)),       -- 3124583
       MAX(SALARY),              -- 8000000
       MIN(SALARY),              -- 1380000
       COUNT(*),                 -- 21  (전체 사원 수)
       COUNT(BONUS),             -- 9   (보너스를 받는 사원 수)
       COUNT(DISTINCT DEPT_ID),  -- 6   (사원이 배치된 부서 종류 수)
       COUNT(DISTINCT JOB_CODE)  -- 7   (등장하는 직급 종류 수)
FROM EMP;

-- 반올림, 버림, 천단위 절삭
SELECT	AVG(SALARY),
		ROUND(AVG(SALARY)), -- 소수점 이하 반올림
        ROUND(AVG(SALARY), 1), -- 소수점 이하 몇번째자리까지 보여주는지
        ROUND(AVg(SALARY), -1), -- 원단위 절삭 
        ROUND(AVg(SALARY), -3) -- 천단위 절삭
FROM EMP
-- 데이터를 그룹으로 묶어서 조회
-- 부서별 급여의 평균
GROUP BY DEPT_ID;

-- GROUP BY절을 사용하면 집계함수와 GROUP BY절에 사용된 컬럼만 조회 가능
-- 그룹이 아닌 SELECT(타 컬럼이나 *)을 넣으면 오류가 생긴다
SELECT		DEPT_ID
			,COUNT(*) '부서별 사원의 수'
            ,TRUNCATE(AVG(SALARY), -3) '부서별 급여의 평균'
            ,CONCAT(TRUNCATE(AVG(SALARY)/10000, 0), '만 원')
FROM		EMP
GROUP BY	DEPT_ID;

-- JOIN : 여러 테이블의 데이터를 하나의 결과로 합쳐서 조회
-- 사원명, 부서명을 조회
-- 조건을 주지 않으면 곱해져서 나온다(EMP테이블 22 * DEPT테이블 9)
SELECT	*
FROM	EMP, DEPT -- 여러개의 테이블이 나열된다
WHERE	EMP.DEPT_ID = DEPT.DEPT_ID; -- 테이블의 데이터를 연결 시켜주는 조건이 일치
									-- 부서를 배정받지 못한 사원은 누락되었다

-- 기본값 : 일치하는 데이터만 조회
-- 테이블끼리 같은 이름의 컬럼을 가진 경우에는 한 테이블의 이름을 명시해주어야함
SELECT	EMP_NAME, EMP.DEPT_ID, DEPT_TITLE
FROM	EMP
-- JOIN	DEPT USING(DEPT_ID) -- 컬럼 이름이 같을때 : 컬럼에 접근 시 테이블이름을 명시하지 않아도 ㅇㅋ
JOIN	DEPT ON EMP.DEPT_ID = DEPT.DEPT_ID -- 컬럼 이름이 다를 때
;

-- USING을 쓰면 굳이 명시해주지 않아도 된다
SELECT	EMP_NAME, DEPT_ID, DEPT_TITLE
FROM	EMP
-- JOIN을 기준으로 왼쪽에 있는 테이블의 데이터는 모두 조회
RIGHT JOIN	DEPT USING(DEPT_ID) -- 컬럼 이름이 같을때 : 컬럼에 접근 시 테이블이름을 명시하지 않아도 ㅇㅋ
-- JOIN	DEPT ON EMP.DEPT_ID = DEPT.DEPT_ID -- 컬럼 이름이 다를 때
;

-- 사원이름, 직급코드, 직급
-- EMP, JOB
-- 모든 사원이 출력되도록
SELECT	EMP_NAME, JOB_CODE, JOB_NAME
FROM	EMP
-- OUTER JOIN
-- LEFT : 왼쪽 테이블에 있다면 조건이 일치하지 않는 데이터도 모두 조회
-- RIGHT: 오른쪽 테이블에 있다면 조건이 일치하지 않는 데이터도 모두 조회
LEFT JOIN	JOB USING(JOB_CODE);

-- USING을 사용해서 EMP와 DEPT를 연결하고, 회계관리부('D2') 사원의 이름과 부서명을 조회
SELECT	EMP_NAME, DEPT_TITLE
FROM	EMP
JOIN	DEPT USING(DEPT_ID)
WHERE	DEPT_ID = 'D2';

-- 부서코드, 부서명, 부서별 사원수
SELECT		DEPT_ID 부서코드, DEPT_TITLE 부서명, CONCAT(COUNT(*), '명') 사원수
FROM		EMP
JOIN		DEPT USING(DEPT_ID)
GROUP BY	DEPT_ID, DEPT_TITLE;

