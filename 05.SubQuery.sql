# 형변환 함수
-- DATE_FORMAT(HIRE_DATE, '형식') : 날짜 형식 -> 문자 형식
-- STR_TO_DATE : 문자 -> 날짜
-- Y : 4자리 년도
-- y : 2자리 년도
SELECT	HIRE_DATE, DATE_FORMAT(HIRE_DATE, '%Y년 %M %D') 대문자, DATE_FORMAT(HIRE_DATE, '%y년 %m월 %d일') 소문자
		, SALARY 급여, CAST(SALARY AS CHAR) 급여문자열
        , CAST('12345' AS SIGNED) 문자타입을숫자로
        -- NULL : 연산대상 아님 -> 치환
        , IFNULL(BONUS, 0)
FROM	EMP; 

-- 자동형변환 되어져 연산이 됨
-- 함수확인, 연산
SELECT '1' + 123;

-- 치환
-- 주민등록번호 뒷자리가 1,3이면 '남', 2,4이면 '여'
-- CASE 값 WHEN '1' THEN '남'
--        WHEN '2' THEN '여' END
SELECT	EMP_NO, SUBSTRING(EMP_NO, 8, 1) 성별코드
		, CASE SUBSTRING(EMP_NO, 8, 1) WHEN '1' THEN '남'
									   WHEN '3' THEN '남'
                                       WHEN '2' THEN '여'
									   WHEN '4' THEN '여' 
                                       ELSE '기본값' END 성별
		, CASE WHEN SUBSTRING(EMP_NO, 8, 1) = '1' OR SUBSTRING(EMP_NO, 8, 1) = '3' THEN '남'
		       WHEN SUBSTRING(EMP_NO, 8, 1) = '2' OR SUBSTRING(EMP_NO, 8, 1) = '4' THEN '여' 
               ELSE '성별을 확인할 수 없습니다.' END 성별
		-- IF(조건문, 참결과, 거짓결과)
		, IF(SUBSTRING(EMP_NO, 8, 1) IN ('1', '3'), '남', '여') AS gender
        -- 1,3 남 2,4 여 나머지 확인불가
        , IF(SUBSTRING(EMP_NO, 8, 1) =1 OR SUBSTRING(EMP_NO, 8, 1) =3, '남', '여') AS gender
        , IF(SUBSTRING(EMP_NO, 8, 1) IN ('1', '3'), '남',
			 IF(SUBSTRING(EMP_NO, 8, 1) IN ('2', '4'), '여', '성별을 확인할 수 없습니다')) AS Gender
FROM	EMP;

SELECT	CASE WHEN SUBSTRING('123456-5678943', 8, 1) = '1' OR SUBSTRING('123456-5678943', 8, 1) = '3' THEN '남'
		     WHEN SUBSTRING('123456-5678943', 8, 1) = '2' OR SUBSTRING('123456-5678943', 8, 1) = '4' THEN '여' 
             ELSE '성별을 확인할 수 없습니다.' END 성별;

SELECT	IF(SUBSTRING('123456-5123456', 8, 1) IN ('1', '3'), '남', IF(SUBSTRING('123456-5123456', 8, 1)
		IN ('2', '4'), '여', '성별을 확인할 수 없습니다')) AS Gender;
        
# 그룹함수의 조건문
-- 부서별 급여의 합계, SUM(), GROUP BY 부서
-- 부서코드, 부서명, 합계 
SELECT		DEPT_ID, DEPT_TITLE, SUM(SALARY) '급여의 합계'
FROM		EMP
LEFT JOIN	DEPT USING(DEPT_ID)
-- 그룹으로 묶는다 : 여러개의 행이 하나로 합쳐지는 것
-- 그룹바이에 사용된 컬럼만 셀렉트절에 올 수 있음
GROUP BY	DEPT_ID, DEPT_TITLE;

-- 직급별 급여의 평균
-- 김씨이거나 이씨인 사원의 직급명, 급여의 평균
SELECT		JOB_NAME, FLOOR(AVG(SALARY)) '급여의 평균'
FROM		EMP
JOIN		JOB USING(JOB_CODE)
WHERE		EMP_NAME LIKE '김%'
			OR EMP_NAME LIKE '이%'
-- 기본키를 이용하는 것이 권장됨
GROUP BY	JOB_CODE, JOB_NAME
-- 집계함수의 결과 급여의 평균이 300만원 이상인 직급만 조회
-- HAVING절 : GROUP에 대한 조건절
HAVING		AVG(SALARY) > 3000000
-- 정렬 : 컬럼이름, 컬럼순서(인덱스-1부터 시작)
-- ORDER BY	JOB_NAME ASC;
ORDER BY	1 DESC;

