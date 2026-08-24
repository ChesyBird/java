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

-- 사원이름, 직급이름 조회
SELECT	EMP_NAME 사원이름, E.JOB_CODE, JOB_NAME 직급이름
FROM	EMP E -- 테이블 이름에 별칭 -> 별칭을 준 순간부터는 별칭으로만 사용 가능
-- 테이블을 연결
-- JOIN
-- USING(컬럼이름) : 컬럼 이름이 같을 때 -> 공통컬럼의 테이블명을 명시하지 않는다
-- ON : 컬럼 이름이 다를 때
-- 테이블이름.컬럼이름 : 컬럼이름이 같은 경우 테이블이름을 명시적으로 써줘야 한다
-- JOIN 테이블이름 USING(컬럼명) : 공통컬럼-테이블명 명시하지 않음
-- LEFT JOIN	JOB USING(JOB_CODE);
JOIN	JOB J ON E.JOB_CODE = J.JOB_CODE;

-- 사원이름, 직급이름, 부서이름 조회
SELECT		EMP_NAME 사원이름, JOB_NAME 직급이름, DEPT_TITLE 부서이름
FROM		EMP E
-- 조건절 : 생략가능
-- INNER JOIN : 조건이 일치하는 행만 조회
JOIN		JOB J ON E.JOB_CODE = J.JOB_CODE -- 조건이 일치하는 행을 연결
-- OUTER JOIN : 조건이 일치하지 않아도 기준이 되는 테이블의 행을 모두 조회(조건이 일치하지 않아도 조회)
LEFT JOIN	DEPT D USING (DEPT_ID); -- 다른 테이블의 기본키를 참조

-- 사원이름. 부서명, 지역명, 국가명
-- 컬럼
SELECT		EMP_NAME 사원명, DEPT_TITLE 부서명, LOCAL_NAME 지역명, NATIONAL_NAME 국가명
-- 테이블
FROM		EMP E
-- 관계조건 설정
LEFT JOIN	DEPT USING(DEPT_ID)
LEFT JOIN	LOCATION ON LOCATION_ID = LOCAL_CODE -- 컬럼 이름이 다르기 때문에 테이블이름을 안써도 된다
LEFT JOIN	NATIONAL USING(NATIONAL_CODE);

-- VIEW 생성
CREATE	VIEW EMP_MASTER AS
SELECT		EMP_NAME 사원명, DEPT_TITLE 부서명, LOCAL_NAME 지역명, NATIONAL_NAME 국가명
FROM		EMP E
LEFT JOIN	DEPT USING(DEPT_ID)
LEFT JOIN	LOCATION ON LOCATION_ID = LOCAL_CODE -- 컬럼 이름이 다르기 때문에 테이블이름을 안써도 된다
LEFT JOIN	NATIONAL USING(NATIONAL_CODE);
-- VIEW 사용
SELECT	*
FROM	EMP_MASTER;

-- SQL 표준 주석
# MySQL에서 편의상 제공하는 주석

# 단일행 함수 : 행마다 적용, 입력된 행의 갯수만큼 반환
-- 함수이름(값/컬럼)
-- CHAR_LENGTH() : 문자열의 길이
-- LENGTH() : 바이트의 길이(한글이 3BYTE 차지)
-- INSTR(컬럼, 찾을문자열)
SELECT	EMAIL, CHAR_LENGTH(EMP_NAME), LENGTH(EMP_NAME)
		, INSTR(EMAIL, '@') -- 특정 문자가 처음 나오는 위치
        -- 개인정보 : 주민번호 뒷자리 제거 등에 사용
        , LPAD(EMAIL, 20, '*') -- 문자 길이를 채워서 출력
        , RPAD(EMAIL, 20, '*')
        , LPAD(EMAIL, 10, '*')
        , SUBSTRING(EMAIL, 1, INSTR(EMAIL,'@')-1)
        , SUBSTRING(EMAIL, INSTR(EMAIL, '@')+1)		-- 시작위치만 지정하면 끝까지 가져온다
        , CONCAT(EMP_NAME, '님')
        -- 주민번호 뒷자리를 *로 만들기
        , RPAD(SUBSTRING(EMP_NO, 1, INSTR(EMP_NO, '-')), CHAR_LENGTH(EMP_NO), '*')
