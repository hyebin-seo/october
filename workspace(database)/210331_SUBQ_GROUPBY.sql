-- 서브 쿼리
-- 하나의 쿼리문 안에 포함되어 있는 또 하나의 쿼리문을 말함.
-- 서브쿼리는 메인쿼리가 서브쿼리를 포함하는 종속적인 관계임.
-- 여러번 쿼리를 실행해서 얻을수 있는 결과를 하나의 중첩된 쿼리 문장으로 결과를 얻을 수 있게 해줌.
-- 주의사항
--1) 서브쿼리는 괄호로 묶어서 사용해야함.
--2) 서브쿼리 안에서는 ORDER BY 절은 사용할 수 없음.
--3) 연산자 오른쪽에 사용해야 함.
-- 사용방법 : 우선은 안쪽에 있는 쿼리문을 실행 후, 그 결과값을 가지고 바깥쪽 쿼리문을 실행 

-- emp 테이블에서 이름이 'SCOTT'인 사원의 급여보다 더 많은 급여를 받는
-- 사원의 사번, 이름, 담당업무, 급여를 화면에 보여주세요.

SELECT empno, ename, job, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'SCOTT');

-- [문제1] emp 테이블에서 평균 급여보다 더 적게 받는 사원의 사번, 이름, 담당업무, 급여, 부서번호 출력
SELECT EMPNO, ENAME, JOB, SAL, DEPTNO
FROM EMP
WHERE SAL < (SELECT AVG(SAL) FROM EMP);

-- [문제2] emp 테이블에서 사번이 7521인 사원과 담당업무가 같고,
-- 급여가 7934인 사원보다 더 많이 받는 사원의 사번, 이름, 담당업무, 급여 출력
SELECT EMPNO, ENAME, JOB, SAL
FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE EMPNO = 7521)
AND SAL > (SELECT SAL FROM EMP WHERE EMPNO = 7934);

-- [문제3] emp 테이블에서 담당업무가 'MANAGER'인 사원의 최소급여보다 적으면서
-- 담당업무가 'CLERK'은 아닌 사원의 사번, 이름, 담당업무, 급여 출력
SELECT EMPNO, ENAME, JOB, SAL
FROM EMP
WHERE JOB != 'CLERK' 
AND SAL < (SELECT MIN(SAL) FROM EMP WHERE JOB = 'MANAGER');

-- [문제4] 부서위치가 'DALLAS'인 사원의 사번, 이름, 부서번호, 담당업무 출력
SELECT EMPNO, ENAME, DEPTNO, JOB
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS'); -- 20번부서

-- [문제5] member10 테이블에 있는 고객의 정보 중 마일리지가 가장 높은 고객의 모든 정보 출력
SELECT *
FROM MEMBER10
WHERE MILEAGE = (SELECT MAX(MILEAGE) FROM MEMBER10);

-- [문제6] emp 테이블에서 'SMITH'인 사원보다 더 많은 급여를 받는 사원의 이름, 급여 출력
SELECT ENAME, SAL
FROM EMP
WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'SMITH');

-- [문제7] emp 테이블에서 10번 부서 급여의 평균 급여보다 적은 급여를 받는
-- 사원들의 이름, 급여, 부서번호 출력
SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE SAL < (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = '10');

-- [문제8] emp 테이블에서 'BLAKE'와 같은 부서에 있는 사원들의 이름, 입사일자, 부서번호 출력하되
-- 'BLAKE'는 제외하고 화면에 출력
SELECT ENAME, HIREDATE, DEPTNO
FROM EMP
WHERE ENAME != 'BLAKE'
AND DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE');

-- [문제9] emp 테이블에서 평균 급여보다 더 많이 받는 사원들의 사번, 이름, 급여를 화면에 출력하되
-- 급여가 높은데서 낮은 순으로 화면에 출력
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP)
ORDER BY SAL DESC;

-- [문제10] emp 테이블에서 이름에 'T'를 포함하고 있는 사원들과 같은 부서에 근무하고 있는
-- 사원의 사번, 이름, 부서번호 출력
SELECT EMPNO, ENAME, DEPTNO
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%');

-- [문제11] 'SALES' 부서에서 근무하고 있는 사원들의 부서번호, 이름, 담당업무 출력
SELECT DEPTNO, ENAME, JOB
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');

-- [문제12] emp테이블에서 'KING'에게 보고하는 모든 사원의 이름, 급여, 관리자 출력
SELECT ENAME, SAL, MGR
FROM EMP
WHERE MGR = (SELECT DISTINCT EMPNO FROM EMP WHERE ENAME = 'KING');

