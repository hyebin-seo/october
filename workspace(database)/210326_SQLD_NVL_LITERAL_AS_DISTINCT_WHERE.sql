-- emp 테이블에서 사번, 이름, 급여, 보너스, 급여+보너스를 화면에 보여주세요.

SELECT empno, ename, sal, comm, sal+comm FROM emp;

-- 위처럼 하면 NULL 값을 가지는 컬럼때문에 잘못된 결과가 출력된다.

-- NULL 값을 가지는 컬럼을 다른 컬럼과 연산을 하면 모두 NULL로 처리 된다.
-- NVL() 함수 : NULL 값을 특정한 값으로 변경시켜 주는 함수
--             모든 데이터 타입에 적용이 가능함
--             NVL() 함수를 사용할 때는 전환되는 값의 자료형을 일치시켜야 함.
-- 형식) NVL(NULL값이 들어 있는 컬럼명, 변경할 값)

SELECT empno, ename, sal, comm, sal+NVL(comm,0) FROM emp;

-- NVL2() 함수 : 자바에서의 3항연산자와 비슷한 함수.
-- 형식) NVL2(컬럼명, expr1, expr2)
--      ==> expr1 : 컬럼명의 값이 NULL이 아닌 경우 반환
--      ==> expr2 : 컬럼명의 값이 NULL인 경우 반환

SELECT empno, ename, sal, comm, sal+NVL2(comm, comm, 0) FROM emp;

-- AS : 컬럼명을 변경하는 키워드 ==> 별칭(별명)
-- 컬럼 명 바로 뒤에 사용함. 컬럼명과 별칭 사이에 AS라는 키워드를 넣어줌.
-- 모든 별칭은 ""안에 작성. AS 별칭은 생략 가능.

SELECT empno, ename, sal, comm, sal+NVL2(comm, comm, 0) AS "급여+보너스" FROM emp;

-- [문제] emp 테이블에서 사번, 사원명, 급여, 급여의 10% 인상액을 화면에 보여주세요.

SELECT empno, ename, sal, sal*1.1 AS "급여의 10% 인상액" FROM emp;

-- emp 테이블에서 각 사원의 담당업무(job)를 화면에 보여주세요.

SELECT job FROM emp;

-- DISTINCT 키워드 : 중복을 제거하는 키워드
-- 주로 하나의 컬럼에서 중복된 값을 제거하고 보여줄 때 사용함.
-- DISTINCT 키워드는 항상 SELECT 키워드 다음에 기술한다.
-- DISTINCT 키워드 뒤에 나오는 컬럼들은 모두 DISTINCT의 영향을 받는다.
-- DISTINCT 뒤에 여러 개의 컬럼들이 기술이 되면 해당 컬러들은 중복이 되지 않게 나온다.

-- emp 테이블에서 각 사원의 관리자(mgr)를 화면에 보여주세요.

SELECT DISTINCT job FROM emp;

-- [문제] emp 테이블에서 담당업무와 부서번호의 중복을 제거한 후 화면에 보여주세요.

SELECT DISTINCT job, deptno FROM emp;

-- member10 이라는 테이블을 만들어 보자.

CREATE TABLE member10(
    num NUMBER(7) PRIMARY KEY,          -- 회원번호
    memid VARCHAR2(20) NOT NULL,        -- 회원 ID
    memname VARCHAR2(20) NOT NULL,      -- 회원 이름
    pwd VARCHAR2(20) NOT NULL,           -- 회원 비밀번호
    age NUMBER(3),                      -- 회원 나이
    mileage NUMBER(8) NOT NULL,         -- 회원 마일리지
    job VARCHAR2(30),                   -- 회원 직업
    addr VARCHAR2(200),                 -- 회원 주소
    regdate DATE NOT NULL               -- 회원 가입일
);

-- member10 테이블에 고객의 정보를 저장해 보자.
INSERT INTO member10
VALUES(1, 'id1', '홍길동', '1111', 25, 0, '학생', '부산시 동래구', '2013-08-08');

INSERT INTO member10
VALUES(2, 'id2', '김길동', '2222', 30, 1500, '직장인', '서울시 강남구', '2013-08-08');

INSERT INTO member10
VALUES(3, 'id3', '공성현', '3333', 33, 1000, '직장인', '부산시 중구', '2013-08-08');

INSERT INTO member10
VALUES(4, 'id4', '김영희', '4444', 18, 3000, '학생', '경상남도 마산시', '2012-09-09');

