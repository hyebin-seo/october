-- join ~ on 키워드.
-- 테이블과 테이블을 연결하여 특정한 데이터를 얻고자 할 때 사용.
-- 두 개 이상의 테이블에 정보가 나뉘어져 있을 때 사용.
-- 중복해서 데이터가 저장되는 것을 막기 위함.
-- emp 테이블에서 부서의 상세 정보까지 저장을 한다면 10번 부서에 소속된 사원이 3명이므로 부서명과 근무지가 3번 중복이 되어 저장 됨.
-- 중복되어 저장된 데이터는 추후 삽입, 수정, 삭제 시 이상 현상이 발생할 수 있게 됨.
-- 즉, 이러한 현상이 발생하지 않게 하려면(데이터가 중복되지 않게 하려면) 데이터베이스에서 두 개 이상의 테이블에 정보를 나누어 저장해야 함.
-- 하지만 이렇게 두개의 테이블로 나누게 되면 데이터의 중복은 발생하지 않지만 원하는 정보를 얻으려면 여러 번 질의를 해야하는 불편함이 발생함.
-- 특정 사원이 소속된 부서명을 알아내기 위해 emp 테이블과 dept테이블을 넘나드는 작업이 생김.
-- 따라서 두 개의 테이블을 결합해서 원하는 결과를 얻어낼 수 있도록 하는 조인이라는 기능을 제공함.

-- 조인의 종류
-- 1) Cross Join
-- 2) Equi Join
-- 3) Self Join
-- 4) Outer Join

-- 1) Cross Join
-- 두 개 이상의 테이블이 조인될 때 조건이 없이 테이블의 결합이 이루어지는 조인.
-- 그렇기 때문에 테이블 전체 행의 컬럼이 조인이 됨.
SELECT *
FROM emp, dept;

-- 2) Equi Join
-- 가장 많이 사용되는 조인 방법.
-- 조인의 대상이 되는 두 테이블에서 공통적으로 존재하는 컬럼의 값이 일치되는 행을 연결하여 결과를 생성하는 방법.
-- 두 테이블이 조인하려면 일치되는 공통 컬럼을 사용하면 된다.
-- 컬럼의 이름이 같으면 혼동이 오기 때문에 컬럼명 앞에 테이블명을 기술해야 한다.

-- emp 테이블에서 사원의 사번, 이름, 담당업무, 부서번호, 부서명, 근무위치를 화면에 출력.
-- ==> emp 테이블과 dept 테이블을 조인해주어야 함.
SELECT e.empno, e.ename, e.job, d.deptno, d.dname, d.loc -- 공통되지 않은 컬럼은 테이블명(별칭) 생략 가능
FROM emp e JOIN dept d
ON e.deptno = d.deptno;

-- emp 테이블에서 사원명이 'SCOTT'인 사원의 부서명을 알고 싶은 경우
SELECT ename, d.deptno, dname
FROM emp e JOIN dept d
on e.deptno = d.deptno
WHERE ename = 'SCOTT';

-- [문제1] 부서명이 'RESEARCH'인 사원의 사번, 이름, 급여, 부서명, 근무위치를 출력
SELECT empno, ename, sal, dname,loc
FROM emp e JOIN dept d
on e.deptno = d.deptno
WHERE dname = 'RESEARCH';

-- [문제2] emp 테이블에서 'NEW YORK'에 근무하는 사원의 이름과 급여, 부서번호를 출력
SELECT ename, sal, d.deptno, loc
FROM emp e JOIN dept d
on e.deptno = d.deptno
WHERE loc = 'NEW YORK';

-- [문제3] emp 테이블에서 'ACCOUNTING'부서 소속 사원의 이름과 담당업무, 입사일, 부서번호, 부서명을 출력
SELECT ename, job, hiredate, d.deptno, dname
FROM emp e JOIN dept d
on e.deptno = d.deptno
WHERE dname = 'ACCOUNTING';

-- [문제4] emp 테이블에서 담당업무가 'MANAGER'인 사원의 이름과 부서명을 출력
SELECT ename, dname
FROM emp e JOIN dept d
on e.deptno = d.deptno
WHERE job = 'MANAGER';