-- JOIN 대신 SUBQUERY 이용하기
-- 쿼리(Main Query) 안의 쿼리(SubQuery)
-- 서브쿼리는 괄호 안에 작성
SELECT	DEPT_ID, (SELECT DEPT_TITLE FROM DEPT WHERE DEPT_ID = EMP.DEPT_ID) DEPT_TITLE
FROM	EMP;

-- 부서별 급여의 합계가 1000만원 이상인 부서를 조회
SELECT		DEPT_ID, DEPT_TITLE, SUM(SALARY) '급여의 합계'
FROM		EMP
JOIN		DEPT USING(DEPT_ID)
GROUP BY	DEPT_ID, DEPT_TITLE
HAVING		SUM(SALARY) >= 10000000
-- SELECT절에 사용한 별칭 이용 가능
ORDER BY	'급여의 합계' DESC; -- 급여의 합계를 이용해서 정렬!

-- 평균 급여보다 급여가 높은사람
-- 사원의 이름, 급여, 평균급여
-- 집계함수를 이용할 경우 일반 컬럼은 조회할 수 없음
-- 집계된 값을 츨력하고 싶은 경우 서브쿼리 사용
SELECT	EMP_NAME, SALARY, (SELECT ROUND(AVG(SALARY),-1) 평균급여 FROM EMP)
FROM	EMP
-- WHERE절에 집계함수를 이용할 수 없음 -> 서브쿼리 사용
-- 단일행, 단일컬럼 : =, >=, >, <, != ... 비교연산자(하나의 값과 비교)
WHERE	SALARY >= (SELECT AVG(SALARY) FROM EMP);

-- 조회결과 행이 하나: 단일행, 행이 여러개: 다중행
-- 단일행, 다중컬럼
-- NULL은 제외
SELECT	AVG(SALARY), SUM(SALARY), MAX(EMAIL), MIN(BONUS) FROM EMP;

-- 다중행 단일컬럼 서브쿼리
-- 부서가 D1, D2, D3
-- IN() : 괄호 안에 여러개의 값이 나열 -> 서브쿼리의 실행 결과가 다중행인 경우 사용 가능
SELECT	*
FROM	EMP
WHERE	DEPT_ID IN(SELECT DISTINCT DEPT_ID FROM EMP WHERE	JOB_CODE = 'J6');

-- 다중행 단일컬럼
-- 직급코드 J6인 사원의 부서코드
-- DISTINCT : 중복제거
SELECT	DISTINCT DEPT_ID
FROM	EMP
WHERE	JOB_CODE = 'J6';

-- 다중컬럼
-- 이광렬 사원과 같은부서, 같은직급 사원 조회
SELECT	*
FROM	EMP
WHERE	(DEPT_ID, JOB_CODE) = (SELECT DEPT_ID, JOB_CODE FROM EMP WHERE EMP_NAME = '이광렬');

-- 윤정주 사원보다 급여가 높은사원의 이름과 급여를 내림차순으로 정렬
-- 이름, 급여, 윤정주사원의 급여 출력
SELECT		EMP_NAME, SALARY, (SELECT SALARY FROM EMP WHERE EMP_NAME = '윤정주') '윤정주사원의 급여'
FROM		EMP
WHERE		SALARY > (SELECT SALARY FROM EMP WHERE EMP_NAME = '윤정주')
ORDER BY	SALARY;

-- 부장직급이 존재하는 부서의 사원정보를 출력
-- 부서코드, 이름
-- 사번 오름차순으로 정렬
SELECT	*
FROM	JOB;
-- 부장인 사원의 부서코드
SELECT	DISTINCT DEPT_ID
FROM	EMP
JOIN	JOB USING(JOB_CODE)
WHERE	JOB_NAME = '부장';

SELECT	DEPT_ID, EMP_NAME
FROM	EMP
-- 다중행 : IN절 이용
WHERE	DEPT_ID IN(SELECT	DISTINCT DEPT_ID
					FROM	EMP
					JOIN	JOB USING(JOB_CODE)
					WHERE	JOB_NAME = '부장')
ORDER BY EMP_ID DESC;

-- 주민번호를 기준으로 나이를 구하시오
-- 이름, 나이, 성별 
-- 이름을 오름차순으로 정렬
SELECT	EMP_NO, LPAD(SUBSTRING(EMP_NO, 1, 2), 4, CASE WHEN SUBSTRING(EMP_NO, 1, 2) LIKE '0%' THEN '20' ELSE '19' END)
FROM	EMP;