INSERT INTO member10
VALUES(5, 'id5', '박말자', '5555', 45, 5000, '주부', '경기도 남양주시', '2013-08-08');

INSERT INTO member10
VALUES(6, 'id6', '김철수', '6666', 55, 0, '교수', '제주도 서귀포시', '2013-01-01');

INSERT INTO member10
VALUES(7, 'id7', '홍길동', '7777', 14, 6000, '학생', '경상북도 경주시', '2012-12-25');

INSERT INTO member10
VALUES(8, 'id8', '김상현', '8888', 31, 0, '무직', '서울시 마포구', '2013-04-18');

INSERT INTO member10
VALUES(9, 'id9', '이지연', '9999', 25, 0, '학생', '강원도 강릉시', '2013-02-06');

INSERT INTO member10
VALUES(10, 'id10', '홍길동', '0101', 52, 10000, '주부', '서울시 강북구', '2013-09-15');

-- 카테고리 테이블을 만들어 보자

create table category(
    cnum number(5) default '1' not null,
    category_code varchar2(8) not null,
    category_name varchar2(30) not null,
    delete_chk char(1) default 'N' not null,
    primary key(cnum)
);

-- 테이블을 삭제해 보자
-- drop table category purge;

-- 카테고리 테이블에 데이터를 저장해 보자.
insert into category values(1, '00010000', '전자제품', 'N');
insert into category values(2, '00010001', 'TV', 'N');
insert into category values(3, '00010002', '컴퓨터', 'N');
insert into category values(4, '00010003', 'MP3', 'N');
insert into category values(5, '00010004', '에어컨', 'N');
insert into category values(6, '00020000', '의류', 'N');
insert into category values(7, '00020001', '남방', 'N');
insert into category values(8, '00020002', '속옷', 'N');
insert into category values(9, '00020003', '바지', 'N');
insert into category values(10, '00030000', '도서', 'N');
insert into category values(11, '00030001', '컴퓨터도서', 'N');
insert into category values(12, '00030002', '소설', 'N');


-- 상품 상세 정보 테이블을 만들어 보자.
create table products(
    pnum number(11) primary key,                  -- 제품 번호
    category_fk varchar2(8) not null,             -- 카테고리
    products_name varchar2(50) not null,          -- 제품명
    ep_code_fk varchar2(5) not null,              -- 제품 코드
    input_price number(10) default 0 not null,    -- 입고가격
    output_price number(10) default 0 not null,   -- 출고가격
    trans_cost number(5) default 0 not null,      -- 배송비
    mileage number(6) default 0 not null,         -- 마일리지
    company varchar2(30),                         -- 제조사
    status char(1) default '1' not null           -- 제품 재고 현황
);


-- 상품 데이터를 저장해 보자.
insert into products
    values(1, '00010001', 'S 벽걸이 TV', '00001', 5000000, 8000000, 0, 100000,'삼성','1');
insert into products
    values(2, '00010001', 'D TV', '00002', 300000, 400000, 0, 50000,'대우','1');
insert into products
    values(3, '00010004', 'S 에어컨', '00001', 1000000, 1100000, 5000, 100000,'삼성','2'); 
insert into products
    values(4, '00010000', 'C 밥솥', '00003', 200000, 220000, 5500, 0,'쿠쿠','1');
insert into products
    values(5, '00010004', 'L 에어컨', '00003', 1200000, 1300000, 0, 0,'LG','1');
insert into products
    values(6, '00020001', '남성난방', '00002', 100000, 150000, 2500, 0,'','1');
insert into products
    values(7, '00020001', '여성난방', '00002', 120000, 200000, 0, 0,'','3');
insert into products
    values(8, '00020002', '사각팬티', '00002', 10000, 20000, 0, 0,'보디가드','1');
insert into products
    values(9, '00020003', '멜빵바지', '00002', 15000, 18000, 0, 0,'','1');
insert into products
    values(10, '00030001', '무따기 시리즈', '00001', 25000, 30000, 2000, 0,'길벗','1');
    
-- [문제] member10 테이블에서 회원의 이름과 나이, 직업을 화면에 보여주세요.

SELECT memname, age, job FROM member10;

-- [문제] products 테이블에서 제품명, 입고가, 출고가, 제조사를 화면에 보여주세요.

SELECT products_name, input_price, output_price, company FROM products;

