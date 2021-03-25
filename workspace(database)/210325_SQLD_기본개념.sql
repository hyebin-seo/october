-- sql developer���� �ּ���
-- ����Ŭ���� �Ӽ��� ���� �ֿ� �ڷ���(data type)
-- 1. number(n, n1) : n - ��ü �ڸ��� / n1 - �Ҽ��� �ڸ��� / n - n1 : ���� �ڸ���
--    ��) number(7, 2) : ��ü �ڸ����� 7�ڸ��̰�, ������ 5�ڸ�, �Ǽ� 2�ڸ�

-- 2. char(n) : ���ڿ� n���� ����Ǵ� �ڷ���. ==> ���� �ڷ���.

-- 3. varchar(n) : ���ڿ� n���� ����Ǵ� �ڷ���. ==> ����� ������� �ʴ� �ڷ���

-- 4. varchar2(n) : ���ڿ� n���� ����Ǵ� �ڷ���. ==> ���� �ڷ���.
--                  �ѱ��� ������ �� ���ڴ� 2����Ʈ�� �Ҹ�.
                    
-- 5. date : ��¥�� ����Ǵ� �ڷ���. ==> �ý����� ���� ��¥ �� �ð� ����.

-- �߿� ����

-- ���Ἲ(integrity) : �����ͺ��̽��� ����� ������ ���� �װ��� ǥ���ϴ� ���� ������ ���� ����
--                   ��ġ�ϴ� ��Ȯ���� �ǹ���.
                      
-- ���Ἲ �������� : �����ͺ��̽��� ����� �������� ��Ȯ���� �����ϱ� ���ؼ� ��Ȯ���� ����
--                �����Ͱ� �����ͺ��̽� ���� ����Ǵ� ���� �����ϱ� ���� ����.

-- �����ͺ��̽� �󿡼� ���� ������ ����

-- 1. unique ���� ���� : �ߺ��� �Ǹ� �ȵǴ� ����.

-- 2. not null ���� ���� : ������ ������� �ʴ� ����.

-- 3. check ���� ���� : Ư���� ���� �ƴ� �����Ͱ� ������ ���ϰ� �ϴ� ����.

-- 4. primary key ���� ���� : unique + not null ���� ���� ==> �⺻Ű ���� ����.
--    �⺻Ű�� �ش� ���̺��� ��ǥ�ϴ� �÷����μ��� ������ �����ϸ�,
--    �ٸ� ���̺��� �ܷ�Ű���� ������ �� �ִ� Ű�μ��� �ڰ��� ������. �̸� ���� ���Ἲ�̶� ��.

-- �л� ���̺��� ����� ����.

-- ���� ���(�÷�/�Ӽ�) : �й�, �̸�, �а�, �г�, ����, ����ó, �ּ�, ������(�����)

-- create table ���̺� �̸�(
--    �й� �ڷ���(ũ��) {���� ����},
--    �̸� �ڷ���(ũ��) {���� ����},
--    �а� �ڷ���(ũ��) {���� ����},
--    �г� �ڷ���(ũ��) {���� ����},
--    ���� �ڷ���(ũ��) {���� ����},
--    ����ó �ڷ���(ũ��) {���� ����},
--    �ּ� �ڷ���(ũ��) {���� ����},
--    ������(�����) �ڷ���(ũ��) {���� ����}
-- );

CREATE TABLE student (
    hakbun  VARCHAR2(12) PRIMARY KEY,
    name    VARCHAR2(30) NOT NULL,
    major   VARCHAR2(30) NOT NULL,
    year    NUMBER(1),
    age     NUMBER(3),
    phone   VARCHAR2(20) NOT NULL,
    regdate DATE NOT NULL
);

-- ���̺� �÷��� �߰�
-- ����) ALTER TABLE ���̺�� ADD(�÷��� ������Ÿ��(ũ��) ��������);
-- student ���̺��� ������ �ּ� �÷��� �߰��� ����.

ALTER TABLE student ADD(address VARCHAR2(200));

