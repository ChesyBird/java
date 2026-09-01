SELECT * FROM EMP;
-- 1. AUTO COMMIT : FALSE
-- DML문장은 COMMIT 하지 않으면 저장되지 않는다
USE HAKSA;
USE HR;

-- 2. 다른 스키마의 데이터를 조회하는 경우 스키마 이름을 테이블 이름 앞에 붙여줘야 한다.
-- 다른 스키마에 접근하기 위해서는 권한이 필요하다
-- 권한 불충분 시 접근 불가능
SELECT * FROM HAKSA.TB_CLASS;

-- UPDATE, DELETE : WHERE절 없으면 테이블 전체에 적용됨

-- 실습테이블 준비
DROP TABLE IF EXISTS EMP_COPY;
-- 테이블의 구조와 데이터를 복사 -> 제약조건, 키 : 복사되지 않는다
CREATE TABLE EMP_COPY AS SELECT * FROM EMP;

SELECT COUNT(*) FROM EMP_COPY;

SELECT * FROM EMP
WHERE 1=1
-- 조건이 있을 수도 있고 없을 수도 있을 때
AND EMP_NAME LIKE '박%'
AND BONUS IS NOT NULL;

-- -------------------
-- DML : 데이터 조작어
-- 데이터 삽입, 수정, 삭제
-- -------------------

-- 전체 컬럼에 데이터를 입력
DESC EMP_COPY;
-- 외래키 제약조건, 기본키 제약조건이 걸리면 입력에 제한
-- 무결성 지키기 위해서 (쓸모없는 값이나 쓰레기 데이터가 들어오지 못하게 막는 역할)
-- NULL과 ''(빈문자열)은 다르다

-- 기본키 제약조건 NULL 입력 불가, 중복값 입력 불가
INSERT INTO	EMP_COPY VALUES ('222', '이미자', '111111-2222222', 'aaa@bbb.com', '01022223333'
							, 'D0', '37', 3000000, 0.3, 200, NOW(), NULL, 'N');
INSERT INTO	EMP_COPY VALUES ('223', '이미주', '111111-2222222', 'aaa@bbb.com', '01022223333'
							, 'D0', '37', 3000000, 0.3, 200, CURRENT_DATE(), NULL, 'N');
INSERT INTO	EMP_COPY VALUES ('224', '서미연', '111111-2222222', 'aaa@bbb.com', '01022223333'
							, 'D0', '37', 3000000, 0.3, 200, '2026-09-01', NULL, 'N');
-- 날짜, 시간
SELECT NOW(), CURRENT_DATE();

-- 일부 컬럼에 데이터를 입력
DESC EMP_COPY;
-- 테이블 이름 뒤에 컬럼을 명시
INSERT INTO EMP_COPY (EMP_ID, EMP_NAME) VALUES ('225', '정미현');

SELECT * FROM EMP_COPY ORDER BY EMP_ID DESC;

ROLLBACK;

-- 시스템 변수를 통해 현재 설정을 확인
-- FALSE : 0, TRUE : 1
SELECT @@AUTOCOMMIT;
SET AUTOCOMMIT = 0;

-- 데이터 수정
-- 사번 225번의 주민번호를 업데이트
-- SET 문장에는 기존 컬럼, 함수를 사용할 수 있다
-- Safe Update 모드 : 실수로 테이블 전체를 바꾸는 사고를 막기 위해 활성화
SELECT @@SESSION.sql_safe_updates;   -- 1이면 켜져 있음, 0이면 꺼져 있음
SET SESSION sql_safe_updates = 1;    -- 이 커넥션에서만 해제 (재접속하면 원상복구)

UPDATE EMP_COPY SET EMP_NO = '111111-*******', HIRE_DATE = CURRENT_DATE() WHERE EMP_ID = '225';
SELECT * FROM EMP_COPY;

-- 보너스 업데이트
-- 모든 사원의 보너스를 0.3으로 일괄 업데이트
-- SAFE MODE 활성화 시 오류 발생
UPDATE EMP_COPY SET BONUS = '0.3'; -- 모든 행이 영향을 받는다

UPDATE EMP_COPY SET BONUS = BONUS + '0.3';
-- IFNULL 함수를 이용해서 NULL 치환이 필요
UPDATE EMP_COPY SET BONUS = IFNULL(BONUS, 0) + '0.3';
-- NULL은 연산의 대상이 아님
SELECT IFNULL(BONUS , 0) FROM EMP;

-- 200번 사원의 주민번호(12345-1234567)와 보너스(기존보너스x1.1) 업데이트
UPDATE EMP_COPY SET EMP_NO = '123456-1234567', BONUS = BONUS*1.1 WHERE EMP_ID = '200';

-- 데이터 삭제
DELETE FROM EMP_COPY; -- 조건절을 생략하면 모든 데이터를 삭제

DELETE FROM EMP_COPY WHERE HIRE_DATE > '2024-01-01'; 
SELECT * FROM EMP_COPY;
ROLLBACK;

-- 기본키 추가
ALTER TABLE EMP_COPY ADD PRIMARY KEY (EMP_ID);
DESC EMP_COPY;
-- 외래키 추가 : 참조테이블의 컬럼에 등록된 값만 사용
ALTER TABLE EMP_COPY ADD CONSTRAINT FK_EMP_DEPT FOREIGN KEY (DEPT_ID) REFERENCES DEPT(DEPT_ID);

-- 하나의 SQL 문장으로 다중행 입력하기
INSERT INTO EMP_COPY (EMP_ID, EMP_NAME) VALUES
		('230', '일이삼')
        ,('231', '이삼사')
        ,('232', '오육칠')
        ,('233', '팔구십');