-- LITERAL 문자열
-- 컬럼명이나 별칭이 아닌 SELECT 목록에 포함되는 문자, 표현식 숫자를 의미.
-- 날짜나 문자열인 경우 단일 인용부호('')를 사용해야 한다.
-- 예) "KING 사원의 연봉은 60000 입니다."

SELECT ename || ' 사원의 연봉은 ' || sal*12 || ' 입니다.' as "사원의 연봉" FROM emp;

-- member10 테이블의 리터럴 작업을 진행해보자.
-- 예) "홍길동 회원의 직업은 학생입니다."

SELECT memname || ' 회원의 직업은 ' || job || ' 입니다.' as "회원의 직업" FROM member10;

-- WHERE 조건절
-- 모든 데이터를 가져오는 것이 아니라 사용자가 원하는 데이터만 조회할 경우에 사용.
-- WHERE절은 FROM 테이블 이름 뒤에 기술해야 한다.
-- 형식) SELECT 컬럼명1, 컬럼명2.... FROM 테이블명 WHERE 조건식;
-- WHERE 조건절은 자료를 검색할 때 사용되는 키워드.
-- 1) = : 조건이 같은가?
-- 2) < : 조건이 작은가?
-- 3) <= : 조건이 작거나 같은가?
-- 4) > : 조건이 큰가?
-- 5) >== : 조건이 크거나 같은가?
-- 6) != : 조건이 같지 않은가?
-- 7) <> : 조건이 같지 않은가? !=와 같은 의미.
-- 8) BETWEEN A AND B : A와 B 사이에 있는가?
--    주의) 작은 값을 앞에 기술하고 큰 값을 뒤에 기술해야 함.
-- 9) IN(LIST) : LIST 값 중에 어느 하나와 일치하는가?
-- 10) NOT BETWEEN A AND B : A와 B 사이에 있지 않은가?(A,B 값 포함하지 않음)
-- 11) NOT IN(LIST) : LIST 값과 일치하지 않는가?

SELECT * FROM emp;

-- emp 테이블에서 담당업무가 'MANAGER' 인 사원의 모든 정보를 화면에 보여주세요.

SELECT * FROM emp WHERE job = 'MANAGER';

SELECT * FROM emp WHERE job = 'SALESMAN';

-- [문제1] emp 테이블에서 담당업무가 'CLERK'인 사람의 사번, 이름, 담당업무, 급여 출력
SELECT empno, ename, job, sal FROM emp WHERE job = 'CLERK';

-- [문제2] emp 테이블에서 1982년 1월 1일 이후에 입사한 사원의 사번, 이름, 담당업무, 급여, 입사일자 출력
SELECT empno, ename, job, sal, hiredate FROM emp WHERE hiredate > '19820101';
SELECT empno, ename, job, sal, hiredate FROM emp WHERE hiredate > '82/01/01';

-- [문제3] emp 테이블에서 급여가 1300 ~ 1500 사이인 사원의 이름과 담당업무, 급여, 부서번호 출력
SELECT ename, job, sal, deptno FROM emp WHERE sal BETWEEN 1300 AND 1500;
SELECT ename, job, sal, deptno FROM emp WHERE sal >= 1300 AND sal <= 1500;

-- [문제4] emp 테이블에서 사번이 7902, 7788,7566인 사원의 사번, 이름, 담당업무 출력
SELECT empno, ename, job FROM emp WHERE empno IN(7902, 7788, 7566);
SELECT empno, ename, job FROM emp WHERE empno = 7902 OR empno = 7788 OR empno = 7566;

-- [문제5] emp 테이블에서 보너스가 300이거나 500이거나 1400인 사원의 모든 정보 출력
SELECT * FROM emp WHERE comm IN(300, 500, 1400);
SELECT * FROM emp WHERE comm = 300 OR comm = 500 OR comm = 1400;

-- [문제6] member10 테이블에서 이름이 홍길동이면서 직업이 학생인 회원의 모든 정보 출력
SELECT * FROM member10 WHERE memname = '홍길동' AND job = '학생';

-- [문제7] products 테이블에서 제조사가 '삼성' 또는 '현대' 이면서 입고가가 100만원 이하인 상품의 상품명과 입고가, 출고가 출력
SELECT products_name, input_price, output_price FROM products WHERE company IN('삼성','현대') AND input_price <= 1000000;

-- [문제8] emp 테이블에서 급여가 1100 이상이고, 담당업무가 'MANAGER'인 사원의 사번, 이름, 담당업무, 급여 출력
SELECT empno, ename, job, sal FROM emp WHERE sal >= 1100 AND job = 'MANAGER';









