-- ���� ����
-- �ϳ��� ������ �ȿ� ���ԵǾ� �ִ� �� �ϳ��� �������� ����.
-- ���������� ���������� ���������� �����ϴ� �������� ������.
-- ������ ������ �����ؼ� ������ �ִ� ����� �ϳ��� ��ø�� ���� �������� ����� ���� �� �ְ� ����.
-- ���ǻ���
--1) ���������� ��ȣ�� ��� ����ؾ���.
--2) �������� �ȿ����� ORDER BY ���� ����� �� ����.
--3) ������ �����ʿ� ����ؾ� ��.
-- ����� : �켱�� ���ʿ� �ִ� �������� ���� ��, �� ������� ������ �ٱ��� �������� ���� 

-- emp ���̺��� �̸��� 'SCOTT'�� ����� �޿����� �� ���� �޿��� �޴�
-- ����� ���, �̸�, ������, �޿��� ȭ�鿡 �����ּ���.

SELECT empno, ename, job, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'SCOTT');

-- [����1] emp ���̺��� ��� �޿����� �� ���� �޴� ����� ���, �̸�, ������, �޿�, �μ���ȣ ���
SELECT EMPNO, ENAME, JOB, SAL, DEPTNO
FROM EMP
WHERE SAL < (SELECT AVG(SAL) FROM EMP);

-- [����2] emp ���̺��� ����� 7521�� ����� �������� ����,
-- �޿��� 7934�� ������� �� ���� �޴� ����� ���, �̸�, ������, �޿� ���
SELECT EMPNO, ENAME, JOB, SAL
FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE EMPNO = 7521)
AND SAL > (SELECT SAL FROM EMP WHERE EMPNO = 7934);

-- [����3] emp ���̺��� �������� 'MANAGER'�� ����� �ּұ޿����� �����鼭
-- �������� 'CLERK'�� �ƴ� ����� ���, �̸�, ������, �޿� ���
SELECT EMPNO, ENAME, JOB, SAL
FROM EMP
WHERE JOB != 'CLERK' 
AND SAL < (SELECT MIN(SAL) FROM EMP WHERE JOB = 'MANAGER');

-- [����4] �μ���ġ�� 'DALLAS'�� ����� ���, �̸�, �μ���ȣ, ������ ���
SELECT EMPNO, ENAME, DEPTNO, JOB
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS'); -- 20���μ�

-- [����5] member10 ���̺� �ִ� ���� ���� �� ���ϸ����� ���� ���� ���� ��� ���� ���
SELECT *
FROM MEMBER10
WHERE MILEAGE = (SELECT MAX(MILEAGE) FROM MEMBER10);

-- [����6] emp ���̺��� 'SMITH'�� ������� �� ���� �޿��� �޴� ����� �̸�, �޿� ���
SELECT ENAME, SAL
FROM EMP
WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'SMITH');

-- [����7] emp ���̺��� 10�� �μ� �޿��� ��� �޿����� ���� �޿��� �޴�
-- ������� �̸�, �޿�, �μ���ȣ ���
SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE SAL < (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = '10');

-- [����8] emp ���̺��� 'BLAKE'�� ���� �μ��� �ִ� ������� �̸�, �Ի�����, �μ���ȣ ����ϵ�
-- 'BLAKE'�� �����ϰ� ȭ�鿡 ���
SELECT ENAME, HIREDATE, DEPTNO
FROM EMP
WHERE ENAME != 'BLAKE'
AND DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE');

-- [����9] emp ���̺��� ��� �޿����� �� ���� �޴� ������� ���, �̸�, �޿��� ȭ�鿡 ����ϵ�
-- �޿��� �������� ���� ������ ȭ�鿡 ���
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP)
ORDER BY SAL DESC;

-- [����10] emp ���̺��� �̸��� 'T'�� �����ϰ� �ִ� ������ ���� �μ��� �ٹ��ϰ� �ִ�
-- ����� ���, �̸�, �μ���ȣ ���
SELECT EMPNO, ENAME, DEPTNO
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%');

-- [����11] 'SALES' �μ����� �ٹ��ϰ� �ִ� ������� �μ���ȣ, �̸�, ������ ���
SELECT DEPTNO, ENAME, JOB
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');

-- [����12] emp���̺��� 'KING'���� �����ϴ� ��� ����� �̸�, �޿�, ������ ���
SELECT ENAME, SAL, MGR
FROM EMP
WHERE MGR = (SELECT DISTINCT EMPNO FROM EMP WHERE ENAME = 'KING');

