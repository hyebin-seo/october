-- Ʈ�����(transaction)
-- ������ ó���� �� ������ ����
-- ����Ŭ���� �߻��ϴ� ���� ���� SQL ��ɹ����� �ϳ��� ������ �۾� ������ ó���ϴ� ��
-- ALL OR NOTHING ������� ó����.
-- ��ɾ� ���� ���� ������ ���������� ó���� �Ǹ� �����ϰ�, ���� ���� ��ɾ� �߿��� �ϳ��� ����̶� �߸��Ǹ� ��ü ���.
-- Ʈ����� ��� ���� : �������� �ϰ����� �����ϸ鼭 �������� �������� �����ϱ� ���� ���.
-- Ʈ����� ��� �� Ʈ����� �����ϱ� ���� ��ɾ�.

-- 1) COMMIT : ��� �۾��� ���������� ó���ϰڴٰ� Ȯ���ϴ� ��ɾ�.
-- Ʈ�����(INSERT, UPDATE, DELETE) �۾� ������ ���� DB�� �ݿ�. ������ �ִ� �����Ϳ� UPDATE ���� �߻�.
-- ��� ����ڰ� ����� �������� ����� �� �� ����.
-- 2) ROLLBACK : �۾� �߿� ������ �߻����� �� Ʈ����� ó�� �������� �߻��� ��������� ����Ͽ� ���� ���·� �ǵ����� ��ɾ�.
-- Ʈ�����(INSERT, UPDATE, DELETE) �۾� ������ �����. ������ COMMIT�� �������� ���� ��.

-- 1. DEPT ���̺��� �����Ͽ� DEPT_01 ���̺��� �����غ���.
CREATE TABLE DEPT_O1
AS
SELECT * FROM DEPT;

-- 2. DEPT_01 ���̺��� ������ �����غ���.
DELETE FROM DEPT_O1;

-- 3. �̶� ���� �μ���ȣ�� 20���� �μ��� ���ؼ��� �����ϰ� �;��µ� �߸��ؼ� ��ü�� ������ ���, �����Ͱ� �����Ǿ� ã�� ���� ����.
ROLLBACK;

-- 4. 20�� �μ��� �����غ���.
DELETE FROM DEPT_O1 WHERE DEPTNO = 20;

COMMIT;

-- SAVAPOINT : Ʈ������� �۰� �����ϴ� ��
-- ����ڰ� Ʈ����� �߰� �ܰ迡�� ����Ʈ�� �����Ͽ� Ʈ����� ���� Ư�� SAVEPOINT���� ROLLBACK�� �� �� �ְ� �ϴ� ��

-- 1. DEPT ���̺��� �����Ͽ� DEPT_02���̺��� ����� ����.
CREATE TABLE DEPT_02
AS
SELECT * FROM DEPT;

-- 2. DEPT_02 ���̺��� 40�� �μ��� ������ �Ŀ� COMMIT�� �غ���.
DELETE FROM DEPT_02 WHERE DEPTNO = 40;

COMMIT;

-- 3. DEPT_02 ���̺��� 30�� �μ��� �����غ���.
DELETE FROM DEPT_02 WHERE DEPTNO = 30;

-- 4. �� �� SAVEPOINT C1�� ������ ����.
SAVEPOINT C1;

-- 5. �μ���ȣ�� 20���� �μ��� ������ ����.
DELETE FROM DEPT_02 WHERE DEPTNO = 20;

-- 6. SAVEPOINT C2�� ����� ����.
SAVEPOINT C2;

-- 7. ���������� �μ���ȣ�� 10���� �μ��� ������ ����.
DELETE FROM DEPT_02 WHERE DEPTNO = 10;

-- 8. �μ���ȣ�� 20���� �μ��� �����ϱ� �ٷ� ������ �ǵ�����.
-- ROLLBACK�� �̿��ϸ� Ư�� �������� �ǵ��ư��� ��.
ROLLBACK TO C1;

