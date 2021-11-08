SELECT * FROM LPROD
WHERE LPROD_ID  between 2
and 9;


CREATE TABLE BANKINFO(
    BANK_NO VARCHAR2(40) NOT NULL, --계좌번호
    BANK_NAME VARCHAR2(40) NOT NULL, --은행이름
    BANK_USER_NAME VARCHAR2(30) NOT NULL, --예금주이름
    BANK_DATE DATE NOT NULL,        -- 개설날짜
    CONSTRAINT PK_BANKINFO PRIMARY KEY (BANK_NO)
    );
    
    
INSERT INTO BANKINFO (BANK_NO, BANK_NAME, BANK_USER_NAME, BANK_DATE)
VALUES ('11-22-3333-4444', '국민은행', '홍길동', SYSDATE);

 --LPROD  10 501 농산물
 

SELECT MAX(LPROD_ID) as id
 FROM LPROD;  --최대값

SELECT COUNT(*) 
 FROM LPROD 
 WHERE LPROD_GU = 'P101';  --중복데이터 찾기 (있으면 1, 없으면 0)

INSERT INTO LPROD 
VALUES (10,'P501','농산물');
--------------------------------------------------------------------------------------

CREATE TABLE MYMEMBER (
    MEM_ID VARCHAR2(15) NOT NULL,
    MEM_PASS VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(30) NOT NULL,
    MEM_TEL VARCHAR2(14),
    MEM_ADDR VARCHAR2(70),
    CONSTRAINT PK_MYMEMBER PRIMARY KEY (MEM_ID)
);

--------------------------------------------------------------------------------------

insert into MYMEMBER
 values ('oracle','ddit', '오라클','121445','대전 중구');

delete from mymember
 where mem_id = 'ddit';

rollback;

update mymember 
set mem_pass = 'java' , 
    MEM_NAME = '자바',
    mem_tel = '',
    MEM_ADDR = ''
where MEM_ID = 'ddit';

select * from MYMEMBER;


--------------------------------------------------------------------------------------
create table jdbc_board(
    board_no number not null,  -- 번호(자동증가)
    board_title varchar2(100) not null, -- 제목
    board_writer varchar2(50) not null, -- 작성자
    board_date date not null,   	-- 작성날짜
    board_cnt numbesr default 0, -- 조회수
    board_content clob,     	-- 내용
    constraint pk_jdbc_board primary key (board_no)
);

create sequence board_seq
    start with 1   -- 시작번호
    increment by 1; -- 증가값
 
--------------------------------------------------------------------------------------

INSERT INTO JDBC_BOARD (BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE,BOARD_CONTENT)
    VALUES(BOARD_SEQ.NEXTVAL, '제목', '작성자' ,SYSDATE,'테스트입니다' );
    
    
SELECT BOARD_TITLE, BOARD_WRITER, BOARD_CONTENT, BOARD_DATE, BOARD_CNT
 FROM JDBC_BOARD
 WHERE BOARD_NO = 1;

commit;

--------------------------------------------------------------------------------------

UPDATE JDBC_BOARD
   SET BOARD_TITLE = '제목',
       BOARD_CONTENT = '내용'
 WHERE BOARD_NO = 1;   
    
    
DELETE FROM JDBC_BOARD
 WHERE BOARD_NO = 1;
 
SELECT BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_CNT
 FROM JDBC_BOARD;


SELECT BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_CNT
 FROM JDBC_BOARD
 WHERE BOARD_TITLE LIKE '%ㅇ%';
 
 
select count(*) cnt 
  from JDBC_BOARD 
 where BOARD_TITLE like '%새글%';

--------------------------------------------------------------------------------------

commit

select * from mymember;

UPDATE JDBC_BOARD 
  SET BOARD_CNT = BOARD_CNT + 1 
WHERE BOARD_NO = 5;

SELECT * FROM JDBC_BOARD;


--------------------------------------------------------------------------------------

-- 테이블의 컬럼명으로 VO객체의 멤버변수를 자동으로 만들기
select 'public ' || 
        decode(lower(data_type), 'number ','int ', 'String ') ||
        lower(column_name) || ';'
from cols
where lower(table_name)=lower('jdbc_board'); -- 테이블명을 지정해서 검색한다.
-- where table_name=='테이블명';

--------------------------------------------------------------------------------------












