-- 트랜잭션(transaction)
-- 데이터 처리의 한 단위를 말함
-- 오라클에서 발생하는 여러 개의 SQL 명령문들을 하나의 논리적인 작업 단위로 처리하는 것
-- ALL OR NOTHING 방식으로 처리함.
-- 명령어 여러 개의 집합이 정상적으로 처리가 되면 종료하고, 여러 개의 명령어 중에서 하나의 명령이라도 잘못되면 전체 취소.
-- 트랙잭션 사용 이유 : 데이터의 일관성을 유지하면서 데이터의 안정성을 보장하기 위해 사용.
-- 트랙잭션 사용 시 트랜잭션 제어하기 위한 명령어.

-- 1) COMMIT : 모든 작업을 정상적으로 처리하겠다고 확정하는 명령어.
-- 트랜잭션(INSERT, UPDATE, DELETE) 작업 내용을 실제 DB에 반영. 이전에 있던 데이터에 UPDATE 현상 발생.
-- 모든 사용자가 변경된 데이터의 결과를 볼 수 있음.
-- 2) ROLLBACK : 작업 중에 문제가 발생했을 때 트랙잭션 처리 과정에서 발생한 변경사항을 취소하여 이전 상태로 되돌리는 명령어.
-- 트랜잭션(INSERT, UPDATE, DELETE) 작업 내용을 취소함. 이전에 COMMIT한 곳까지만 복구 됨.

-- 1. DEPT 테이블을 참조하여 DEPT_01 테이블을 복사해보자.
CREATE TABLE DEPT_O1
AS
SELECT * FROM DEPT;

-- 2. DEPT_01 테이블의 내용을 삭제해보자.
DELETE FROM DEPT_O1;

-- 3. 이때 만일 부서번호가 20번인 부서에 대해서만 삭제하고 싶었는데 잘못해서 전체가 삭제된 경우, 데이터가 삭제되어 찾을 수가 없음.
ROLLBACK;

-- 4. 20번 부서만 삭제해보자.
DELETE FROM DEPT_O1 WHERE DEPTNO = 20;

COMMIT;

-- SAVAPOINT : 트랜잭션을 작게 분할하는 것
-- 사용자가 트랜잭션 중간 단계에서 포인트를 지정하여 트랜잭션 내의 특정 SAVEPOINT까지 ROLLBACK을 할 수 있게 하는 것

-- 1. DEPT 테이블을 복사하여 DEPT_02테이블을 만들어 보자.
CREATE TABLE DEPT_02
AS
SELECT * FROM DEPT;

-- 2. DEPT_02 테이블에서 40번 부서를 삭제한 후에 COMMIT을 해보자.
DELETE FROM DEPT_02 WHERE DEPTNO = 40;

COMMIT;

-- 3. DEPT_02 테이블에서 30번 부서를 삭제해보자.
DELETE FROM DEPT_02 WHERE DEPTNO = 30;

-- 4. 이 때 SAVEPOINT C1을 설정해 보자.
SAVEPOINT C1;

-- 5. 부서번호가 20번인 부서를 삭제해 보자.
DELETE FROM DEPT_02 WHERE DEPTNO = 20;

-- 6. SAVEPOINT C2를 만들어 보자.
SAVEPOINT C2;

-- 7. 마지막으로 부서번호가 10번인 부서를 삭제해 보자.
DELETE FROM DEPT_02 WHERE DEPTNO = 10;

-- 8. 부서번호가 20번인 부서를 삭제하기 바로 전으로 되돌리자.
-- ROLLBACK을 이용하면 특정 지점으로 되돌아가게 됨.
ROLLBACK TO C1;

-- PL/SQL(PROCEDUAL LANGUAGE / SQL)
-- SQL 만으로는 구현이 어렵거나 구현 불가능한 작업을 수행하기 위해 오라클에서 제공하는 프로그래밍 언어
-- 일반 프로그래밍 언어적인 요소들을 다 가지고 있으며 데이터베이스 업무를 처리하기 위한 최적화된 언어.
-- 변수, 조건 처리, 반복 처리 등 다양한 기능을 사용할 수 있음.

-- 기본 구조
-- 1) 선언부(DECLARE) : 모든 변수나 상수를 선언하는 부분.
-- 2) 실행부(EXCUTABLE) : 실제 로직이 실행되는 부분. 제어문(조건문), 반복문, 함수정의 등의 로직을 기술하는 부분.
-- 3) 예외처리부(EXCEPTION) : 실행 도중 예외가 발생 시 해결하기 위한 명령들을 기술하는 부분.
-- 위 기본 구조 중에서 선언부와 예외처리부는 생략이 가능하지만, 실행부는 반드시 존재(기술) 해야 함.