-- [문제13] emp 테이블에서 자신의 급여가 평균 급여보다 많고, 이름에 'S'자가 들어가는 사원과
-- 동일한 부서에서 근무하는 모든 사원의 사번, 이름, 급여, 부서번호 출력
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO
                   FROM EMP
                   WHERE ENAME LIKE '%S%' 
                   AND SAL > (SELECT AVG(SAL) FROM EMP));

-- [문제14] emp 테이블에서 보너스를 받는 사원과 부서번호, 급여가 같은 사원의 이름, 급여, 부서번호 출력
SELECT ENAME, SAL, DEPTNO, COMM
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE COMM > 0)
AND SAL IN (SELECT SAL FROM EMP WHERE COMM > 0);

-- [문제15] products 테이블에서 상품의 판매가격이 판매가격의 평균보다 큰 상품의 전체 내용 출력
SELECT *
FROM PRODUCTS
WHERE OUTPUT_PRICE > (SELECT AVG(OUTPUT_PRICE) FROM PRODUCTS);

-- [문제16] products 테이블에 있는 판매가격에서 평균 가격 이상의 상품 목록을 구하되,
-- 평균을 구할 때 가격이 가장 큰 금액인 상품을 제외하고 평균을 구하여 출력
SELECT *
FROM PRODUCTS
WHERE OUTPUT_PRICE >(SELECT AVG(OUTPUT_PRICE)
                       FROM PRODUCTS 
                       WHERE OUTPUT_PRICE <>  (SELECT MAX(OUTPUT_PRICE) 
                                                FROM PRODUCTS));


-- [문제17] products 테이블에서 카테고리의 이름에 '에어컨' 이라는 단어가 포함된
-- 카테고리에 속하는 상품목록 출력
SELECT *
FROM PRODUCTS
WHERE CATEGORY_FK IN 
(SELECT CATEGORY_CODE FROM CATEGORY WHERE CATEGORY_NAME LIKE '%에어컨%');

-- [문제18] member10 테이블에 있는 고객 정보 중 마일리지가 가장 높은 금액을 가지는
-- 고객에게 보너스 마일리지 5000점을 더 주어 고객명, 마일리지, 마일리지+500점을 출력
SELECT MEMNAME, MILEAGE, MILEAGE+5000
FROM MEMBER10
WHERE MILEAGE = (SELECT MAX(MILEAGE) FROM MEMBER10);

-- GROUP BY 절
-- 특정컬럼이나 값을 기준으로 해당 레코드를 묶어서 자료를 관리할 때 사용
-- 보통은 특정 컬럼을 기준으로 집계를 구하는데 많이 사용
-- 보통은 그룹함수와 함게 사용하면 효과적으로 사용이 가능

SELECT DEPTNO FROM EMP ORDER BY DEPTNO;

SELECT DEPTNO
FROM EMP
GROUP BY DEPTNO;

-- EMP 테이블에서 부서별로 각 부서의 인원을 확인하고 싶은 경우
SELECT DEPTNO, COUNT(*)
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

-- EMP 테이블에서 부서별로 급여의 합계를 화면에 보여주세요.
SELECT DEPTNO, SUM(SAL) "급여 합계"
FROM EMP
GROUP BY DEPTNO
ORDER BY SUM(SAL) DESC;

-- [문제] EMP 테이블에서 부서별로 그룹을 지어서 부서의 급여 합계와
-- 부서별 인원수, 부서별 평균 급여, 부서별 최대 급여, 부서별 최소 급여를 구하여 출력
-- 단, 급여합계를 기준으로 내림차순으로 정렬
SELECT SUM(SAL) "급여 합계", COUNT(EMPNO) "인원수",
       AVG(SAL) "평균 급여", MAX(SAL)"최대 급여", MIN(SAL) "최소 급여"
FROM EMP
GROUP BY DEPTNO
ORDER BY SUM(SAL) DESC;

-- HAVING 절
-- GROUP BY 절 다음에 오는 조건절로 GROUP BY 정의 결과에 조건을 주어서 제안할 때 사용
-- GROUP BY 절에는 WHERE (조건절)이 올 수 없다.

-- PRODUCTS 테이블에서 카테고리 별로 상품의 갯수를 화면에 보여주세요.
SELECT CATEGORY_FK, COUNT(*)
FROM PRODUCTS
GROUP BY CATEGORY_FK
HAVING COUNT(*) >= 2
ORDER BY CATEGORY_FK;
