-- 1레벨: 관리자 없는 최상위
SELECT	EMP_ID, EMP_NAME, MANAGER_ID, 1 AS LVL 
FROM	EMP
WHERE	MANAGER_ID IS NULL 

-- 결과집합의 합집합
UNION

-- 2레벨: 1레벨 사번을 MANAGER_ID로 가진 직원
SELECT	EMP_ID, EMP_NAME, MANAGER_ID, 2 AS LVL 
FROM	EMP WHERE MANAGER_ID IN (
								SELECT EMP_ID FROM EMP WHERE MANAGER_ID IS NULL)
ORDER BY LVL, MANAGER_ID, EMP_ID;


WITH RECURSIVE EmpTree AS (
-- (1) 앵커: 관리자가 없는 최상위 (2.1의 쿼리와 동일)
SELECT	EMP_ID, EMP_NAME, MANAGER_ID,
		1 AS LVL,                              -- 트리 깊이
        CAST(EMP_NAME AS CHAR(200)) AS PATH    -- 루트부터의 경로 (넉넉한 길이로)
FROM	EMP
WHERE	MANAGER_ID IS NULL
UNION ALL    -- (3) 재귀: 직전 결과(t)의 사원을 관리자로 둔 부하 직원(e)을 붙인다
SELECT	e.EMP_ID, e.EMP_NAME, e.MANAGER_ID,
        t.LVL + 1,
        CONCAT(t.PATH, ' > ', e.EMP_NAME)
FROM	EMP e
JOIN	EmpTree t ON e.MANAGER_ID = t.EMP_ID)
-- (4) 완성된 가상 테이블을 경로순 정렬 + 깊이만큼 들여쓰기
SELECT	EMP_ID,
-- REPEAT(반복할값, 반복횟수)
       CONCAT(REPEAT('    ', LVL - 1), '└ ', EMP_NAME) AS 조직도,
       MANAGER_ID, LVL, PATH AS 전체경로
FROM	EmpTree 
WHERE	LVL < 3
ORDER BY PATH;