-- emp ���̺��� ���, �̸�, �޿�, ���ʽ�, �޿�+���ʽ��� ȭ�鿡 �����ּ���.

SELECT empno, ename, sal, comm, sal+comm FROM emp;

-- ��ó�� �ϸ� NULL ���� ������ �÷������� �߸��� ����� ��µȴ�.

-- NULL ���� ������ �÷��� �ٸ� �÷��� ������ �ϸ� ��� NULL�� ó�� �ȴ�.
-- NVL() �Լ� : NULL ���� Ư���� ������ ������� �ִ� �Լ�
--             ��� ������ Ÿ�Կ� ������ ������
--             NVL() �Լ��� ����� ���� ��ȯ�Ǵ� ���� �ڷ����� ��ġ���Ѿ� ��.
-- ����) NVL(NULL���� ��� �ִ� �÷���, ������ ��)

SELECT empno, ename, sal, comm, sal+NVL(comm,0) FROM emp;

-- NVL2() �Լ� : �ڹٿ����� 3�׿����ڿ� ����� �Լ�.
-- ����) NVL2(�÷���, expr1, expr2)
--      ==> expr1 : �÷����� ���� NULL�� �ƴ� ��� ��ȯ
--      ==> expr2 : �÷����� ���� NULL�� ��� ��ȯ

SELECT empno, ename, sal, comm, sal+NVL2(comm, comm, 0) FROM emp;

-- AS : �÷����� �����ϴ� Ű���� ==> ��Ī(����)
-- �÷� �� �ٷ� �ڿ� �����. �÷���� ��Ī ���̿� AS��� Ű���带 �־���.
-- ��� ��Ī�� ""�ȿ� �ۼ�. AS ��Ī�� ���� ����.

SELECT empno, ename, sal, comm, sal+NVL2(comm, comm, 0) AS "�޿�+���ʽ�" FROM emp;

-- [����] emp ���̺��� ���, �����, �޿�, �޿��� 10% �λ���� ȭ�鿡 �����ּ���.

SELECT empno, ename, sal, sal*1.1 AS "�޿��� 10% �λ��" FROM emp;

-- emp ���̺��� �� ����� ������(job)�� ȭ�鿡 �����ּ���.

SELECT job FROM emp;

-- DISTINCT Ű���� : �ߺ��� �����ϴ� Ű����
-- �ַ� �ϳ��� �÷����� �ߺ��� ���� �����ϰ� ������ �� �����.
-- DISTINCT Ű����� �׻� SELECT Ű���� ������ ����Ѵ�.
-- DISTINCT Ű���� �ڿ� ������ �÷����� ��� DISTINCT�� ������ �޴´�.
-- DISTINCT �ڿ� ���� ���� �÷����� ����� �Ǹ� �ش� �÷����� �ߺ��� ���� �ʰ� ���´�.

-- emp ���̺��� �� ����� ������(mgr)�� ȭ�鿡 �����ּ���.

SELECT DISTINCT job FROM emp;

-- [����] emp ���̺��� �������� �μ���ȣ�� �ߺ��� ������ �� ȭ�鿡 �����ּ���.

SELECT DISTINCT job, deptno FROM emp;

-- member10 �̶�� ���̺��� ����� ����.

CREATE TABLE member10(
    num NUMBER(7) PRIMARY KEY,          -- ȸ����ȣ
    memid VARCHAR2(20) NOT NULL,        -- ȸ�� ID
    memname VARCHAR2(20) NOT NULL,      -- ȸ�� �̸�
    pwd VARCHAR2(20) NOT NULL,           -- ȸ�� ��й�ȣ
    age NUMBER(3),                      -- ȸ�� ����
    mileage NUMBER(8) NOT NULL,         -- ȸ�� ���ϸ���
    job VARCHAR2(30),                   -- ȸ�� ����
    addr VARCHAR2(200),                 -- ȸ�� �ּ�
    regdate DATE NOT NULL               -- ȸ�� ������
);

-- member10 ���̺� ���� ������ ������ ����.
INSERT INTO member10
VALUES(1, 'id1', 'ȫ�浿', '1111', 25, 0, '�л�', '�λ�� ������', '2013-08-08');

INSERT INTO member10
VALUES(2, 'id2', '��浿', '2222', 30, 1500, '������', '����� ������', '2013-08-08');

INSERT INTO member10
VALUES(3, 'id3', '������', '3333', 33, 1000, '������', '�λ�� �߱�', '2013-08-08');

INSERT INTO member10
VALUES(4, 'id4', '�迵��', '4444', 18, 3000, '�л�', '��󳲵� �����', '2012-09-09');

