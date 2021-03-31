-- join ~ on Ű����.
-- ���̺�� ���̺��� �����Ͽ� Ư���� �����͸� ����� �� �� ���.
-- �� �� �̻��� ���̺� ������ �������� ���� �� ���.
-- �ߺ��ؼ� �����Ͱ� ����Ǵ� ���� ���� ����.
-- emp ���̺��� �μ��� �� �������� ������ �Ѵٸ� 10�� �μ��� �Ҽӵ� ����� 3���̹Ƿ� �μ���� �ٹ����� 3�� �ߺ��� �Ǿ� ���� ��.
-- �ߺ��Ǿ� ����� �����ʹ� ���� ����, ����, ���� �� �̻� ������ �߻��� �� �ְ� ��.
-- ��, �̷��� ������ �߻����� �ʰ� �Ϸ���(�����Ͱ� �ߺ����� �ʰ� �Ϸ���) �����ͺ��̽����� �� �� �̻��� ���̺� ������ ������ �����ؾ� ��.
-- ������ �̷��� �ΰ��� ���̺�� ������ �Ǹ� �������� �ߺ��� �߻����� ������ ���ϴ� ������ �������� ���� �� ���Ǹ� �ؾ��ϴ� �������� �߻���.
-- Ư�� ����� �Ҽӵ� �μ����� �˾Ƴ��� ���� emp ���̺�� dept���̺��� �ѳ���� �۾��� ����.
-- ���� �� ���� ���̺��� �����ؼ� ���ϴ� ����� �� �� �ֵ��� �ϴ� �����̶�� ����� ������.

-- ������ ����
-- 1) Cross Join
-- 2) Equi Join
-- 3) Self Join
-- 4) Outer Join

-- 1) Cross Join
-- �� �� �̻��� ���̺��� ���ε� �� ������ ���� ���̺��� ������ �̷������ ����.
-- �׷��� ������ ���̺� ��ü ���� �÷��� ������ ��.
SELECT *
FROM emp, dept;

-- 2) Equi Join
-- ���� ���� ���Ǵ� ���� ���.
-- ������ ����� �Ǵ� �� ���̺��� ���������� �����ϴ� �÷��� ���� ��ġ�Ǵ� ���� �����Ͽ� ����� �����ϴ� ���.
-- �� ���̺��� �����Ϸ��� ��ġ�Ǵ� ���� �÷��� ����ϸ� �ȴ�.
-- �÷��� �̸��� ������ ȥ���� ���� ������ �÷��� �տ� ���̺���� ����ؾ� �Ѵ�.

-- emp ���̺��� ����� ���, �̸�, ������, �μ���ȣ, �μ���, �ٹ���ġ�� ȭ�鿡 ���.
-- ==> emp ���̺�� dept ���̺��� �������־�� ��.
SELECT e.empno, e.ename, e.job, d.deptno, d.dname, d.loc -- ������� ���� �÷��� ���̺��(��Ī) ���� ����
FROM emp e JOIN dept d
ON e.deptno = d.deptno;

-- emp ���̺��� ������� 'SCOTT'�� ����� �μ����� �˰� ���� ���
SELECT ename, d.deptno, dname
FROM emp e JOIN dept d
on e.deptno = d.deptno
WHERE ename = 'SCOTT';

-- [����1] �μ����� 'RESEARCH'�� ����� ���, �̸�, �޿�, �μ���, �ٹ���ġ�� ���
SELECT empno, ename, sal, dname,loc
FROM emp e JOIN dept d
on e.deptno = d.deptno
WHERE dname = 'RESEARCH';

-- [����2] emp ���̺��� 'NEW YORK'�� �ٹ��ϴ� ����� �̸��� �޿�, �μ���ȣ�� ���
SELECT ename, sal, d.deptno, loc
FROM emp e JOIN dept d
on e.deptno = d.deptno
WHERE loc = 'NEW YORK';

-- [����3] emp ���̺��� 'ACCOUNTING'�μ� �Ҽ� ����� �̸��� ������, �Ի���, �μ���ȣ, �μ����� ���
SELECT ename, job, hiredate, d.deptno, dname
FROM emp e JOIN dept d
on e.deptno = d.deptno
WHERE dname = 'ACCOUNTING';

-- [����4] emp ���̺��� �������� 'MANAGER'�� ����� �̸��� �μ����� ���
SELECT ename, dname
FROM emp e JOIN dept d
on e.deptno = d.deptno
WHERE job = 'MANAGER';

