-- LIKE Ű���� : �˻��� �ϴ� Ű����
-- WHERE ename LIKE '%S%' : ename �÷��� S�ڸ� �����ϴ� ����� �̸��� �˻�
-- WHERE ename LIKE 'S%' : ename �÷��� ù ���ڰ� S�� �����ϴ� ����� �̸��� �˻�
-- WHERE ename LIKE '%S' : ename �÷��� ������ ���ڰ� S�� ������ ����� �̸��� �˻�
-- WHERE ename LIKE '_S%' : ename �÷��� �ι�° ���ڰ� S�ڸ� �����ϴ� ����� �̸��� �˻�

SELECT *
FROM emp
WHERE ename LIKE '%S%';

SELECT *
FROM emp
WHERE ename LIKE '%M%';

SELECT *
FROM emp
WHERE ename LIKE '_I%';

-- [����1] emp ���̺��� �̸��� 'S'�ڷ� ������ ����� �̸��� ������ ���
SELECT *
FROM emp
WHERE ename LIKE '%S';

-- [����2] emp ���̺��� �̸��� ����°�� 'R'�� ���� ����� �̸��� ������, �޿� ���
SELECT ename, job, sal
FROM emp
WHERE ename LIKE '__R%';

-- [����3] emp ���̺��� �̸��� �ι�°�� 'O'�� ���� ����� ��� ���� ���
SELECT *
FROM emp
WHERE ename LIKE '_O%';

-- [����4] emp ���̺��� �Ի�⵵�� 82�⵵�� ����� ���, �̸�, �Ի����� ���
SELECT empno, ename, hiredate
FROM emp
WHERE hiredate LIKE '82%';

-- [����5] member10 ���̺��� ���� �达�� ȸ���� ��� ���� ���
SELECT *
FROM member10
WHERE memname LIKE '��%';

-- [����6] member10 ���̺��� �ּҿ� '�����'�� ���� ȸ���� �̸�, �ּ�, ���� ���
SELECT memname, addr, job
FROM member10
WHERE addr LIKE '%�����%';

-- ORDER BY ��
-- �ڷḦ �����Ͽ� ��Ÿ�� �� �ʿ��� ����.
-- SELECT ������ ���� �������� ��ġ.
-- asc : �������� ����
-- desc : �������� ����
-- �⺻������ ORDER BY���� ��� �ÿ��� DEFAULT�� �������� ����.
-- �������� ������ ��쿡�� ASC ���� ����.
-- NULL ���� �������������� ���� ���߿� ������, �������������� ���� ���� ����.

-- member10 ���̺��� �̸��� �������� ������������ �����Ͽ� ���.
-- ��, �̸��� ���� ��� ���� �������� ����
SELECT * FROM member10 ORDER BY memname, age DESC;

-- [����1] EMP ���̺��� �μ���ȣ�� �������� �������� �����ϰ�,
-- �μ���ȣ�� ������ �޿� �������� �������� ����.
SELECT * FROM emp ORDER BY deptno, sal DESC;

-- [����2] PRODUCT ���̺��� �ǸŰ����� �������� �������� �����Ͽ� ��� ���� ���
SELECT * FROM products ORDER BY output_price DESC;

-- [����3] PRODUCT ���̺��� ��ۺ� �������� ��� ������ �������� ����.
-- ��, ��ۺ� ���� ��� ���ϸ����� �������� ������������ ����.
SELECT * FROM products ORDER BY trans_cost DESC, mileage DESC;

-- [����4] EMP ���̺��� �Ի����ڰ� ������ ������� �ֱٿ� �Ի��� ����� �������� ����.
-- �����, �Ի����� ���
SELECT ename, hiredate FROM emp ORDER BY hiredate;

-- [����5] EMP ���̺��� �޿��� �������� �������� �����Ͽ� ��� ���� ���.
SELECT * FROM emp ORDER BY sal DESC;

-- [����6] EMP ���̺��� �޿��� 1100 �̻��� ������� ��� ���� ����ϵ� �Ի����ڰ� ���������� ����.
SELECT * FROM emp WHERE sal >= 1100 ORDER BY hiredate;

-- [����7] EMP ���̺��� �μ���ȣ�� �������� �������� �����ϰ�,
-- �μ���ȣ�� ���� ��� �������� ������������ ����.
-- �������� ������ �޿��� �������� ���������� ���.
-- ��� ���� ���.
SELECT * FROM emp ORDER BY deptno, job, sal DESC;

-- NOT Ű���� : ����
-- ������ �ۼ� �� ������ �ƴ� ������ �������� �ۼ��� �Ŀ� ������ �ǹ��� NOT�� ���δ�.
-- emp ���̺��� �������� 'MANAGER', 'CLERK', 'ANALYST'��
-- �ƴ� ����� ���, �̸�, ������, �޿��� ���

SELECT empno, ename, job, sal
FROM emp
WHERE job NOT IN ('MANAGER','CLERK','ANALYST');

-- [����1] EMP ���̺��� �̸��� 'S'�ڰ� ���� �ʴ� ����� �̸��� ���.
SELECT ename FROM EMP WHERE ename NOT LIKE '%S%';

-- [����2] EMP ���̺��� �μ���ȣ�� 10�� �μ��� �ƴ� ����� �̸�, ������, �μ���ȣ�� ���.
SELECT ename, job, deptno FROM emp WHERE NOT deptno = 10;

-- [����3] MEMBER10 ���̺��� �ּҰ� '����'�� �ƴ� ȸ���� ��� ������ ���.
SELECT * FROM member10 WHERE addr NOT LIKE '%����%';

-- [����4] PRODUCTS ���̺��� ����� 100���� �̸��� �ƴ� ��ǰ�� ��ǰ��, ����� ���
SELECT products_name, output_price
FROM products
WHERE NOT output_price < 1000000; 

-- �׷� �Լ�
-- ���� �� �Ǵ� ���̺� ��ü�� ���Ͽ� �Լ��� ����Ǿ� �ϳ��� ������� �������� �Լ�.
-- 1) AVG() : ��� ���� ���ϴ� �Լ�.
-- 2) COUNT() : ���� ������ ���ϴ� �Լ�. NULL ���� �����Ѵ�.
-- 3) MAX() : �ִ밪�� ���ϴ� �Լ�.
-- 4) MIN() : �ּҰ��� ���ϴ� �Լ�.
-- 5) SUM() : ������ ���ϴ� �Լ�.

-- emp ���̺��� ����� ������ �ִ� ��� ����� ���� ���.
SELECT COUNT(empno) FROM EMP;

-- [����1] emp ���̺��� ������(mgr)�� ���� ���.
SELECT COUNT(DISTINCT mgr) AS "������ ��" FROM emp;

-- [����2] emp ���̺��� ���ʽ��� ���� ����� ���� ���.
SELECT COUNT(COMM) FROM emp;

-- [����3] emp ���̺��� ��� salesman�� �޿� ��հ� �޿� �ְ��, �޿� �ּҾ�, �޿� �հ�� ���.
SELECT AVG(sal) AS "�޿� ��վ�", MAX(sal) AS "�޿� �ְ��",
       MIN(sal) AS "�޿� �ּҾ�", SUM(SAL) AS "�޿� �հ��"
FROM emp
WHERE job = 'SALESMAN';

-- [����4] emp ���̺��� ��ϵǾ� �ִ� ����� �� ��, ���ʽ��� NULL�� �ƴ� �ο�����
-- ���ʽ��� ���, ��ϵǾ� �ִ� �μ��� �� ���
SELECT COUNT(empno), COUNT(comm), AVG(comm), COUNT(DISTINCT deptno) 
FROM EMP;

-- ������(SEQUENCE)
-- ������ �ο��� �� ����ϴ� ����.
-- ����) CREATE SEQUENCE ������ �̸� START WITH 1 INCREMENT BY 1

CREATE TABLE memo(
    bunho NUMBER(5),                    -- �޸� �۹�ȣ
    title VARCHAR2(100) NOT NULL,       -- �޸� ������
    writer VARCHAR2(50) NOT NULL,       -- �޸� �ۼ���
    content VARCHAR2(1000) NOT NULL,    -- �޸� �۳���
    regdate DATE,                       -- �޸� �ۼ���
    PRIMARY KEY(bunho)
);

-- �޸� �ۼ��� ����� �������� ����� ����.
CREATE SEQUENCE memo_seq START WITH 1 INCREMENT BY 1;

-- memo ���̺� �����͸� �����غ���.
INSERT INTO memo VALUES(memo_seq.NEXTVAL, '�޸�1', 'ȫ�浿', '�浿�� ��', SYSDATE);
INSERT INTO memo VALUES(memo_seq.NEXTVAL, '�ι�° �޸�', '�̼���', '���Ŵ� ��', SYSDATE);
INSERT INTO memo VALUES(memo_seq.NEXTVAL, '�޸�3', '������', '���� ��', SYSDATE);
INSERT INTO memo VALUES(memo_seq.NEXTVAL, '�޸�4', '������', '���Ŵ� ��', SYSDATE);
INSERT INTO memo VALUES(memo_seq.NEXTVAL, '�޸�5', '�迬��', '���ƴ� ��', SYSDATE);