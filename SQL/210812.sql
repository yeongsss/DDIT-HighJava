SELECT * FROM LPROD
WHERE LPROD_ID  between 2
and 9;


CREATE TABLE BANKINFO(
    BANK_NO VARCHAR2(40) NOT NULL, --���¹�ȣ
    BANK_NAME VARCHAR2(40) NOT NULL, --�����̸�
    BANK_USER_NAME VARCHAR2(30) NOT NULL, --�������̸�
    BANK_DATE DATE NOT NULL,        -- ������¥
    CONSTRAINT PK_BANKINFO PRIMARY KEY (BANK_NO)
    );
    
    
INSERT INTO BANKINFO (BANK_NO, BANK_NAME, BANK_USER_NAME, BANK_DATE)
VALUES ('11-22-3333-4444', '��������', 'ȫ�浿', SYSDATE);

 --LPROD  10 501 ��깰
 

SELECT MAX(LPROD_ID) as id
 FROM LPROD;  --�ִ밪

SELECT COUNT(*) 
 FROM LPROD 
 WHERE LPROD_GU = 'P101';  --�ߺ������� ã�� (������ 1, ������ 0)

INSERT INTO LPROD 
VALUES (10,'P501','��깰');
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
 values ('oracle','ddit', '����Ŭ','121445','���� �߱�');

delete from mymember
 where mem_id = 'ddit';

rollback;

update mymember 
set mem_pass = 'java' , 
    MEM_NAME = '�ڹ�',
    mem_tel = '',
    MEM_ADDR = ''
where MEM_ID = 'ddit';

select * from MYMEMBER;


--------------------------------------------------------------------------------------
create table jdbc_board(
    board_no number not null,  -- ��ȣ(�ڵ�����)
    board_title varchar2(100) not null, -- ����
    board_writer varchar2(50) not null, -- �ۼ���
    board_date date not null,   	-- �ۼ���¥
    board_cnt numbesr default 0, -- ��ȸ��
    board_content clob,     	-- ����
    constraint pk_jdbc_board primary key (board_no)
);

create sequence board_seq
    start with 1   -- ���۹�ȣ
    increment by 1; -- ������
 
--------------------------------------------------------------------------------------

INSERT INTO JDBC_BOARD (BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE,BOARD_CONTENT)
    VALUES(BOARD_SEQ.NEXTVAL, '����', '�ۼ���' ,SYSDATE,'�׽�Ʈ�Դϴ�' );
    
    
SELECT BOARD_TITLE, BOARD_WRITER, BOARD_CONTENT, BOARD_DATE, BOARD_CNT
 FROM JDBC_BOARD
 WHERE BOARD_NO = 1;

commit;

--------------------------------------------------------------------------------------

UPDATE JDBC_BOARD
   SET BOARD_TITLE = '����',
       BOARD_CONTENT = '����'
 WHERE BOARD_NO = 1;   
    
    
DELETE FROM JDBC_BOARD
 WHERE BOARD_NO = 1;
 
SELECT BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_CNT
 FROM JDBC_BOARD;


SELECT BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_CNT
 FROM JDBC_BOARD
 WHERE BOARD_TITLE LIKE '%��%';
 
 
select count(*) cnt 
  from JDBC_BOARD 
 where BOARD_TITLE like '%����%';

--------------------------------------------------------------------------------------

commit

select * from mymember;

UPDATE JDBC_BOARD 
  SET BOARD_CNT = BOARD_CNT + 1 
WHERE BOARD_NO = 5;

SELECT * FROM JDBC_BOARD;


--------------------------------------------------------------------------------------

-- ���̺��� �÷������� VO��ü�� ��������� �ڵ����� �����
select 'public ' || 
        decode(lower(data_type), 'number ','int ', 'String ') ||
        lower(column_name) || ';'
from cols
where lower(table_name)=lower('jdbc_board'); -- ���̺���� �����ؼ� �˻��Ѵ�.
-- where table_name=='���̺��';

--------------------------------------------------------------------------------------












