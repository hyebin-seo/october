-- sql developer에서 주석문
-- 오라클에서 속성에 들어가는 주요 자료형(data type)
-- 1. number(n, n1) : n - 전체 자릿수 / n1 - 소숫점 자릿수 / n - n1 : 정수 자릿수
--    예) number(7, 2) : 전체 자릿수는 7자리이고, 정수는 5자리, 실수 2자리

-- 2. char(n) : 문자열 n개가 저장되는 자료형. ==> 고정 자료형.

-- 3. varchar(n) : 문자열 n개가 저장되는 자료형. ==> 현재는 사용하지 않는 자료형

-- 4. varchar2(n) : 문자열 n개가 저장되는 자료형. ==> 가변 자료형.
--                  한글은 무조건 한 글자당 2바이트씩 소모.
                    
-- 5. date : 날짜가 저장되는 자료형. ==> 시스템의 현재 날짜 및 시간 저장.

-- 중요 개념

-- 무결성(integrity) : 데이터베이스에 저장된 데이터 값과 그것이 표현하는 현실 세계의 실제 값이
--                   일치하는 정확성을 의미함.
                      
-- 무결성 제약조건 : 데이터베이스에 저장된 데이터의 정확성을 보장하기 위해서 정확하지 않은
--                데이터가 데이터베이스 내에 저장되는 것을 방지하기 위한 조건.

-- 데이터베이스 상에서 제약 조건의 종류

-- 1. unique 제약 조건 : 중복이 되면 안되는 조건.

-- 2. not null 제약 조건 : 공백이 허용하지 않는 조건.

-- 3. check 제약 조건 : 특정한 값이 아닌 데이터가 들어오지 못하게 하는 조건.

-- 4. primary key 제약 조건 : unique + not null 제약 조건 ==> 기본키 제약 조건.
--    기본키는 해당 테이블을 대표하는 컬럼으로서의 역할을 수행하며,
--    다른 테이블에서 외래키들이 참조할 수 있는 키로서의 자격을 가진다. 이를 참조 무결성이라 함.

-- 학생 테이블을 만들어 보자.

-- 구성 요소(컬럼/속성) : 학번, 이름, 학과, 학년, 나이, 연락처, 주소, 입학일(등록일)

-- create table 테이블 이름(
--    학번 자료형(크기) {제약 조건},
--    이름 자료형(크기) {제약 조건},
--    학과 자료형(크기) {제약 조건},
--    학년 자료형(크기) {제약 조건},
--    나이 자료형(크기) {제약 조건},
--    연락처 자료형(크기) {제약 조건},
--    주소 자료형(크기) {제약 조건},
--    입학일(등록일) 자료형(크기) {제약 조건}
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

-- 테이블에 컬럼을 추가
-- 형식) ALTER TABLE 테이블명 ADD(컬럼명 데이터타입(크기) 제약조건);
-- student 테이블에서 누락된 주소 컬럼을 추가해 보자.

ALTER TABLE student ADD(address VARCHAR2(200));

-- 테이블의 컬럼을 수정(자료형 수정)
-- 형식) ALTER TABLE 테이블명 MODIFY(컬럼명 데이터타입(크기));

ALTER TABLE student MODIFY(age VARCHAR2(3));

-- 테이블의 컬럼명을 변경하기
-- 형식) ALTER TABLE 테이블명 RENAME COLUMN 기존컬럼명 to 변경컬럼명;

ALTER TABLE student RENAME COLUMN address to addr;

-- 테이블의 컬럼을 삭제하기
-- 형식) ALTER TABLE 테이블명 DROP COLUMN 컬럼명;

ALTER TABLE student DROP COLUMN age;

ALTER TABLE student ADD(age NUMBER(3));





-- student 테이블에 데이터를 추가해 보자
-- 형식) INSERT INTO 테이블명 
--      VALUES('학번','이름','학과',학년,'연락처',sysdate,'주소',나이);

INSERT INTO student
VALUES('2021_001','홍길동','경제학과',3,'010-1111-1234',sysdate,'서울시 마포구',27);

-- 형식2) INSERT INTO 테이블명(학번컬럼명, 이름컬럼명, 학과컬럼명, ...)
--       VALUES(학번데이터, 이름데이터, 학과데이터, ...);
-- 컬럼과 데이터들의 순서를 짝 맞춰서 입력해야 한다.

INSERT INTO student(hakbun, name, major, phone, regdate)
VALUES ('2021_002','유관순','회계학과','010-2222-2345',sysdate);

INSERT INTO student
VALUES('2021_003','김나나','컴공학과',2,'010-3232-3232',sysdate,'경기도 일산',22);

INSERT INTO student
VALUES('2021_004','박모모','관광학과',1,'010-5555-6666',sysdate,'서울시 구로구',24);

INSERT INTO student
VALUES('2021_005','유재재','화학과',2,'010-8888-7777',sysdate,'서울시 광진구',23);

-- student 테이블의 특정 컬럼을 수정(데이터) 해 보자.
-- 형식) UPDATE 테이블명 
--      SET 컬럼명 = 컬럼수정내용
--      WHERE PRIMARY로 설정된 컬럼명 = 컬럼데이터

UPDATE student SET addr = '충청남도 천안시' WHERE hakbun = '2021_002';

UPDATE student
SET year = 2, phone = '010-6666-6789', addr = '서울시 서초구', age = 28
WHERE hakbun = '2021_005';

-- student 테이블의 특정 데이터를 삭제해 보자.
-- 형식) DELETE FROM 테이블명 WHERE PRIMARY로 설정된 컬럼명 = 컬럼데이터

DELETE FROM student WHERE hakbun = '2021_004';

-- student 테이블의 모든 데이터를 삭제하는 방법.
-- 형식) DELETE FROM 테이블명;

DELETE FROM student;

-- DB에 완벽하게 적용시키고자 할 때 사용하는 키워드.
COMMIT;

-- DB에 적용시키고 싶지 않을 때 사용하는 키워드.
ROLLBACK;

-- 현재 계정(web)에 있는 모든 테이블을 보여주세요.
SELECT * FROM TAB;

-- student 테이블의 모든 컬럼을 화면에 보여주세요.
SELECT * FROM student;

-- emp 테이블의 모든 컬럼을 화면에 보여주세요.
SELECT * FROM emp;

-- emp 테이블에서 empno, ename, job, deptno 컬럼을 화면에 보여주세요.
-- 형식) SELECT 컬럼명1, 컬럼명2, ... FROM emp;

SELECT empno, ename, job, deptno FROM emp;

-- [문제1] emp 테이블에서 이름, 입사일, 급여를 화면에 보여주세요.

SELECT ename, hiredate, sal FROM emp;

-- [문제2] emp 테이블에서 사번, 이름, 담당업무, 보너스를 화면에 보여주세요.

SELECT empno, ename, job, comm FROM emp;