-- 3) Self Join
-- �ϳ��� ���̺� ������ ������ �ؾ� �ڷḦ ���� �� �ִµ� �ڱ� �ڽ� ���̺�� ������ �δ� ���� ����.
-- FROM�� ������ ���̺���� ������ �� �� ����� �� ����.
-- ���� ���� ���̺��� �ϳ� �� �����ϴ� ��ó�� ����� �� �ֵ��� ���̺� ��Ī�� �ٿ��� ���.

-- emp ���̺��� �� ����� �������� �̸��� ȭ�鿡 ����� ����.
-- ��) CLARK�� �Ŵ��� �̸��� KING �Դϴ�.
SELECT e1.ename || '�� �Ŵ��� �̸��� ' || e2.ename || ' �Դϴ�.'
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno;

-- emp ���̺��� �Ŵ����� KING�� ������� �̸��� �������� ȭ�鿡 �����ּ���.
SELECT e1.ename, e1.job
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno AND e2.ename = 'KING';

-- 4) Outer ����
-- 2�� �̻��� ���̺��� ������ �� �� ��� �� �� ���̺��� �ش��ϴ� �����Ͱ� �ٸ��� ���̺��� �������� �ʴ� ���
-- �� �����Ͱ� ����� ���� �ʴ� �������� �ذ��ϱ� ���� ���Ǵ� ���� ���.
-- ������ ������ ���̺��� �÷� �ڿ� '(+)'��ȣ�� �ٿ��� �����.
SELECT e1.ename || ' �� �Ŵ��� �̸��� ' || e2.ename || ' �Դϴ�.'
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno(+); -- NULL���� �����ϱ� ����

SELECT ename, d.deptno, dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;


-- dual ���̺�
-- ����Ŭ���� ��ü������ �������ִ� ���̺�
-- �����ϰ� �Լ��� �̿��ؼ� ���, ������� Ȯ���� �� ����ϴ� ���̺�.
-- ���� �� ��, �� �÷� ���� ��� �ִ� ���̺�.
-- ��� �뵵 : Ư�� ���̺��� ������ �ʿ� ���� �Լ� �Ǵ� ����� �ϰ��� �� �� ���

-- ����Ŭ���� �������ִ� �Լ���

-- 1. ��¥�� ���õ� �Լ���
--  1) ���� �ý����� ��¥�� ���� ���� �Լ� : sysdate
SELECT SYSDATE FROM DUAL;
--  2) ���� ��¥���� ���� ���� ���� �ִ� �Լ� : ADD_MONTHS(���� ��¥, ����(������));
SELECT ADD_MONTHS(SYSDATE, 3) FROM DUAL;
--  3) �ٰ��� ��¥(����)�� �����ִ� �Լ� : NEXT_DAY(���� ��¥,'����');
SELECT NEXT_DAY(SYSDATE, 'ȭ����') FROM DUAL;
--  4) ���Ŀ� �°� ���ڿ��� ��¥�� ����ϴ� �Լ� : TO_CHAR(��¥, '��¥����');
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MM/DD/YYYY') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YY-MM-DD') FROM DUAL;

-- 2. ���ڿ� ���õ� �Լ���
--  1) ���ڿ��� �����ϴ� �Լ� : CONCAT('���ڿ�1','���ڿ�2');
SELECT CONCAT('�ȳ�','�ϼ���') FROM DUAL;
--     ���ڿ��� �����ϴ� ������ : ||
SELECT '�氡' || '�氡' FROM DUAL;
--  2) �ҹ��ڸ� �빮�ڷ� �ٲپ� �ִ� �Լ� : UPPER()
SELECT UPPER('happy day') FROM DUAL;
--  3) �빮�ڸ� �ҹ��ڷ� �ٲپ� �ִ� �Լ� : LOWER()
SELECT LOWER('HELLO WORLD') FROM DUAL;
--  4) ���ڿ��� X���� Y�� ���̸�ŭ ������ ���� �Լ� : SUBSTR('���ڿ�', X, Y)
SELECT SUBSTR('ABCDEFG', 3, 2) FROM DUAL; -- CD
SELECT SUBSTR('ABCDEFG', -3, 2) FROM DUAL; -- EF -�� ���̸� �ڿ������� ����
--  5) �ڸ����� �÷��ִ� �Լ�
--     ���� �ڸ����� �÷��ִ� �Լ� : LPAD('���ڿ�', ��ü �ڸ���, '�þ �ڸ����� �� ���ڿ�')
SELECT LPAD('ABCDEFG', 15, '*') FROM DUAL;
--     ������ �ڸ����� �÷��ִ� �Լ� : RPAD('���ڿ�', ��ü �ڸ���, '�þ �ڸ����� �� ���ڿ�')
SELECT RPAD('ABCDEFG', 15, '*') FROM DUAL;
--  6) ���ڸ� �����ִ� �Լ�
--     ���� ���ڸ� �����ִ� �Լ� : LTRIM()
SELECT LTRIM('ABCDEFG', 'A') FROM DUAL;
--     ������ ���ڸ� �����ִ� �Լ� : RTRIM()
SELECT RTRIM('ABCDEFG', 'FG') FROM DUAL;
--  7) ���ڿ��� ��ü���ִ� �Լ� : REPLACE()
--     ����) REPLACE('���� ���ڿ�','��ü�� ���ڿ�','���ο� ���ڿ�')
SELECT REPLACE('Java Program', 'Java', 'JSP') FROM DUAL;