INSERT INTO member10
VALUES(5, 'id5', '�ڸ���', '5555', 45, 5000, '�ֺ�', '��⵵ �����ֽ�', '2013-08-08');

INSERT INTO member10
VALUES(6, 'id6', '��ö��', '6666', 55, 0, '����', '���ֵ� ��������', '2013-01-01');

INSERT INTO member10
VALUES(7, 'id7', 'ȫ�浿', '7777', 14, 6000, '�л�', '���ϵ� ���ֽ�', '2012-12-25');

INSERT INTO member10
VALUES(8, 'id8', '�����', '8888', 31, 0, '����', '����� ������', '2013-04-18');

INSERT INTO member10
VALUES(9, 'id9', '������', '9999', 25, 0, '�л�', '������ ������', '2013-02-06');

INSERT INTO member10
VALUES(10, 'id10', 'ȫ�浿', '0101', 52, 10000, '�ֺ�', '����� ���ϱ�', '2013-09-15');

-- ī�װ� ���̺��� ����� ����

create table category(
    cnum number(5) default '1' not null,
    category_code varchar2(8) not null,
    category_name varchar2(30) not null,
    delete_chk char(1) default 'N' not null,
    primary key(cnum)
);

-- ���̺��� ������ ����
-- drop table category purge;

-- ī�װ� ���̺� �����͸� ������ ����.
insert into category values(1, '00010000', '������ǰ', 'N');
insert into category values(2, '00010001', 'TV', 'N');
insert into category values(3, '00010002', '��ǻ��', 'N');
insert into category values(4, '00010003', 'MP3', 'N');
insert into category values(5, '00010004', '������', 'N');
insert into category values(6, '00020000', '�Ƿ�', 'N');
insert into category values(7, '00020001', '����', 'N');
insert into category values(8, '00020002', '�ӿ�', 'N');
insert into category values(9, '00020003', '����', 'N');
insert into category values(10, '00030000', '����', 'N');
insert into category values(11, '00030001', '��ǻ�͵���', 'N');
insert into category values(12, '00030002', '�Ҽ�', 'N');


-- ��ǰ �� ���� ���̺��� ����� ����.
create table products(
    pnum number(11) primary key,                  -- ��ǰ ��ȣ
    category_fk varchar2(8) not null,             -- ī�װ�
    products_name varchar2(50) not null,          -- ��ǰ��
    ep_code_fk varchar2(5) not null,              -- ��ǰ �ڵ�
    input_price number(10) default 0 not null,    -- �԰���
    output_price number(10) default 0 not null,   -- �����
    trans_cost number(5) default 0 not null,      -- ��ۺ�
    mileage number(6) default 0 not null,         -- ���ϸ���
    company varchar2(30),                         -- ������
    status char(1) default '1' not null           -- ��ǰ ��� ��Ȳ
);


-- ��ǰ �����͸� ������ ����.
insert into products
    values(1, '00010001', 'S ������ TV', '00001', 5000000, 8000000, 0, 100000,'�Ｚ','1');
insert into products
    values(2, '00010001', 'D TV', '00002', 300000, 400000, 0, 50000,'���','1');
insert into products
    values(3, '00010004', 'S ������', '00001', 1000000, 1100000, 5000, 100000,'�Ｚ','2'); 
insert into products
    values(4, '00010000', 'C ���', '00003', 200000, 220000, 5500, 0,'����','1');
insert into products
    values(5, '00010004', 'L ������', '00003', 1200000, 1300000, 0, 0,'LG','1');
insert into products
    values(6, '00020001', '��������', '00002', 100000, 150000, 2500, 0,'','1');
insert into products
    values(7, '00020001', '��������', '00002', 120000, 200000, 0, 0,'','3');
insert into products
    values(8, '00020002', '�簢��Ƽ', '00002', 10000, 20000, 0, 0,'���𰡵�','1');
insert into products
    values(9, '00020003', '�ủ����', '00002', 15000, 18000, 0, 0,'','1');
insert into products
    values(10, '00030001', '������ �ø���', '00001', 25000, 30000, 2000, 0,'���','1');
    
-- [����] member10 ���̺��� ȸ���� �̸��� ����, ������ ȭ�鿡 �����ּ���.

SELECT memname, age, job FROM member10;

-- [����] products ���̺��� ��ǰ��, �԰�, ���, �����縦 ȭ�鿡 �����ּ���.

SELECT products_name, input_price, output_price, company FROM products;

-- LITERAL ���ڿ�
-- �÷����̳� ��Ī�� �ƴ� SELECT ��Ͽ� ���ԵǴ� ����, ǥ���� ���ڸ� �ǹ�.
-- ��¥�� ���ڿ��� ��� ���� �ο��ȣ('')�� ����ؾ� �Ѵ�.
-- ��) "KING ����� ������ 60000 �Դϴ�."

