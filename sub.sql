-- emp 사원의 정보 
-- Dept 부서 정보
-- Salgrade 급여등급 정보 

-- 사원이름이 SMITH 이사람의 부서명?? 

select* from dept

select deptno from emp where ename = 'SMITH'
select dname from dept where deptno = (select deptno from emp where ename = 'SMITH')


-- SMITH 사원의 상사 이름?? 

select* from EMP

select mgr from emp where ename = 'SMITH'
select ename from emp where empno = (select mgr from emp where ename = 'SMITH')

-- 사원이름이 Ford의 상사의 부서명 ?? 

-- 평균 급여보다 높은 급여를 받는 사람들의 이름과 월급을 조회

select sal from emp where avg = (select sal from emp) <

select avg(sal) from emp

select ename, sal from emp 
where sal > (select avg(sal) from emp)

-- SMITH사원과 같은 직종 이면서, 급여를 SMITH 보다 더 많이 받는 사원들의 이름, 직종, 월급 조회 

select job, sal from emp where ename = 'SMITH'
select sal from emp where job = 'CLERK'
select ename, job, sal from emp where sal > 800

select ename, job, sal from emp 
where job = (select job from emp where ename = 'SMITH') 
and sal > (select sal from emp where ename = 'SMITH')  

-- MILLER 사원의 급여등급?? 

select sal from emp where ename = 'MILLER'
select* from salgrade
select grade from salgrade 
where losal <= (select sal from emp where ename = 'MILLER') 
and hisal >= (select sal from emp where ename = 'MILLER')

select grade from salgrade
where (select sal from emp where ename = 'MILLER') between losal and hisal 

-- KING 사원과 같은 부서의 사원들 중에서 가장 급여를 적게 받는 사원의 급여등급 

select deptno from emp where ename = 'KING'
select min(sal) from emp where deptno = 10

select grade from salgrade 
where (select min(sal) from emp where deptno = (select deptno from emp where ename = 'KING')) 
between losal and hisal

-- 뉴욕에 근무하는 부서원들의 평균급여등급과 동일한 등급의 사원들의 정보(ename, sal) 

select* from dept
select* from emp
select* from salgrade

select deptno from dept where loc = 'NEW YORK'
select avg(sal) from emp where deptno = 10
select grade from salgrade where 2916.6 between losal and hisal
select losal from salgrade where grade =4
select hisal from salgrade where()
select ename, sal from emp where sal between 2001 and 3000
-- select ename, sal from emp where sal >=2001 and sal <=3000

  select ename, sal from emp where sal between 
(select losal from salgrade where grade = 
(select grade from salgrade where
(select avg(sal) from emp where deptno=
(select deptno from dept where loc='NEW YORK'
 ))  between losal and hisal)
 )
and (select hisal from salgrade where grade = (select grade from salgrade where 
(select avg(sal) from emp where deptno = (select deptno from dept where loc = 'NEW YORK')) 
between losal and hisal))


	-- 평균급여보다 많이 받는 사원들의 부서명, 지역명. 
	
select* from emp
select* from dept 


select dname, loc from dept where deptno not in(
(select deptno from emp where sal > 
(select avg(sal) from emp))
 )

select deptno from emp where (select avg(sal)) < sal 

select dname, loc from dept where deptno in(10, 20, 30)


 -- 20번 부서의 사원들의 급여보다 많이 받는 사람들 
 select ename, sal from emp 
 where sal > (select min(sal) from emp where deptno =20)
 
 select ename, sal from emp 
 where sal > any (select sal from emp where deptno =20)
 
 select* from (select sum(sal) s, avg(sal) a from emp) E
 
 
 select deptno, sum(sal) s, avg(sal) a from emp 
 group by deptno 
 having avg(sal)>2000 
 
 select * from
 (select deptno, sum(sal) s, avg(sal) a from emp 
 group by deptno) G
 where a>2000
 
 ------------------------------------------------------------------------------------
 -- 사원의 이름이 SMITH, 사번, 직종, 부서명, 지역명 
select empno, job from emp where ename = 'SMITH'
select deptno from emp where ename = 'SMITH'
select dname, loc from dept where deptno = 20

(select dname, loc from dept 
where deptno = (select deptno from emp where ename ='SMITH'))

 -- Oracle 전용 문구 
 select* from emp, dept  
 where emp.deptno = dept.deptno
 
 -- ANSI 조인 
  --SELECT
  --	   FROM 테이블명 A {INNER, LEFT/RIGHT OUTER, NATURAL, SELF} JOIN 테이블명 B
  --	   ON {A.컬럼명 = B.컬럼명}/ USING(컬럼명)
  --	   WHERE 조건식 
  select E.empno, E.job, D.deptno, D.dname, D.loc
  from emp E inner join dept D
  on E.deptno = D.deptno 
  where ename='SMITH';
  
  select*
  from emp inner join dept 
  using(deptno)
  where ename='SMITH';
  
  
 select count(empno) from emp
 select count(deptno) from dept
 
 select* from emp 
 
 
 -- 사원번호, 사원의 이름, 상사의 사원번호, 상사의 이름 
 
 select E.empno, E.ename, E.mgr, M.empno, M.ename 
 from emp E FULL outer JOIN emp M 
 on E.mgr = M.empno
 
 
 select* from point where 
 
 select num from member where id = ? and pw = ? 
 



 