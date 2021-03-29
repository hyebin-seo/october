-- LIKE 키워드 : 검색을 하는 키워드
-- WHERE ename LIKE '%S%' : ename 컬럼에 S자를 포함하는 사원의 이름을 검색
-- WHERE ename LIKE 'S%' : ename 컬럼의 첫 글자가 S로 시작하는 사원의 이름을 검색
-- WHERE ename LIKE '%S' : ename 컬럼의 마지막 글자가 S로 끝나는 사원의 이름을 검색
-- WHERE ename LIKE '_S%' : ename 컬럼의 두번째 글자가 S자를 포함하는 사원의 이름을 검색

SELECT *
FROM emp
WHERE ename LIKE '%S%';

SELECT *
FROM emp
WHERE ename LIKE '%M%';

SELECT *
FROM emp
WHERE ename LIKE '_I%';

-- [문제1] emp 테이블에서 이름이 'S'자로 끝나는 사원의 이름과 담당업무 출력
SELECT *
FROM emp
WHERE ename LIKE '%S';

-- [문제2] emp 테이블에서 이름의 세번째에 'R'이 들어가는 사원의 이름과 담당업무, 급여 출력
SELECT ename, job, sal
FROM emp
WHERE ename LIKE '__R%';

-- [문제3] emp 테이블에서 이름의 두번째에 'O'이 들어가는 사원의 모든 정보 출력
SELECT *
FROM emp
WHERE ename LIKE '_O%';

-- [문제4] emp 테이블에서 입사년도가 82년도인 사원의 사번, 이름, 입사일자 출력
SELECT empno, ename, hiredate
FROM emp
WHERE hiredate LIKE '82%';

-- [문제5] member10 테이블에서 성이 김씨인 회원의 모든 정보 출력
SELECT *
FROM member10
WHERE memname LIKE '김%';

-- [문제6] member10 테이블에서 주소에 '서울시'가 들어가는 회원의 이름, 주소, 직업 출력
SELECT memname, addr, job
FROM member10
WHERE addr LIKE '%서울시%';

-- ORDER BY 절
-- 자료를 정렬하여 나타낼 때 필요한 구문.
-- SELECT 구문의 가장 마지막에 위치.
-- asc : 오름차순 정렬
-- desc : 내림차순 정렬
-- 기본적으로 ORDER BY절을 사용 시에는 DEFAULT가 오름차순 정렬.
-- 오름차순 정렬인 경우에는 ASC 생략 가능.
-- NULL 값은 오름차순에서는 제일 나중에 나오고, 내림차순에서는 제일 먼저 나옴.

-- member10 테이블에서 이름을 기준으로 오름차순으로 정렬하여 출력.
-- 단, 이름이 같은 경우 나이 내림차순 정렬
SELECT * FROM member10 ORDER BY memname, age DESC;

-- [문제1] EMP 테이블에서 부서번호를 기준으로 오름차순 정렬하고,
-- 부서번호가 같으면 급여 기준으로 내림차순 정렬.
SELECT * FROM emp ORDER BY deptno, sal DESC;

-- [문제2] PRODUCT 테이블에서 판매가격을 기준으로 내림차순 정렬하여 모든 정보 출력
SELECT * FROM products ORDER BY output_price DESC;

-- [문제3] PRODUCT 테이블에서 배송비를 기준으로 모든 정보를 내림차순 정렬.
-- 단, 배송비가 같은 경우 마일리지를 기준으로 내림차순으로 정렬.
SELECT * FROM products ORDER BY trans_cost DESC, mileage DESC;

-- [문제4] EMP 테이블에서 입사일자가 오래된 사원부터 최근에 입사한 사원을 기준으로 정렬.
-- 사원명, 입사일자 출력
SELECT ename, hiredate FROM emp ORDER BY hiredate;

-- [문제5] EMP 테이블에서 급여를 기준으로 내림차순 정렬하여 모든 정보 출력.
SELECT * FROM emp ORDER BY sal DESC;

-- [문제6] EMP 테이블에서 급여가 1100 이상인 사원들의 모든 정보 출력하되 입사일자가 빠른순으로 정렬.
SELECT * FROM emp WHERE sal >= 1100 ORDER BY hiredate;

-- [문제7] EMP 테이블에서 부서번호를 기준으로 오름차순 정렬하고,
-- 부서번호가 같은 경우 담당업무를 오름차순으로 정렬.
-- 담당업무가 같으면 급여가 많은데서 적은순으로 출력.
-- 모든 정보 출력.
SELECT * FROM emp ORDER BY deptno, job, sal DESC;