FROM	EMP;

-- TRIM() -- 앞, 뒤, 양쪽의 지정 문자를 제거 후 출력 
SELECT 	TRIM('   Hello   ') AS 양쪽공백제거             -- 'Hello'
		,TRIM(BOTH 'z' FROM 'zzHELLOzz') AS 양쪽문자제거 -- 'HELLO'
		,LTRIM('   SQL') AS 왼쪽공백만                 -- 'SQL' (공백만 제거 가능)
		,RTRIM('SQL   ') AS 오른쪽공백만               -- 'SQL' 
        ,REPLACE('HELLO WORLD', ' ', '')			-- 치환 공백제거
        ,LOWER('aABb')								-- 전부 소문자
        ,UPPER('aABb')								-- 전부 대문자
		-- SUBSTRING(문자열, 시작위치, 길이)
        -- 시작위치 인덱스는 1부터 시작
        ,SUBSTRING('ABC@BBB.COM', 2, 5)				-- 두번째 위치부터 다섯문자
-- DUAL : 테스트용 테이블
-- MySQL에서 편의상 DUAL 생략 가능
FROM	DUAL;

# 그룹 함수 : 여러 행을 하나의 그룹으로 묶어, 그룹 당 하나의 결과를 출력
SELECT	'사원수', COUNT(*)
FROM	EMP;

-- 숫자함수
-- 절대값, 나머지, 반올림, 올림, 버림, 자름
SELECT ABS(-15.5),          -- 15.5
       MOD(10, 3),          -- 1 (나머지)
       ROUND(123.456, 1),   -- 123.5
       ROUND(123.456, -1),  -- 120   (10의 자리에서 반올림)
       CEIL(123.1),         -- 124
       FLOOR(123.9),        -- 123
       FLOOR(-123.1),       -- -124  (음수는 더 작은 정수 쪽으로)
       TRUNCATE(123.456, 1),  -- 123.4 (반올림 없이 자름)
       TRUNCATE(123.456, -1); -- 120 

SELECT	TRUNCATE(123456789, -3)
FROM	DUAL;
       
-- 날짜함수
SELECT	NOW() 현재날짜시간, CURDATE() '날짜'
		-- 날짜는 문자열 형식으로 넣어줄 수 있다(구분없이, -, /)
		, TIMESTAMPDIFF(MONTH, '2020-01-15', '20240320') '두 날짜 사이의 개월수' -- 두 날짜 사이의 차이
FROM	DUAL;

SELECT	EMP_NAME, HIRE_DATE, CURDATE()
		-- 뒤에서 앞에 있는 날짜를 빼줌
		, TIMESTAMPDIFF(DAY, HIRE_DATE, CURDATE()) '근무일수'
		, TIMESTAMPDIFF(MONTH, HIRE_DATE, CURDATE()) '근무개월수'
        , TIMESTAMPDIFF(YEAR, HIRE_DATE, CURDATE()) '근무햇수'
        , LAST_DAY(NOW()) '말일' -- 오늘 날짜를 기준으로 이 달의 마지막 날을 측정
        , EXTRACT(YEAR FROM NOW()) '년도 추출'
        , EXTRACT(MONTH FROM NOW()) '달 추출'
        , EXTRACT(DAY FROM NOW()) '일 추출'
        , DATE_ADD(HIRE_DATE, INTERVAL 6 MONTH) '입사 6개월 후'
        , DATE_ADD(CURDATE(), INTERVAL 100 DAY) '100일 후'
FROM	EMP;
