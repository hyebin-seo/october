-- View(중요)

-- 물리적인 테이블에 근거한 논리적인 가상의 테이블을 말함.

-- View는 실질적으로 데이터를 저장하고 있지 않음.

-- View를 만들면 데이터베이스에 질의 시 실제 테이블에 접근하여 데이터를 

-- 불러오게 됨.

-- 간단하게 말하면 필요한 내용들만 추출해서 사용하는 것.

-- 주로 데이터를 조회할 때 가장 많이 사용됨.

-- View는 테이블과 유사하며, 테이블처럼 사용이 가능함.

-- View는 테이블에 저장하기 위한 물리적인 공간이 필요가 없음.

-- 테이블과 마찬가지로 insert, update, delete, select 명령이 가능함.

-- View를 사용하는 이유

-- 1) 보안 관리를 위해 사용함(중요함)

--    ==> 보안 등급에 맞추어 컬럼의 범위를 정해서 조회가 가능하도록 할 수 있음.

-- 2) 사용자의 편의성을 제공함.

-- 형식)  create view 뷰이름

--       as

--       쿼리문;


-- 인사부 view
-- 컬럼에 sal(급여), comm(보너스) 컬럼은 제외
create view emp_insa
as
select empno, ename, job, mgr, hiredate, deptno
from emp;

-- 영업부 view
-- 컬럼에 sal(급여) 컬럼은 제외
create view emp_sales
as
select empno, ename, job, mgr, hiredate, comm, deptno
from emp;

-- 회계부 view
-- 컬럼에 emp 테이블의 모든 컬럼이 반영.
create view emp_account
as
select empno, ename, job, mgr, hiredate, sal, comm, deptno
from emp;

-- emp 테이블을 복사해서 view를 만들자.
create view emp_view
as
select empno, ename, job, mgr, hiredate, sal, comm, deptno
from emp;

-- emp_view에 데이터를 추가해 보자.
insert into emp_view
    values(9000, 'ANGEL', 'SALESMAN', 7698, sysdate, 1500, 200, 30);


-- 읽기 전용 view를 만들게 되면 insert, update, delete 쿼리가 안 됨.

-- 읽기 전용 view를 만드는 방법 : 쿼리문 맨 마지막에 with read only 문구 추가.

create view emp_view1
as
select * from emp
with read only;

insert into emp_view1
    values(9001, 'LOVE', 'SALESMAN', 7698, sysdate, 1300, 100, 30);
    
-- create or replace view : 같은 이름의 view가 있는 경우에는 삭제하고

--                          다시 view를 만들라는 의미.

create or replace view emp_sales
as
select * from emp;


-- 2) 사용자의 편의성을 제공함.
create or replace view emp_read(empno, ename, annul_salary)
as
select empno, ename, (sal+nvl(comm, 0))*12
from emp
with read only;

select * from emp_read;

-- 부서별로 부서별 급여합계, 부서별 급여 평균을 구한
-- view를 만들어 화면에 보여주세요.

-- view를 만들 때 그룹함수를 사용시에는 반드시 별칭을 설정해 주어야 함.
create view emp_deptno
as
select deptno, sum(sal) "급여합계", avg(sal) "급여평균"
from emp
group by deptno;

-- [문제1] emp 테이블을 이용하여 emp_dept20이라는 view를 만들어 보세요.
-- 단, 부서번호가 20번 부서에 속한 사원들의 사번, 이름, 담당업무, 관리자,
-- 부서번호만 화면에 보여주시기 바랍니다.
create or replace view emp_dept20
as
select empno, ename, job, mgr, deptno
from emp
where deptno = 20;

-- [문제2] emp 테이블에서 각 부서별 최대급여와 최소급여를 보여주는 view를
-- 만들되 sal_view 라는 이름으로 만들어 화면에 보여주세요.
create or replace view sal_view
as
select deptno, max(sal) "최대급여", min(sal) "최소급여"
from emp
group by deptno;

-- view를 만들때 컬럼만 만들고 싶은 경우
-- ==> 조건을 말이 안되는 조건을 작성하면 됨.
create or replace view emp_view2
as
select * from emp
where deptno = 1;

-- [문제] 담당업무가 'SALEAMAN'인 사원의 사번, 이름, 담당업무,
-- 입사일, 부서번호를 컬럼으로 하는 view를 만들되 emp_sale 이라는
-- view를 만들어 화면에 보여주세요.
create or replace view emp_sale
as
select empno, ename, job, hiredate, deptno
from emp
where job = 'SALESMAN';