-- [����1] emp ���̺��� ����� �Ʒ��� ���� �������� ���
-- ���) 'SCOTT�� �������� ANALYST �Դϴ�.'
-- ��, CONCAT() �Լ� �̿�.
SELECT CONCAT(CONCAT(ename, '�� �������� '),CONCAT(job, ' �Դϴ�.'))
FROM emp
WHERE ename = 'SCOTT';

-- [����2] emp ���̺��� ����� �Ʒ��� ���� �������� ���
-- ���) 'SCOTT�� ������ 36000 �Դϴ�.'
-- ��, CONCAT() �Լ� �̿�.
SELECT CONCAT(CONCAT(ename, '�� ������ '),CONCAT(sal, ' �Դϴ�.'))
FROM emp
WHERE ename = 'SCOTT';

-- [����3] member10 ���̺��� ����� �Ʒ��� ���� �������� ���
-- ���) 'ȫ�浿 ȸ���� ������ �л��Դϴ�.'
-- ��, CONCAT() �Լ� �̿�.
SELECT CONCAT(CONCAT(memname, ' ȸ���� ������ '),CONCAT(job, '�Դϴ�.'))
FROM member10
WHERE memname = 'ȫ�浿' AND job = '�л�' ;

-- [����4] emp ���̺��� ���, �̸�, ������ ���
-- ��, �������� �ҹ��ڷ� ����
SELECT empno, ename, LOWER(job) FROM emp;

-- [����5] �ֹε�Ϲ�ȣ �߿��� ��������� �����Ͽ� ȭ�鿡 ���.
SELECT SUBSTR('941018-2000000', 0, 6) FROM DUAL;

-- [����6] emp ���̺��� �������� 'A'��� ���ڸ� 'S'�� �ٲپ� ���
SELECT REPLACE(job, 'A', 'S') FROM emp;

-- [����7] member10 ���̺��� ������ '�л�'�� ������ '���л�'���� �ٲپ� ���
SELECT REPLACE(job, '�л�', '���л�') FROM member10;

-- [����8] member10 ���̺��� �ּҿ� '�����'�� �� ������ '����Ư����'�� �ٲپ� ���
SELECT REPLACE(ADDR, '�����', '����Ư����') FROM member10;


-- 3. ���ڿ� ���õ� �Լ���
-- 1) ���밪�� ���ϴ� �Լ� : ABS(����)
SELECT ABS(23) FROM DUAL;
SELECT ABS(-23) FROM DUAL;
-- 2) ���(1), ����(-1), 0�� ��ȯ�� �ִ� �Լ� : SIGN(����)
SELECT SIGN(23) FROM DUAL;
SELECT SIGN(23), SIGN(-23), SIGN(0) FROM DUAL;
-- 3) �ݿø��� �� �ִ� �Լ� : ROUND(�Ǽ�)
SELECT ROUND(0.123) FROM DUAL;
SELECT ROUND(0.523) FROM DUAL;
--    �ݿø� �� �� �ڸ��� ����
SELECT ROUND(0.1234567, 6) FROM DUAL;
SELECT ROUND(2.3423466, 4) FROM DUAL;
-- 4) �Ҽ��� ���� �ڸ����� �߶󳻴� �Լ� : TRUNC()
SELECT TRUNC(1234.1234567, 0) FROM DUAL;
SELECT TRUNC(1234.1234567, 4) FROM DUAL;
SELECT TRUNC(1234.1234567, -3) FROM DUAL; -- ������(�Ҽ��� ��)�� �߶󳻶�� �ǹ�
-- 5) ������ �ø��� ���ִ� �Լ� : CEIL()
SELECT CEIL(22.8) FROM DUAL;
SELECT CEIL(22.1) FROM DUAL;
-- 6) ������ �����ִ� �Լ� : POWER()
SELECT POWER(4,3) FROM DUAL;
-- 7) �������� �����ִ� �Լ� : MOD()
SELECT MOD(7,4) FROM DUAL;
-- 8) �������� �����ִ� �Լ� : SQRT()
SELECT SQRT(3) FROM DUAL;
SELECT SQRT(16) FROM DUAL;