-- PL/SQL(PROCEDUAL LANGUAGE / SQL)
-- SQL �����δ� ������ ��ưų� ���� �Ұ����� �۾��� �����ϱ� ���� ����Ŭ���� �����ϴ� ���α׷��� ���
-- �Ϲ� ���α׷��� ������� ��ҵ��� �� ������ ������ �����ͺ��̽� ������ ó���ϱ� ���� ����ȭ�� ���.
-- ����, ���� ó��, �ݺ� ó�� �� �پ��� ����� ����� �� ����.

-- �⺻ ����
-- 1) �����(DECLARE) : ��� ������ ����� �����ϴ� �κ�.
-- 2) �����(EXCUTABLE) : ���� ������ ����Ǵ� �κ�. ���(���ǹ�), �ݺ���, �Լ����� ���� ������ ����ϴ� �κ�.
-- 3) ����ó����(EXCEPTION) : ���� ���� ���ܰ� �߻� �� �ذ��ϱ� ���� ��ɵ��� ����ϴ� �κ�.
-- �� �⺻ ���� �߿��� ����ο� ����ó���δ� ������ ����������, ����δ� �ݵ�� ����(���) �ؾ� ��.

-- PL/SQL ��� �� ���ǻ���.
-- 1. �⺻ ����(DECLARE, BEGIN, EXCEPTION) Ű���� �ڿ��� �����ݷ�(;)�� ������ �ʴ´�.
-- 2. ���� �� �κп��� �����ؾ� �ϴ� ���� ������ �����ݷ�(;)�� ���δ�.
-- 3. BEGIN - END(�����) �ؿ��� �ݵ�� "/"�� �ٿ��� �Ѵ�.

-- PL/SQL�� �̿��Ͽ� "HELLO PL/SQL!!"�̶�� ������ ȭ�鿡 ����� ����.
-- ȭ�鿡 ��±���� Ȱ��ȭ ��Ű��.
SET SERVEROUTPUT ON;

BEGIN
    dbms_output.put_line('HELLO PL/SQL!!');
END;
/

-- �����(DECLARE) ������ ������ �����ϴ� ���.
-- 1) ��Į�� �ڷ��� : ����) ������ �ڷ���(ũ��);
-- ��) NUM NUMBER(3); / NAME VARCHAR2(20);

DECLARE
    V_EMPNO NUMBER(4) := 7700;
    V_ENAME VARCHAR2(20);
BEGIN
    V_ENAME := 'ADAMS';
    dbms_output.put_line('V_EMPNO >>> ' || V_EMPNO);
    dbms_output.put_line('V_ENAME >>> ' || V_ENAME);
END;
/

-- 2) ���۷��� �ڷ��� : ����) ������ ���̺��.�÷���%TYPE;
-- ��) NUM EMP.EMPNO%TYPE;
-- ���̺� ���ǵ� �÷��� �ڷ����� ũ�⸦ ��� �ľ��ϰ� �ִٸ� �� ������ ��������,
-- ��κ��� �׷��� ���ϱ� ������ ����Ŭ������ ���۷���(REFERENCE) ������ �������ְ� ����.

DECLARE
    V_EMPNO EMP.EMPNO%TYPE := 7693;
    V_ENAME EMP.ENAME%TYPE;
BEGIN
    V_ENAME := 'SCOTT';
    DBMS_OUTPUT.PUT_LINE('V_EMPNO >>> ' || V_EMPNO);
    DBMS_OUTPUT.PUT_LINE('V_ENAME >>> ' || V_ENAME);
END;
/

-- 3) ROWTYPE
-- ���̺��� ��� �÷��� �Ѳ����� �����ϱ� ���� ������ �����ϴ� ���.

DECLARE
    EMP_ROW EMP%ROWTYPE;