-- 컬럼 속성(제약 조건)

-- 테이블에 부적합한 자료가 입력되는 것을 방지하기 위해서

-- 테이블을 생성할 때 각 컬럼에 대해서 정의하는 여러 가지 규칙을 정한 것.

-- 1) not null

-- 2) unique

-- 3) primary key : not null + unique 제약 조건

-- 4) foreign key

-- 5) check


-- 1) not null 제약 조건
-- null 값이 입력되지 못하게 하는 제약 조건.
-- 특정 열에 데이터의 중복 여부와는 상관없이 null 값을 허용하지 않는 제약 조건.

create table null_test(
    col1 varchar2(10) not null,
    col2 varchar2(10) not null,
    col3 varchar2(10)
);

insert into null_test values('aa', 'aa1', 'aa2');

insert into null_test(col1, col2) values('bb', 'bb1');

insert into null_test(col1, col2) values('cc', ''); -- error 발생


-- 2) unique 제약 조건
-- 열에 저장할 데이터의 중복을 허용하지 않고자 할 때 사용하는 조건.
-- null 값은 허용됨.

create table unique_test(
    col1 varchar2(10) unique,
    col2 varchar2(10) unique,
    col3 varchar2(10) not null,
    col4 varchar2(10) not null
);

insert into unique_test values('aa', 'bb', 'cc', 'dd');

insert into unique_test values('aa1', 'bb1', 'cc1', 'dd1');

update unique_test set col2 = 'bb' where col1='aa1';  -- error 발생


-- 3) primary key : not null + unique 제약 조건
-- 테이블에 하나만 존재해야 함.
-- 보통은 주민번호나 emp 테이블의 empno(사원번호) 등이 primary key의
-- 조건이 됨.


-- 4)foreign key 제약 조건
-- 다른 테이블의 필드(컬럼)을 참조해서 무결성을 검사하는 제약 조건.
-- 참조키 : 부모테이블의 컬럼을 이야기 함.
-- 외래키 : 자식테이블의 컬럼을 이야기 함.
-- 자식 테이블의 컬럼의 값(데이터)이 부모테이블에 없는 경우에는 무결성의
-- 규칙이 깨져 버림. 
-- 외래키가 존재하기 위해서는 우선적으로 부모테이블이 먼저 만들어져야 함.

create table foreign_test(
    empno number(4) primary key,
    ename varchar2(20) not null,
    job varchar2(50) not null,
    deptno number(2) references dept(deptno)
);

insert into foreign_test values(1111, '홍길동', '영업부', 30);
insert into foreign_test values(2222, '유관순', '회계부', 10);
insert into foreign_test values(3333, '김유신', 'IT', 50);  -- error 발생


-- 5) check 제약 조건
-- 열에 저장할 수 있는 값의 범위 또는 패턴을 정의할 때 사용함.
-- 주어진 값만 허용하는 조건.

create table check_test(
    gender varchar2(10) 
       constraint gender_ch check(gender in ('남자', '여자'))
);

insert into check_test values('남자');
insert into check_test values('여자');
insert into check_test values('여성');  -- error 발생



-- 시퀀스(sequence)
-- 연속적인 번호를 만들어 주는 기능.
-- 형식)
--      create sequence 시퀀스이름
--      start with n (시작번호 설정 - 기본적으로 기본값은 1)
--      increment by n (증가 번호 설정 - 기본적으로 증가값은 1)
--      maxvalue n  (시퀀스 최대 번호 설정)
--      minvalue n  (시퀀스 최소 번호 설정)
--      cache / nocache (시퀀스의 값을 빠르게 설정하기 위해 
--                       캐쉬 메모리 사용여부)

--   1) cache : 시퀀스를 빨리 제공하기 위해서 미리 캐쉬 메모리에
--              시퀀스를 넣어 두고 준비하고 있다가 시퀀스 작업이
--              필요할 때 사용을 함. 디폴트로는 20개의 시퀀스를
--              캐쉬 메모리에 보관하게 됨.
--              하지만 만약 시스템이 비정상적으로 종료를 하게 되면
--              캐쉬 메모리에 존재하던 남은 시퀀스 번호는 사라지게 됨.

--   2) nocache : cache 기능을 사용하지 않겠다는 의미.

-- 시퀀스의 다음 시퀀스 번호를 확인하고 싶은 경우
select memo_seq.nextval from dual;