-- 3) Self Join
-- 하나의 테이블 내에서 조인을 해야 자료를 얻을 수 있는데 자기 자신 테이블과 조인을 맺는 것을 말함.
-- FROM절 다음에 테이블명을 나란히 두 번 기술할 수 없음.
-- 따라서 같은 테이블이 하나 더 존재하는 것처럼 사용할 수 있도록 테이블에 별칭을 붙여서 사용.

-- emp 테이블에서 각 사원별 관리자의 이름을 화면에 출력해 보자.
-- 예) CLARK의 매니저 이름은 KING 입니다.
SELECT e1.ename || '의 매니저 이름은 ' || e2.ename || ' 입니다.'
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno;

-- emp 테이블에서 매니저가 KING인 사원들의 이름과 담당업무를 화면에 보여주세요.
SELECT e1.ename, e1.job
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno AND e2.ename = 'KING';

-- 4) Outer 조인
-- 2개 이상의 테이블이 조인이 될 때 어느 한 쪽 테이블에는 해당하는 데이터가 다른쪽 테이블에는 존재하지 않는 경우
-- 그 데이터가 출력이 되지 않는 문제점을 해결하기 위해 사용되는 조인 기법.
-- 정보가 부족한 테이블의 컬럼 뒤에 '(+)'기호를 붙여서 사용함.
SELECT e1.ename || ' 의 매니저 이름은 ' || e2.ename || ' 입니다.'
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno(+); -- NULL값도 포함하기 위해

SELECT ename, d.deptno, dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;


-- dual 테이블
-- 오라클에서 자체적으로 제공해주는 테이블
-- 간단하게 함수를 이용해서 계산, 결과값을 확일할 때 사용하는 테이블.
-- 오직 한 행, 한 컬럼 만을 담고 있는 테이블.
-- 사용 용도 : 특정 테이블을 생성할 필요 없이 함수 또는 계산을 하고자 할 때 사용

-- 오라클에서 제공해주는 함수들

-- 1. 날짜와 관련된 함수들
--  1) 현재 시스템의 날짜를 구해 오는 함수 : sysdate
SELECT SYSDATE FROM DUAL;
--  2) 현재 날짜에서 개월 수를 더해 주는 함수 : ADD_MONTHS(현재 날짜, 숫자(개월수));
SELECT ADD_MONTHS(SYSDATE, 3) FROM DUAL;
--  3) 다가올 날짜(요일)을 구해주는 함수 : NEXT_DAY(현재 날짜,'요일');
SELECT NEXT_DAY(SYSDATE, '화요일') FROM DUAL;
--  4) 형식에 맞게 문자열로 날짜를 출력하는 함수 : TO_CHAR(날짜, '날짜형식');
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MM/DD/YYYY') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YY-MM-DD') FROM DUAL;

-- 2. 문자와 관련된 함수들
--  1) 문자열을 연결하는 함수 : CONCAT('문자열1','문자열2');
SELECT CONCAT('안녕','하세요') FROM DUAL;
--     문자열을 연결하는 연산자 : ||
SELECT '방가' || '방가' FROM DUAL;
--  2) 소문자를 대문자로 바꾸어 주는 함수 : UPPER()
SELECT UPPER('happy day') FROM DUAL;
--  3) 대문자를 소문자로 바꾸어 주는 함수 : LOWER()
SELECT LOWER('HELLO WORLD') FROM DUAL;
--  4) 문자열을 X부터 Y의 길이만큼 추출해 내는 함수 : SUBSTR('문자열', X, Y)
SELECT SUBSTR('ABCDEFG', 3, 2) FROM DUAL; -- CD
SELECT SUBSTR('ABCDEFG', -3, 2) FROM DUAL; -- EF -를 붙이면 뒤에서부터 시작
--  5) 자릿수를 늘려주는 함수
--     왼쪽 자릿수를 늘려주는 함수 : LPAD('문자열', 전체 자릿수, '늘어난 자릿수에 들어갈 문자열')
SELECT LPAD('ABCDEFG', 15, '*') FROM DUAL;
--     오른쪽 자릿수를 늘려주는 함수 : RPAD('문자열', 전체 자릿수, '늘어난 자릿수에 들어갈 문자열')
SELECT RPAD('ABCDEFG', 15, '*') FROM DUAL;
--  6) 문자를 지워주는 함수
--     왼쪽 문자를 지워주는 함수 : LTRIM()
SELECT LTRIM('ABCDEFG', 'A') FROM DUAL;
--     오른쪽 문자를 지워주는 함수 : RTRIM()
SELECT RTRIM('ABCDEFG', 'FG') FROM DUAL;
--  7) 문자열을 교체해주는 함수 : REPLACE()
--     형식) REPLACE('원본 문자열','교체될 문자열','새로운 문자열')
SELECT REPLACE('Java Program', 'Java', 'JSP') FROM DUAL;