SELECT		EMP_NAME
			, EXTRACT(YEAR FROM NOW())-(LPAD(SUBSTRING(EMP_NO, 1, 2), 4, CASE WHEN SUBSTRING(EMP_NO, 1, 2) LIKE '0%' THEN '20' ELSE '19' END)) 나이
			, IF(SUBSTRING(EMP_NO, 8, 1) IN ('1', '3'), '남'
				, IF(SUBSTRING(EMP_NO, 8, 1) IN ('2', '4'), '여', '성별을 확인할 수 없습니다')) AS 성별
FROM		EMP
ORDER BY	EMP_NAME DESC;

-- 선생님 답안
SELECT		EMP_NAME
			, STR_TO_DATE(CASE WHEN SUBSTRING(EMP_NO, 8, 1) IN ('1', '2') THEN CONCAT('19', SUBSTRING(EMP_NO, 1, 6))
											WHEN	SUBSTRING(EMP_NO, 8, 1) IN ('3', '4') THEN CONCAT('20', SUBSTRING(EMP_NO, 1, 6)) END, '%Y%m%d') 생년월일
			, TIMESTAMPDIFF(YEAR, STR_TO_DATE(CASE WHEN SUBSTRING(EMP_NO, 8, 1) IN ('1', '2') THEN CONCAT('19', SUBSTRING(EMP_NO, 1, 6))
											WHEN	SUBSTRING(EMP_NO, 8, 1) IN ('3', '4') THEN CONCAT('20', SUBSTRING(EMP_NO, 1, 6)) END, '%Y%m%d'), NOW()) 나이
			, IF(SUBSTRING(EMP_NO, 8, 1) IN ('1', '3'), '남'
				, IF(SUBSTRING(EMP_NO, 8, 1) IN ('2', '4'), '여', '성별을 확인할 수 없습니다')) AS 성별
FROM		EMP
ORDER BY	EMP_NAME DESC;

-- TIMESTAMPDIFF(단위, 날짜1, 날짜2)
-- 주민번호로부터 생년월일 850512-1234567
-- 주민번호: 연도를 두자리로 표현
-- 뒤 첫번째자리가 1,2이면 19, 3,4이면 20 -> 4자리년월일(19850512)
-- 붙여준다 : 문자열 연결 CONCAT(문자, 문자)
-- 형변환(STR_TO_DATE('문자', '타입')) 후 날짜 연산
SELECT	EMP_NO 주민번호
		, SUBSTRING(EMP_NO, 1, 6) 생년월일
        , SUBSTRING(EMP_NO, INSTR(EMP_NO, '-')+1, 1) '뒤 한자리'
        , CONCAT(CASE WHEN SUBSTRING(EMP_NO, INSTR(EMP_NO, '-')+1, 1) IN ('1', '2') THEN '19'
			   WHEN SUBSTRING(EMP_NO, INSTR(EMP_NO, '-')+1, 1) IN ('3', '4') THEN '20'
               ELSE '판단 불가'
               END, SUBSTRING(EMP_NO, 1, 6)) '8자리년월일'
		, STR_TO_DATE(CONCAT(CASE WHEN SUBSTRING(EMP_NO, INSTR(EMP_NO, '-')+1, 1) IN ('1', '2') THEN '19'
			   WHEN SUBSTRING(EMP_NO, INSTR(EMP_NO, '-')+1, 1) IN ('3', '4') THEN '20'
               ELSE '판단 불가'
               END, SUBSTRING(EMP_NO, 1, 6)), '%Y%m%d') '날짜형변환'
		, TIMESTAMPDIFF(YEAR, STR_TO_DATE(CONCAT(CASE WHEN SUBSTRING(EMP_NO, INSTR(EMP_NO, '-')+1, 1) IN ('1', '2') THEN '19'
			   WHEN SUBSTRING(EMP_NO, INSTR(EMP_NO, '-')+1, 1) IN ('3', '4') THEN '20'
               ELSE '판단 불가'
               END, SUBSTRING(EMP_NO, 1, 6)), '%Y%m%d'), NOW()) 날짜비교
		, TIMESTAMPDIFF(MONTH, STR_TO_DATE(CONCAT(CASE WHEN SUBSTRING(EMP_NO, INSTR(EMP_NO, '-')+1, 1) IN ('1', '2') THEN '19'
			   WHEN SUBSTRING(EMP_NO, INSTR(EMP_NO, '-')+1, 1) IN ('3', '4') THEN '20'
               ELSE '판단 불가'
               END, SUBSTRING(EMP_NO, 1, 6)), '%Y%m%d'), NOW()) 날짜비교달
		, TIMESTAMPDIFF(MONTH, STR_TO_DATE(CONCAT(CASE WHEN SUBSTRING(EMP_NO, INSTR(EMP_NO, '-')+1, 1) IN ('1', '2') THEN '19'
			   WHEN SUBSTRING(EMP_NO, INSTR(EMP_NO, '-')+1, 1) IN ('3', '4') THEN '20'
               ELSE '판단 불가'
               END, SUBSTRING(EMP_NO, 1, 6)), '%Y%m%d'), NOW()) MOD 12 '달%12 나머지'