-- PL/SQL 사용 시 주의사항.
-- 1. 기본 구조(DECLARE, BEGIN, EXCEPTION) 키워드 뒤에는 세미콜론(;)을 붙이지 않는다.
-- 2. 블럭의 각 부분에서 실행해야 하는 문장 끝에는 세미콜론(;)을 붙인다.
-- 3. BEGIN - END(실행부) 밑에는 반드시 "/"를 붙여야 한다.

-- PL/SQL을 이용하여 "HELLO PL/SQL!!"이라는 내용을 화면에 출력해 보자.
-- 화면에 출력기능을 활성화 시키자.
SET SERVEROUTPUT ON;

BEGIN
    dbms_output.put_line('HELLO PL/SQL!!');
END;
/

-- 선언부(DECLARE) 영역에 변수를 선언하는 방법.
-- 1) 스칼라 자료형 : 형식) 변수명 자료형(크기);
-- 예) NUM NUMBER(3); / NAME VARCHAR2(20);

DECLARE
    V_EMPNO NUMBER(4) := 7700;
    V_ENAME VARCHAR2(20);
BEGIN
    V_ENAME := 'ADAMS';
    dbms_output.put_line('V_EMPNO >>> ' || V_EMPNO);
    dbms_output.put_line('V_ENAME >>> ' || V_ENAME);
END;
/

-- 2) 레퍼런스 자료형 : 형식) 변수명 테이블명.컬럼명%TYPE;
-- 예) NUM EMP.EMPNO%TYPE;
-- 테이블에 정의된 컬럼의 자료형과 크기를 모두 파악하고 있다면 별 문제가 없겠지만,
-- 대부분은 그렇지 못하기 때문에 오라클에서는 레퍼런스(REFERENCE) 변수를 제공해주고 있음.

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
-- 테이블의 모든 컬럼을 한꺼번에 저장하기 위한 변수로 선언하는 방법.

DECLARE
    EMP_ROW EMP%ROWTYPE;
BEGIN
    SELECT * INTO EMP_ROW FROM EMP WHERE EMPNO = 7698;
    DBMS_OUTPUT.PUT_LINE(EMP_ROW.EMPNO||' '||EMP_ROW.ENAME
                        ||' '||EMP_ROW.JOB||' '||EMP_ROW.SAL
                        ||' '||EMP_ROW.DEPTNO);
END;
/

-- 조건 제어문
-- 특정 조건식을 통해 상황에 따라 실행할 내용을 달리하는 방식의 명령어를 말함.

-- 1. IF 조건문
-- 1) IF~THEN : 특정 조건을 만족하는 경우에 작업을 수행.
--        형식) IF 조건식 THEN
--                조건식이 참인 경우 실행 문장;
--             END IF
-- 2) IF~THEN~ELSE : 특정 조건에 만족하는 경우와 반대의 경우에 각자 지정한 작업을 수행.
--        형식) IF 조건식 THEN
--                조건식이 참인 경우 실행 문장;
--             ELSE
--                조건식이 거짓인 경우 실행 문장.
--             END IF
-- 3) IF~THEN~ELSIF : 여러 조건에 따라 각자 지정한 작업을 수행.
--        형식) IF 조건식1 THEN
--                조건식1이 참인 경우 실행 문장;
--             ELSIF 조건식2 THEN
--                조건식1이 거짓이고, 조건식2가 참인 경우 실행 문장.
--             ELSIF 조건식3 THEN
--                조건식1,2가 거짓이고, 조건식2가 참인 경우 실행 문장.
--             ELSE
--                조건식1,2,3이 거짓인 경우 실행 문장.
--             END IF

-- 1) IF~THEN 예제
DECLARE
    V_NUMBER NUMBER(3) := 15;
BEGIN
    IF V_NUMBER >= 10 THEN
        DBMS_OUTPUT.PUT_LINE(V_NUMBER || '는 10보다 큰 수입니다.');
    END IF;
END;
/

-- 2) IF~THEN~ELSE 예제
DECLARE
    V_SCORE NUMBER(3) := 38;