-- ���̺��� �÷��� ����(�ڷ��� ����)
-- ����) ALTER TABLE ���̺�� MODIFY(�÷��� ������Ÿ��(ũ��));

ALTER TABLE student MODIFY(age VARCHAR2(3));

-- ���̺��� �÷����� �����ϱ�
-- ����) ALTER TABLE ���̺�� RENAME COLUMN �����÷��� to �����÷���;

ALTER TABLE student RENAME COLUMN address to addr;

-- ���̺��� �÷��� �����ϱ�
-- ����) ALTER TABLE ���̺�� DROP COLUMN �÷���;

ALTER TABLE student DROP COLUMN age;

ALTER TABLE student ADD(age NUMBER(3));





-- student ���̺� �����͸� �߰��� ����
-- ����) INSERT INTO ���̺�� 
--      VALUES('�й�','�̸�','�а�',�г�,'����ó',sysdate,'�ּ�',����);

INSERT INTO student
VALUES('2021_001','ȫ�浿','�����а�',3,'010-1111-1234',sysdate,'����� ������',27);

-- ����2) INSERT INTO ���̺��(�й��÷���, �̸��÷���, �а��÷���, ...)
--       VALUES(�й�������, �̸�������, �а�������, ...);
-- �÷��� �����͵��� ������ ¦ ���缭 �Է��ؾ� �Ѵ�.

INSERT INTO student(hakbun, name, major, phone, regdate)
VALUES ('2021_002','������','ȸ���а�','010-2222-2345',sysdate);

INSERT INTO student
VALUES('2021_003','�質��','�İ��а�',2,'010-3232-3232',sysdate,'��⵵ �ϻ�',22);

INSERT INTO student
VALUES('2021_004','�ڸ��','�����а�',1,'010-5555-6666',sysdate,'����� ���α�',24);

INSERT INTO student
VALUES('2021_005','������','ȭ�а�',2,'010-8888-7777',sysdate,'����� ������',23);

-- student ���̺��� Ư�� �÷��� ����(������) �� ����.
-- ����) UPDATE ���̺�� 
--      SET �÷��� = �÷���������
--      WHERE PRIMARY�� ������ �÷��� = �÷�������

UPDATE student SET addr = '��û���� õ�Ƚ�' WHERE hakbun = '2021_002';

UPDATE student
SET year = 2, phone = '010-6666-6789', addr = '����� ���ʱ�', age = 28
WHERE hakbun = '2021_005';

-- student ���̺��� Ư�� �����͸� ������ ����.
-- ����) DELETE FROM ���̺�� WHERE PRIMARY�� ������ �÷��� = �÷�������

DELETE FROM student WHERE hakbun = '2021_004';

-- student ���̺��� ��� �����͸� �����ϴ� ���.
-- ����) DELETE FROM ���̺��;

DELETE FROM student;

-- DB�� �Ϻ��ϰ� �����Ű���� �� �� ����ϴ� Ű����.
COMMIT;

-- DB�� �����Ű�� ���� ���� �� ����ϴ� Ű����.
ROLLBACK;

-- ���� ����(web)�� �ִ� ��� ���̺��� �����ּ���.
SELECT * FROM TAB;

-- student ���̺��� ��� �÷��� ȭ�鿡 �����ּ���.
SELECT * FROM student;

-- emp ���̺��� ��� �÷��� ȭ�鿡 �����ּ���.
SELECT * FROM emp;

-- emp ���̺��� empno, ename, job, deptno �÷��� ȭ�鿡 �����ּ���.
-- ����) SELECT �÷���1, �÷���2, ... FROM emp;

SELECT empno, ename, job, deptno FROM emp;

-- [����1] emp ���̺��� �̸�, �Ի���, �޿��� ȭ�鿡 �����ּ���.

SELECT ename, hiredate, sal FROM emp;

-- [����2] emp ���̺��� ���, �̸�, ������, ���ʽ��� ȭ�鿡 �����ּ���.

SELECT empno, ename, job, comm FROM emp;