SELECT ename || ' ����� ������ ' || sal*12 || ' �Դϴ�.' as "����� ����" FROM emp;

-- member10 ���̺��� ���ͷ� �۾��� �����غ���.
-- ��) "ȫ�浿 ȸ���� ������ �л��Դϴ�."

SELECT memname || ' ȸ���� ������ ' || job || ' �Դϴ�.' as "ȸ���� ����" FROM member10;

-- WHERE ������
-- ��� �����͸� �������� ���� �ƴ϶� ����ڰ� ���ϴ� �����͸� ��ȸ�� ��쿡 ���.
-- WHERE���� FROM ���̺� �̸� �ڿ� ����ؾ� �Ѵ�.
-- ����) SELECT �÷���1, �÷���2.... FROM ���̺�� WHERE ���ǽ�;
-- WHERE �������� �ڷḦ �˻��� �� ���Ǵ� Ű����.
-- 1) = : ������ ������?
-- 2) < : ������ ������?
-- 3) <= : ������ �۰ų� ������?
-- 4) > : ������ ū��?
-- 5) >== : ������ ũ�ų� ������?
-- 6) != : ������ ���� ������?
-- 7) <> : ������ ���� ������? !=�� ���� �ǹ�.
-- 8) BETWEEN A AND B : A�� B ���̿� �ִ°�?
--    ����) ���� ���� �տ� ����ϰ� ū ���� �ڿ� ����ؾ� ��.
-- 9) IN(LIST) : LIST �� �߿� ��� �ϳ��� ��ġ�ϴ°�?
-- 10) NOT BETWEEN A AND B : A�� B ���̿� ���� ������?(A,B �� �������� ����)
-- 11) NOT IN(LIST) : LIST ���� ��ġ���� �ʴ°�?

SELECT * FROM emp;

-- emp ���̺��� �������� 'MANAGER' �� ����� ��� ������ ȭ�鿡 �����ּ���.

SELECT * FROM emp WHERE job = 'MANAGER';

SELECT * FROM emp WHERE job = 'SALESMAN';

-- [����1] emp ���̺��� �������� 'CLERK'�� ����� ���, �̸�, ������, �޿� ���
SELECT empno, ename, job, sal FROM emp WHERE job = 'CLERK';

-- [����2] emp ���̺��� 1982�� 1�� 1�� ���Ŀ� �Ի��� ����� ���, �̸�, ������, �޿�, �Ի����� ���
SELECT empno, ename, job, sal, hiredate FROM emp WHERE hiredate > '19820101';
SELECT empno, ename, job, sal, hiredate FROM emp WHERE hiredate > '82/01/01';

-- [����3] emp ���̺��� �޿��� 1300 ~ 1500 ������ ����� �̸��� ������, �޿�, �μ���ȣ ���
SELECT ename, job, sal, deptno FROM emp WHERE sal BETWEEN 1300 AND 1500;
SELECT ename, job, sal, deptno FROM emp WHERE sal >= 1300 AND sal <= 1500;

-- [����4] emp ���̺��� ����� 7902, 7788,7566�� ����� ���, �̸�, ������ ���
SELECT empno, ename, job FROM emp WHERE empno IN(7902, 7788, 7566);
SELECT empno, ename, job FROM emp WHERE empno = 7902 OR empno = 7788 OR empno = 7566;

-- [����5] emp ���̺��� ���ʽ��� 300�̰ų� 500�̰ų� 1400�� ����� ��� ���� ���
SELECT * FROM emp WHERE comm IN(300, 500, 1400);
SELECT * FROM emp WHERE comm = 300 OR comm = 500 OR comm = 1400;

-- [����6] member10 ���̺��� �̸��� ȫ�浿�̸鼭 ������ �л��� ȸ���� ��� ���� ���
SELECT * FROM member10 WHERE memname = 'ȫ�浿' AND job = '�л�';

-- [����7] products ���̺��� �����簡 '�Ｚ' �Ǵ� '����' �̸鼭 �԰��� 100���� ������ ��ǰ�� ��ǰ��� �԰�, ��� ���
SELECT products_name, input_price, output_price FROM products WHERE company IN('�Ｚ','����') AND input_price <= 1000000;

-- [����8] emp ���̺��� �޿��� 1100 �̻��̰�, �������� 'MANAGER'�� ����� ���, �̸�, ������, �޿� ���
SELECT empno, ename, job, sal FROM emp WHERE sal >= 1100 AND job = 'MANAGER';