-- [문제1] emp 테이블에서 결과가 아래와 같이 나오도록 출력
-- 결과) 'SCOTT의 담당업무는 ANALYST 입니다.'
-- 단, CONCAT() 함수 이용.
SELECT CONCAT(CONCAT(ename, '의 담당업무는 '),CONCAT(job, ' 입니다.'))
FROM emp
WHERE ename = 'SCOTT';

-- [문제2] emp 테이블에서 결과가 아래와 같이 나오도록 출력
-- 결과) 'SCOTT의 연봉은 36000 입니다.'
-- 단, CONCAT() 함수 이용.
SELECT CONCAT(CONCAT(ename, '의 연봉은 '),CONCAT(sal, ' 입니다.'))
FROM emp
WHERE ename = 'SCOTT';

-- [문제3] member10 테이블에서 결과가 아래와 같이 나오도록 출력
-- 결과) '홍길동 회원의 직업은 학생입니다.'
-- 단, CONCAT() 함수 이용.
SELECT CONCAT(CONCAT(memname, ' 회원의 직업은 '),CONCAT(job, '입니다.'))
FROM member10
WHERE memname = '홍길동' AND job = '학생' ;

-- [문제4] emp 테이블에서 사번, 이름, 담당업무 출력
-- 단, 담당업무를 소문자로 변경
SELECT empno, ename, LOWER(job) FROM emp;

-- [문제5] 주민등록번호 중에서 생년월일을 추출하여 화면에 출력.
SELECT SUBSTR('941018-2000000', 0, 6) FROM DUAL;

-- [문제6] emp 테이블에서 담당업무에 'A'라는 글자를 'S'로 바꾸어 출력
SELECT REPLACE(job, 'A', 'S') FROM emp;

-- [문제7] member10 테이블에서 직업이 '학생'인 정보를 '대학생'으로 바꾸어 출력
SELECT REPLACE(job, '학생', '대학생') FROM member10;

-- [문제8] member10 테이블에서 주소에 '서울시'로 된 정보를 '서울특별시'로 바꾸어 출력
SELECT REPLACE(ADDR, '서울시', '서울특별시') FROM member10;


-- 3. 숫자와 관련된 함수들
-- 1) 절대값을 구하는 함수 : ABS(정수)
SELECT ABS(23) FROM DUAL;
SELECT ABS(-23) FROM DUAL;
-- 2) 양수(1), 음수(-1), 0을 반환해 주는 함수 : SIGN(정수)
SELECT SIGN(23) FROM DUAL;
SELECT SIGN(23), SIGN(-23), SIGN(0) FROM DUAL;
-- 3) 반올림을 해 주는 함수 : ROUND(실수)
SELECT ROUND(0.123) FROM DUAL;
SELECT ROUND(0.523) FROM DUAL;
--    반올림 할 때 자릿수 지정
SELECT ROUND(0.1234567, 6) FROM DUAL;
SELECT ROUND(2.3423466, 4) FROM DUAL;
-- 4) 소숫점 이하 자릿수를 잘라내는 함수 : TRUNC()
SELECT TRUNC(1234.1234567, 0) FROM DUAL;
SELECT TRUNC(1234.1234567, 4) FROM DUAL;
SELECT TRUNC(1234.1234567, -3) FROM DUAL; -- 정수값(소수점 앞)을 잘라내라는 의미
-- 5) 무조건 올림을 해주는 함수 : CEIL()
SELECT CEIL(22.8) FROM DUAL;
SELECT CEIL(22.1) FROM DUAL;
-- 6) 제곱을 구해주는 함수 : POWER()
SELECT POWER(4,3) FROM DUAL;
-- 7) 나머지를 구해주는 함수 : MOD()
SELECT MOD(7,4) FROM DUAL;
-- 8) 제곱근을 구해주는 함수 : SQRT()
SELECT SQRT(3) FROM DUAL;
SELECT SQRT(16) FROM DUAL;