-- NOT 키워드 : 부정
-- 쿼리문 작성 시 부정이 아닌 긍정의 쿼리문을 작성한 후에 부정의 의미인 NOT을 붙인다.
-- emp 테이블에서 담당업무가 'MANAGER', 'CLERK', 'ANALYST'가
-- 아닌 사원의 사번, 이름, 담당업무, 급여를 출력

SELECT empno, ename, job, sal
FROM emp
WHERE job NOT IN ('MANAGER','CLERK','ANALYST');

-- [문제1] EMP 테이블에서 이름에 'S'자가 들어가지 않는 사람의 이름을 출력.
SELECT ename FROM EMP WHERE ename NOT LIKE '%S%';

-- [문제2] EMP 테이블에서 부서번호가 10번 부서가 아닌 사원의 이름, 담당업무, 부서번호를 출력.
SELECT ename, job, deptno FROM emp WHERE NOT deptno = 10;

-- [문제3] MEMBER10 테이블에서 주소가 '서울'이 아닌 회원의 모든 정보를 출력.
SELECT * FROM member10 WHERE addr NOT LIKE '%서울%';

-- [문제4] PRODUCTS 테이블에서 출고가가 100만원 미만이 아닌 제품의 상품명, 출고가를 출력
SELECT products_name, output_price
FROM products
WHERE NOT output_price < 1000000; 

-- 그룹 함수
-- 여러 행 또는 테이블 전체에 대하여 함수가 적용되어 하나의 결과값을 가져오는 함수.
-- 1) AVG() : 평균 값을 구하는 함수.
-- 2) COUNT() : 행의 갯수를 구하는 함수. NULL 값은 무시한다.
-- 3) MAX() : 최대값을 구하는 함수.
-- 4) MIN() : 최소값을 구하는 함수.
-- 5) SUM() : 총합을 구하는 함수.

-- emp 테이블에서 사번을 가지고 있는 모든 사원의 수를 출력.
SELECT COUNT(empno) FROM EMP;

-- [문제1] emp 테이블에서 관리자(mgr)의 수를 출력.
SELECT COUNT(DISTINCT mgr) AS "관리자 수" FROM emp;

-- [문제2] emp 테이블에서 보너스를 가진 사원의 수를 출력.
SELECT COUNT(COMM) FROM emp;

-- [문제3] emp 테이블에서 모든 salesman의 급여 평균과 급여 최고액, 급여 최소액, 급여 합계액 출력.
SELECT AVG(sal) AS "급여 평균액", MAX(sal) AS "급여 최고액",
       MIN(sal) AS "급여 최소액", SUM(SAL) AS "급여 합계액"
FROM emp
WHERE job = 'SALESMAN';

-- [문제4] emp 테이블에서 등록되어 있는 사원의 총 수, 보너스가 NULL이 아닌 인원수와
-- 보너스의 평균, 등록되어 있는 부서의 수 출력
SELECT COUNT(empno), COUNT(comm), AVG(comm), COUNT(DISTINCT deptno) 
FROM EMP;

-- 시퀀스(SEQUENCE)
-- 순번을 부여할 때 사용하는 문법.
-- 형식) CREATE SEQUENCE 시퀀스 이름 START WITH 1 INCREMENT BY 1

CREATE TABLE memo(
    bunho NUMBER(5),                    -- 메모 글번호
    title VARCHAR2(100) NOT NULL,       -- 메모 글제목
    writer VARCHAR2(50) NOT NULL,       -- 메모 작성자
    content VARCHAR2(1000) NOT NULL,    -- 메모 글내용
    regdate DATE,                       -- 메모 작성일
    PRIMARY KEY(bunho)
);

-- 메모 작성시 사용할 시퀀스를 만들어 보자.
CREATE SEQUENCE memo_seq START WITH 1 INCREMENT BY 1;

-- memo 테이블에 데이터를 저장해보자.
INSERT INTO memo VALUES(memo_seq.NEXTVAL, '메모1', '홍길동', '길동이 글', SYSDATE);
INSERT INTO memo VALUES(memo_seq.NEXTVAL, '두번째 메모', '이순신', '순신님 글', SYSDATE);
INSERT INTO memo VALUES(memo_seq.NEXTVAL, '메모3', '유관순', '누나 글', SYSDATE);
INSERT INTO memo VALUES(memo_seq.NEXTVAL, '메모4', '김유신', '유신님 글', SYSDATE);
INSERT INTO memo VALUES(memo_seq.NEXTVAL, '메모5', '김연아', '연아님 글', SYSDATE);