-- [����13] emp ���̺��� �ڽ��� �޿��� ��� �޿����� ����, �̸��� 'S'�ڰ� ���� �����
-- ������ �μ����� �ٹ��ϴ� ��� ����� ���, �̸�, �޿�, �μ���ȣ ���
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO
                   FROM EMP
                   WHERE ENAME LIKE '%S%' 
                   AND SAL > (SELECT AVG(SAL) FROM EMP));

-- [����14] emp ���̺��� ���ʽ��� �޴� ����� �μ���ȣ, �޿��� ���� ����� �̸�, �޿�, �μ���ȣ ���
SELECT ENAME, SAL, DEPTNO, COMM
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE COMM > 0)
AND SAL IN (SELECT SAL FROM EMP WHERE COMM > 0);

-- [����15] products ���̺��� ��ǰ�� �ǸŰ����� �ǸŰ����� ��պ��� ū ��ǰ�� ��ü ���� ���
SELECT *
FROM PRODUCTS
WHERE OUTPUT_PRICE > (SELECT AVG(OUTPUT_PRICE) FROM PRODUCTS);

-- [����16] products ���̺� �ִ� �ǸŰ��ݿ��� ��� ���� �̻��� ��ǰ ����� ���ϵ�,
-- ����� ���� �� ������ ���� ū �ݾ��� ��ǰ�� �����ϰ� ����� ���Ͽ� ���
SELECT *
FROM PRODUCTS
WHERE OUTPUT_PRICE >(SELECT AVG(OUTPUT_PRICE)
                       FROM PRODUCTS 
                       WHERE OUTPUT_PRICE <>  (SELECT MAX(OUTPUT_PRICE) 
                                                FROM PRODUCTS));


-- [����17] products ���̺��� ī�װ��� �̸��� '������' �̶�� �ܾ ���Ե�
-- ī�װ��� ���ϴ� ��ǰ��� ���
SELECT *
FROM PRODUCTS
WHERE CATEGORY_FK IN 
(SELECT CATEGORY_CODE FROM CATEGORY WHERE CATEGORY_NAME LIKE '%������%');

-- [����18] member10 ���̺� �ִ� �� ���� �� ���ϸ����� ���� ���� �ݾ��� ������
-- ������ ���ʽ� ���ϸ��� 5000���� �� �־� ����, ���ϸ���, ���ϸ���+500���� ���
SELECT MEMNAME, MILEAGE, MILEAGE+5000
FROM MEMBER10
WHERE MILEAGE = (SELECT MAX(MILEAGE) FROM MEMBER10);

-- GROUP BY ��
-- Ư���÷��̳� ���� �������� �ش� ���ڵ带 ��� �ڷḦ ������ �� ���
-- ������ Ư�� �÷��� �������� ���踦 ���ϴµ� ���� ���
-- ������ �׷��Լ��� �԰� ����ϸ� ȿ�������� ����� ����

SELECT DEPTNO FROM EMP ORDER BY DEPTNO;

SELECT DEPTNO
FROM EMP
GROUP BY DEPTNO;

-- EMP ���̺��� �μ����� �� �μ��� �ο��� Ȯ���ϰ� ���� ���
SELECT DEPTNO, COUNT(*)
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

-- EMP ���̺��� �μ����� �޿��� �հ踦 ȭ�鿡 �����ּ���.
SELECT DEPTNO, SUM(SAL) "�޿� �հ�"
FROM EMP
GROUP BY DEPTNO
ORDER BY SUM(SAL) DESC;

-- [����] EMP ���̺��� �μ����� �׷��� ��� �μ��� �޿� �հ��
-- �μ��� �ο���, �μ��� ��� �޿�, �μ��� �ִ� �޿�, �μ��� �ּ� �޿��� ���Ͽ� ���
-- ��, �޿��հ踦 �������� ������������ ����
SELECT SUM(SAL) "�޿� �հ�", COUNT(EMPNO) "�ο���",
       AVG(SAL) "��� �޿�", MAX(SAL)"�ִ� �޿�", MIN(SAL) "�ּ� �޿�"
FROM EMP
GROUP BY DEPTNO
ORDER BY SUM(SAL) DESC;

-- HAVING ��
-- GROUP BY �� ������ ���� �������� GROUP BY ���� ����� ������ �־ ������ �� ���
-- GROUP BY ������ WHERE (������)�� �� �� ����.

-- PRODUCTS ���̺��� ī�װ� ���� ��ǰ�� ������ ȭ�鿡 �����ּ���.
SELECT CATEGORY_FK, COUNT(*)
FROM PRODUCTS
GROUP BY CATEGORY_FK
HAVING COUNT(*) >= 2
ORDER BY CATEGORY_FK;