BEGIN
    SELECT * INTO EMP_ROW FROM EMP WHERE EMPNO = 7698;
    DBMS_OUTPUT.PUT_LINE(EMP_ROW.EMPNO||' '||EMP_ROW.ENAME
                        ||' '||EMP_ROW.JOB||' '||EMP_ROW.SAL
                        ||' '||EMP_ROW.DEPTNO);
END;
/

-- ���� ���
-- Ư�� ���ǽ��� ���� ��Ȳ�� ���� ������ ������ �޸��ϴ� ����� ��ɾ ����.

-- 1. IF ���ǹ�
-- 1) IF~THEN : Ư�� ������ �����ϴ� ��쿡 �۾��� ����.
--        ����) IF ���ǽ� THEN
--                ���ǽ��� ���� ��� ���� ����;
--             END IF
-- 2) IF~THEN~ELSE : Ư�� ���ǿ� �����ϴ� ���� �ݴ��� ��쿡 ���� ������ �۾��� ����.
--        ����) IF ���ǽ� THEN
--                ���ǽ��� ���� ��� ���� ����;
--             ELSE
--                ���ǽ��� ������ ��� ���� ����.
--             END IF
-- 3) IF~THEN~ELSIF : ���� ���ǿ� ���� ���� ������ �۾��� ����.
--        ����) IF ���ǽ�1 THEN
--                ���ǽ�1�� ���� ��� ���� ����;
--             ELSIF ���ǽ�2 THEN
--                ���ǽ�1�� �����̰�, ���ǽ�2�� ���� ��� ���� ����.
--             ELSIF ���ǽ�3 THEN
--                ���ǽ�1,2�� �����̰�, ���ǽ�2�� ���� ��� ���� ����.
--             ELSE
--                ���ǽ�1,2,3�� ������ ��� ���� ����.
--             END IF

-- 1) IF~THEN ����
DECLARE
    V_NUMBER NUMBER(3) := 15;
BEGIN
    IF V_NUMBER >= 10 THEN
        DBMS_OUTPUT.PUT_LINE(V_NUMBER || '�� 10���� ū ���Դϴ�.');
    END IF;
END;
/

-- 2) IF~THEN~ELSE ����
DECLARE
    V_SCORE NUMBER(3) := 38;
BEGIN
    IF MOD(V_SCORE,2) = 1 THEN
        DBMS_OUTPUT.PUT_LINE(V_SCORE || '�� Ȧ���Դϴ�.');
    ELSE
        DBMS_OUTPUT.PUT_LINE(V_SCORE || '�� ¦���Դϴ�.');
    END IF;
END;
/

-- 3) IF~THEN~ELSIF ����
DECLARE
    V_AVG NUMBER(5,2) := 89.12;
BEGIN
    IF V_AVG >= 90 THEN
        DBMS_OUTPUT.PUT_LINE('A�����Դϴ�.');
    ELSIF V_AVG >= 80 THEN
        DBMS_OUTPUT.PUT_LINE('B�����Դϴ�.');
    ELSIF V_AVG >= 70 THEN
        DBMS_OUTPUT.PUT_LINE('C�����Դϴ�.');
    ELSIF V_AVG >= 60 THEN
        DBMS_OUTPUT.PUT_LINE('D�����Դϴ�.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('F�����Դϴ�.');
    END IF;
END;
/

-- 2. CASE ���ǹ�
-- ����) CASE �� ����
--         WHEN ��1 THEN
--          ������ ��ɾ�;
--         WHEN ��2 THEN
--          ������ ��ɾ�;
--         WHEN ��3 THEN
--          ������ ��ɾ�;
--         ELSE
--          ��1, ��2, ��3�� �ƴ� ��� ������ ��ɾ�;
--      END CASE;

DECLARE
    V_SCORE NUMBER(3) := 92;