FROM	EMP;

SELECT	5 MOD 2 나머지;

-- 가장 최근에 입사한 사원과 성이 같은 사원
SELECT	*
FROM	EMP
WHERE	EMP_NAME LIKE CONCAT((SELECT SUBSTRING(EMP_NAME, 1, 1) FROM	EMP WHERE HIRE_DATE = (SELECT MAX(HIRE_DATE) FROM EMP)),'%');

SELECT	SUBSTRING(EMP_NAME, 1, 1) 성
FROM	EMP
WHERE	HIRE_DATE = (SELECT MAX(HIRE_DATE) FROM EMP);

-- 입사한지 10년이 지난 사원의 보너스를 10%인상하여 출력
SELECT	EMP_NAME, BONUS, IFNULL(BONUS, 0)+0.1 인상보너스
FROM	EMP
WHERE	(SELECT TIMESTAMPDIFF(YEAR, HIRE_DATE, NOW())) > 10;

-- 인라인뷰(서브쿼리를 FROM절에서 이용)
-- MySQL : 인라인뷰에 별칭을 주지 않으면 오류가 생김
SELECT	*
FROM	(SELECT		DEPT_ID, AVG(SALARY) AVG
		FROM		EMP
		GROUP BY	DEPT_ID) T
LEFT JOIN DEPT USING(DEPT_ID)
-- 인라인뷰의 실행결과 컬럼만 사용 가능
WHERE	AVG > 3000000;

-- 인라인뷰를 사용할 경우 테이블을 만드는 서브쿼리가 쿼리내에 존재하므로 길고 복잡한 쿼리가 된다
-- WITH절을 이용해서 서브쿼리로 가상테이블을 만들어두고 본문에서 참조할 수 있다
WITH T AS (SELECT `EMP_NAME` AS `사원명`,`dept`.`DEPT_TITLE` AS `부서명`,`location`.`LOCAL_NAME` AS `지역명`,`national`.`NATIONAL_NAME` AS `국가명` 
			FROM (((`emp`
			left join `dept` on((`emp`.`DEPT_ID` = `dept`.`DEPT_ID`)))
			left join `location` on((`dept`.`LOCATION_ID` = `location`.`LOCAL_CODE`)))
			left join `national` on((`location`.`NATIONAL_CODE` = `national`.`NATIONAL_CODE`))))
            
SELECT * FROM T;

-- 페이징처리에 주로 사용 LIMIT
-- 급여가 높은 5명만 출력(TOP N)
SELECT		*
FROM		EMP
ORDER BY	SALARY DESC;

SELECT		*
FROM		EMP
ORDER BY	SALARY DESC
LIMIT		5; -- 앞에서부터 다섯개

SELECT		*
FROM		EMP
ORDER BY	SALARY DESC
-- LIMIT 오프셋, 개수
-- 페이지 처리(전페이지의 끝번호, 페이지당 게시물 수)
-- 뒤에 나오는 값 : 페이지 당 게시물 수
LIMIT		5, 3; -- 앞에 다섯개 건너뛰고 3개

-- 매니저 조회
SELECT	DISTINCT MANAGER_ID
FROM	EMP;

SELECT	*
FROM	EMP E
JOIN	EMP M ON E.MANAGER_ID = M.EMP_ID; -- > 0, 1, 3, 5, 6, 10 나와야되는데...?

SELECT	*
FROM	EMP
WHERE	MANAGER_ID IS NULL;

SELECT EMP_NAME, SALARY
FROM EMP
-- IN, ANY, ALL
-- IN : 일치하는
-- ANY : 최대값보다 작은 (조회된 값 모두 만족)
-- ALL : 최소값보다 작은 (어느하나라도 만족)
WHERE SALARY < ANY (
    SELECT SALARY FROM EMP WHERE DEPT_ID = 'D8'
)
ORDER BY SALARY ASC;

-- 계층형 쿼리 : 트리관계를 표현 -> 조직도
-- 메뉴 : 계층형 쿼리를 이용해서 트리관계로 출력 - 메뉴를 데이터베이스로 관리