BEGIN
    IF MOD(V_SCORE,2) = 1 THEN
        DBMS_OUTPUT.PUT_LINE(V_SCORE || '는 홀수입니다.');
    ELSE
        DBMS_OUTPUT.PUT_LINE(V_SCORE || '는 짝수입니다.');
    END IF;
END;
/

-- 3) IF~THEN~ELSIF 예제
DECLARE
    V_AVG NUMBER(5,2) := 89.12;
BEGIN
    IF V_AVG >= 90 THEN
        DBMS_OUTPUT.PUT_LINE('A학점입니다.');
    ELSIF V_AVG >= 80 THEN
        DBMS_OUTPUT.PUT_LINE('B학점입니다.');
    ELSIF V_AVG >= 70 THEN
        DBMS_OUTPUT.PUT_LINE('C학점입니다.');
    ELSIF V_AVG >= 60 THEN
        DBMS_OUTPUT.PUT_LINE('D학점입니다.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('F학점입니다.');
    END IF;
END;
/

-- 2. CASE 조건문
-- 형식) CASE 비교 기준
--         WHEN 값1 THEN
--          수행할 명령어;
--         WHEN 값2 THEN
--          수행할 명령어;
--         WHEN 값3 THEN
--          수행할 명령어;
--         ELSE
--          값1, 값2, 값3이 아닐 경우 수행할 명령어;
--      END CASE;

DECLARE
    V_SCORE NUMBER(3) := 92;
BEGIN
    CASE TRUNC(V_SCORE / 10)
        WHEN 10 THEN
            DBMS_OUTPUT.PUT_LINE('A학점입니다.');
        WHEN 9 THEN
            DBMS_OUTPUT.PUT_LINE('A학점입니다.');
        WHEN 8 THEN
            DBMS_OUTPUT.PUT_LINE('B학점입니다.');
        WHEN 7 THEN
            DBMS_OUTPUT.PUT_LINE('C학점입니다.');
        WHEN 6 THEN
            DBMS_OUTPUT.PUT_LINE('D학점입니다.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('F학점입니다.');
    END CASE;
END;

-- 반복 제어문
-- 특정 작업을 반복하여 수행하고자 할 때 사용하는 문장.
-- 반복 제어문의 종류
-- 1) 기본 LOOP
-- 2) WHILE LOOP
-- 3) FOR LOOP

-- 반복문의 반복 수행을 종료시키는 명렁어.
-- 1) EXIT : 수행 중인 반복을 종료시키는 명령어
-- 2) EXIT-WHEN : 반복 종료를 위한 조건식을 지정하고 만족하면 반복 종료
-- 3) CONTINUE : 수행중인 반복의 현재 주기를 건너 뜀
-- 4) CONTINUE-WHEN : 특정 조건식을 지정하고 조건식을 만족하면 반복 주기를 건너 뜀

-- 기본 LOOP 를 사용해 보자.
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

-- 2) WHILE LOOP 예제
DECLARE
    V_NUMBER NUMBER(3) := 1;
BEGIN
    DBMS_OUTPUT.PUT_LINE('WHILE LOOP 출력문');
    WHILE V_NUMBER <= 100 LOOP
        DBMS_OUTPUT.PUT_LINE('V_NUMBER >>> ' || V_NUMBER);
        V_NUMBER := V_NUMBER + 1;
    END LOOP;
END;
/

-- FOR LOOP 예제
DECLARE
    V_SUM NUMBER(5) := 0;
BEGIN
    DBMS_OUTPUT.PUT_LINE('FOR LOOP 출력문');
    FOR V_NUM IN 1 .. 100 LOOP
        V_SUM := V_SUM + V_NUM;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('1~100까지의 합 >>> ' || V_SUM);
END;
/

-- 키보드로 데이터를 입력받는 방법
DECLARE
    V_NUM1 NUMBER(3);
    V_NUM2 NUMBER(3);
BEGIN
    V_NUM1 := '&NUM1';
    V_NUM2 := '&NUM2';
    DBMS_OUTPUT.PUT_LINE(V_NUM1||' + '||V_NUM2||' >>> '||(V_NUM1+V_NUM2));
END;
/

-- TEST라는 테이블을 만들어 보자.
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
    
    DBMS_OUTPUT.PUT_LINE('번호 / 이름 / 주소');
    DBMS_OUTPUT.PUT_LINE('=============================');
    DBMS_OUTPUT.PUT_LINE(NO || ' / ' || NAME || ' / ' || ADDR);
END;
/