BEGIN
    CASE TRUNC(V_SCORE / 10)
        WHEN 10 THEN
            DBMS_OUTPUT.PUT_LINE('A�����Դϴ�.');
        WHEN 9 THEN
            DBMS_OUTPUT.PUT_LINE('A�����Դϴ�.');
        WHEN 8 THEN
            DBMS_OUTPUT.PUT_LINE('B�����Դϴ�.');
        WHEN 7 THEN
            DBMS_OUTPUT.PUT_LINE('C�����Դϴ�.');
        WHEN 6 THEN
            DBMS_OUTPUT.PUT_LINE('D�����Դϴ�.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('F�����Դϴ�.');
    END CASE;
END;

-- �ݺ� ���
-- Ư�� �۾��� �ݺ��Ͽ� �����ϰ��� �� �� ����ϴ� ����.
-- �ݺ� ����� ����
-- 1) �⺻ LOOP
-- 2) WHILE LOOP
-- 3) FOR LOOP

-- �ݺ����� �ݺ� ������ �����Ű�� ����.
-- 1) EXIT : ���� ���� �ݺ��� �����Ű�� ��ɾ�
-- 2) EXIT-WHEN : �ݺ� ���Ḧ ���� ���ǽ��� �����ϰ� �����ϸ� �ݺ� ����
-- 3) CONTINUE : �������� �ݺ��� ���� �ֱ⸦ �ǳ� ��
-- 4) CONTINUE-WHEN : Ư�� ���ǽ��� �����ϰ� ���ǽ��� �����ϸ� �ݺ� �ֱ⸦ �ǳ� ��

-- �⺻ LOOP �� ����� ����.
DECLARE
    V_NUM NUMBER(3) := 1;
BEGIN
    LOOP
        DMBS_OUTPUT.PUT_LINE('V_NUM >>>' || V_NUM);
        V_NUM := V_NUM + 1;
        IF V_NUM > 100 THEN
            EXIT;
        END IF;
    END LOOP;
END;
/

-- 2) WHILE LOOP ����
DECLARE
    V_NUMBER NUMBER(3) := 1;
BEGIN
    DBMS_OUTPUT.PUT_LINE('WHILE LOOP ��¹�');
    WHILE V_NUMBER <= 100 LOOP
        DBMS_OUTPUT.PUT_LINE('V_NUMBER >>> ' || V_NUMBER);
        V_NUMBER := V_NUMBER + 1;
    END LOOP;
END;
/

-- FOR LOOP ����
DECLARE
    V_SUM NUMBER(5) := 0;
BEGIN
    DBMS_OUTPUT.PUT_LINE('FOR LOOP ��¹�');
    FOR V_NUM IN 1 .. 100 LOOP
        V_SUM := V_SUM + V_NUM;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('1~100������ �� >>> ' || V_SUM);
END;
/

-- Ű����� �����͸� �Է¹޴� ���
DECLARE
    V_NUM1 NUMBER(3);
    V_NUM2 NUMBER(3);
BEGIN
    V_NUM1 := '&NUM1';
    V_NUM2 := '&NUM2';
    DBMS_OUTPUT.PUT_LINE(V_NUM1||' + '||V_NUM2||' >>> '||(V_NUM1+V_NUM2));
END;
/

-- TEST��� ���̺��� ����� ����.
CREATE TABLE TEST(
    NO NUMBER(3) PRIMARY KEY,
    NAME VARCHAR2(20) NOT NULL,
    ADDR VARCHAR2(100) NOT NULL
);

DECLARE
    NO TEST.NO%TYPE;
    NAME TEST.NAME%TYPE;
    ADDR TEST.ADDR%TYPE;
BEGIN
    NO := '&NO';
    NAME := '&NAME';
    ADDR := '&ADDR';
    
    INSERT INTO TEST VALUES(NO, NAME, ADDR);
    
    DBMS_OUTPUT.PUT_LINE('��ȣ / �̸� / �ּ�');
    DBMS_OUTPUT.PUT_LINE('=============================');
    DBMS_OUTPUT.PUT_LINE(NO || ' / ' || NAME || ' / ' || ADDR);
END;
/