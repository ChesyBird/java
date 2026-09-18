ALTER TABLE emp 
    ADD COLUMN id                  VARCHAR(20)  NOT NULL DEFAULT 'USER' COMMENT '권한 (ADMIN, USER)',
    ADD COLUMN pw				   varchar(20),
    ADD COLUMN password_time				   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '비밀번호 마지막 변경일',
    ADD COLUMN login_fail_count    INT          NOT NULL DEFAULT 0 COMMENT '로그인 실패 횟수',
    ADD COLUMN is_locked           TINYINT(1)   NOT NULL DEFAULT 0 COMMENT '계정 잠금 여부 (0:정상, 1:잠금)',
    ADD COLUMN last_login_at       DATETIME         NULL COMMENT '최종 로그인 일시'; 
    
    
    update emp set is_locked = 1, id=emp.emp_id, pw='1234' where emp_id='210';
    
    -- 실패카운트 업데이트
    -- login_fail_count = login_fail_count +1
    -- is_locked = login_fail_count가 5보다 크면 1, 아니면 0
    SELECT LOGIN_FAIL_COUNT, CASE WHEN LOGIN_FAIL_COUNT > 5 THEN 1 ELSE 0 END
    FROM EMP;
    
    UPDATE EMP
    SET LOGIN_FAIL_COUNT = LOGIN_FAIL_COUNT + 1,
		IS_LOCKED = CASE WHEN LOGIN_FAIL_COUNT > 5 THEN 1 ELSE 0 END
	WHERE EMP_ID = '203';
    
    commit;