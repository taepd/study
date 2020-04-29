/*
CREATE TABLE EMP    --create는 commit 필요없다
(EMPNO number not null,
ENAME VARCHAR2(10),
JOB VARCHAR2(9),
MGR number ,
HIREDATE date,
SAL number ,
COMM number ,
DEPTNO number );

--alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';


INSERT INTO EMP VALUES
(7369,'SMITH','CLERK',7902,'1980-12-17',800,null,20);
INSERT INTO EMP VALUES
(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);
INSERT INTO EMP VALUES
(7521,'WARD','SALESMAN',7698,'1981-02-22',1250,200,30);
INSERT INTO EMP VALUES
(7566,'JONES','MANAGER',7839,'1981-04-02',2975,30,20);
INSERT INTO EMP VALUES
(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,300,30);
INSERT INTO EMP VALUES
(7698,'BLAKE','MANAGER',7839,'1981-04-01',2850,null,30);
INSERT INTO EMP VALUES
(7782,'CLARK','MANAGER',7839,'1981-06-01',2450,null,10);
INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,'1982-10-09',3000,null,20);
INSERT INTO EMP VALUES
(7839,'KING','PRESIDENT',null,'1981-11-17',5000,3500,10);
INSERT INTO EMP VALUES
(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,'1983-01-12',1100,null,20);
INSERT INTO EMP VALUES
(7900,'JAMES','CLERK',7698,'1981-10-03',950,null,30);
INSERT INTO EMP VALUES
(7902,'FORD','ANALYST',7566,'1981-10-3',3000,null,20);
INSERT INTO EMP VALUES
(7934,'MILLER','CLERK',7782,'1982-01-23',1300,null,10);




COMMIT;


CREATE TABLE DEPT
(DEPTNO number,
DNAME VARCHAR2(14),
LOC VARCHAR2(13) );

INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');

COMMIT;

CREATE TABLE SALGRADE
( GRADE number,
LOSAL number,
HISAL number );

INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);
COMMIT;
*/

select*from emp;
select*FROM dept;
SELECT*FROM salgrade;

/*
SELECT [DISTINCT] {*, column [alias], . . .}      // 대괄호는 생략가능, 중괄호는 꼭 써야함
FROM table_name
[WHERE condition]
[ORDER BY {column, expression} [ASC | DESC]];
*/




-- 사원 테이블에서 모든 데이터를 출력하세요
SELECT*FROM emp;  --쿼리 문자는 대소문자 구별 안해요


--2. 특정 컬럼 데이터 출력하기
SELECT empno, ename, sal from emp;
    
--3. 컬럼에 가명칭(별칭)(alias) 부여하기
SELECT empno 사번, ename 이름 from emp;

SELECT empno "사    번", ename "이   름"
from emp;

--정식(표준) (ansi 문법)
SELECT empno as "사    번", ename as "이   름"
from emp;

--Oracle 데이터 관리(문자열: 대소문자 구분)
--문자열 표기('문자열')
--소문자 'a' 대문자 'A'는 다른 문자열이다
SELECT empno, ename
from emp
WHERE ename='KING';

--Oracle SQL 언어: 연산자(결합 연산자(||), 산술 연산자(+)) 구분
--java + (숫자 + 숫자 >> 연산)
--java + (문자열 + 문자열 >> 결합)
--TIP) ms-sql(+ 연산, 결합)

SELECT '사원의 이름은' || ename ||'입니다' as "사원정보"
FROM emp;

--empno, ename >> 컬럼 >> 타입 
--타입(자료형) : 숫자, 문자(문자열), 날짜 ...

desc emp; 
/*
테이블의 기본 정보(컬럼명, null여부, 타입)
이름       널?       유형           
-------- -------- ------------ 
EMPNO    NOT NULL NUMBER       
ENAME             VARCHAR2(10) 
JOB               VARCHAR2(9)  
MGR               NUMBER       
HIREDATE          DATE         
SAL               NUMBER       
COMM              NUMBER       
DEPTNO            NUMBER      
*/

SELECT empno || ename  --숫자||문자열 (내부적으로 숫자->문자열)
from emp;
/*
7369SMITH
7499ALLEN
7521WARD
7566JONES
*/

-- 사장님.. 우리 회사에 직종이 몇개나 있나?
SELECT job from emp;

-- distinct : 중복 데이터 제거  (그룹핑을 해줌)
SELECT DISTINCT job from emp;

-- 그룹의 그룹의 하나씩 보여줌
SELECT DISTINCT job, deptno from emp order by job; 

SELECT DISTINCT deptno, job from emp order by deptno; 

/*
Oracle 연산자는 Java 거의 동일(+,*,-,...)
%자바(나머지), %오라클 (검색 패턴)
오라클(+,-,*,/) + 나머지 함수 >>Mod()
*/

--사원 테이블에서 사원의 급여를 100달러 인상한 결과를 출력하세요
--desc emp;
SELECT empno, sal, sal + 100 as "인상급여" from emp;


--dual 임시 테이블
SELECT 100+100 from dual;
SELECT 100||100 from dual;  --내부적으로 형변환 100100
SELECT '100'+100 from dual; -- +연산자는 산술 형변환해서 산술연산함
SELECT '100A' +100 from dual; -- error ORA-01722: invalid number

/*
비교연산자
>, <, <=
Oracle 같다(=), 같지 않다(!=)

논리연산자
AND, OR, NOT
*/

--조건절(원하는 row 가지고 오겠다)
SELECT *
FROM emp
WHERE sal >=3000;

SELECT
    empno, ename, sal
FROM emp
where sal > 3000;

--이상/이하 ('=' 포함), 초과/미만 잘 구분해야 함


--사번이 7788번인 사원의 사번, 이름, 직종, 입사일을 출력하세요
--관리자, 개발자, 튜닝, 설계
SELECT empno, ename, job, hiredate  --3
from emp                                            --1
where empno=7788;                            --2

--사원의 이름이 king인 사원의 사번, 이름, 급여 정보를 출력하세요
SELECT empno, ename, sal
from emp
where ename='KING';

--논리(AND, OR)
--급여가 2000달러 이상이면서 직종이 manager인 사원의 모든 정보를 출력하세요
SELECT *
from emp
where sal>=2000 and job='MANAGER';


--오라클 날짜는 DB서버의 날짜를 가져옴)
--오라클 날짜(sysdate)

SELECT SYSDATE from dual;

--현재 접속한 사용자(session)가 날짜 형식을 수정
alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

SELECT * from SYS.nls_session_parameters;  --시스템 설정을 가지고 있는 환경테이블
--NLS_DATE_FORMAT	RR/MM/DD
--NLS_LANGUAGE	KOREAN
--NLS_TIME_FORMAT	HH24:MI:SSXFF

select hiredate from emp;

--입사일 1980-12-17 인 사원의 모든 정보를 출력하세요
SELECT *
from emp
where hiredate = '1980-12-17';

SELECT *
from emp
where hiredate = '1980/12/17';  -- 이것도 된다

SELECT *
from emp
where hiredate = '80-12-17';

--사원의 급여가 2000이상이고 4000이하인 모든 사원의 정보를 출력하세요
SELECT *
from emp
where 2000<=sal  and sal <=4000;

--연산자: between A and B (= 포함)
--미만/초과에서는 사용금지
SELECT *
from emp
where sal BETWEEN 2000 AND 4000;

--부서번호가 10 또는 20또는 30번인 사원의 사번, 이름, 급여, 부서번호 출력
SELECT
    empno, ename, sal, deptno
FROM emp
where deptno in (10,20,30);
--in 연산자를 풀어 쓰면: where deptno=10 or deptno=20 or deptno=30;

--부서번호가 10또는 20이 아닌 사원의 사번, 이름, 급여, 부서번호를 출력하세요
SELECT
    empno, ename, sal, deptno
FROM emp
where deptno not in (10,20);

--POINT: Oracle에서 데이터가 없다는 값 표현 >> null
--null 필요악

CREATE TABLE member(
    userid varchar2(20) not null,  --not null: 필수 입력
    name varchar2(20) not null, --필수 입력
    hobby varchar2(50) -- default null(null값 허용) 데이터 안받으면 null로 셋팅
);

select * from member;
insert into member(userid, name) values('hong', '홍길동');

insert into member(userid, name, hobby)
values('kim', '김씨', '게임');

SELECT * from member;
    
--실반영 하려면 commit 해야 한다. 그렇지 않으면 프로그램 종료시 삭제
commit;

--수당(comm)을 받지 않는 모든 사원의 정보를 출력하세요
--0도 데이터 취급(받는 조건에 포함)
SELECT
    *
FROM emp
where comm=null;  -- 이렇게 쓰면 아무것도 안나온다

--null비교 : is null, is not null
--'is null'이렇게 써야 한다
select * from emp where comm is null;

--수당(comm)을 받는 모든 사원의 정보를 출력하세요
SELECT
    *
FROM emp
where comm is not null;

--사원 테이블에서 사번, 이름, 급여, 수당, 총급여를 출력하세요
--총급여(급여+수당)

SELECT empno, ename, sal, comm, sal+comm as "총급여"  --comm이 null인 사람은 총급여도 null이 되버린다

FROM emp;

--POINT 
--1. null과의 모든 연산은 그 결과가 모두 null
--2. 위 문제 해결: nvl(), nvl2()  >> null값을 replace 치환할 수 있는 함수
--Tip) ms-sql :convert(), my-sql: IFNULL()

select null+100 from dual;
select 100+nvl(null, 0) from dual; 
select comm, nvl(comm, 1111) from emp;

--위 문제를 다시 풀어보면

select empno, ename, sal, comm, sal+nvl(comm,0) as "총급여"
from emp;


--사원의 급여가 1000이상이고 수당을 받지 않는 사원의 사번, 이름, 직종, 급여, 수당을 출력하세요

select empno, ename, job, sal, comm
from emp
where sal>=1000 and comm is null;

--여기까지가 기본 파트 (DQL)
----------------------------------------------

--DQL(Data Query Language): SELECT (데이터 가져오기)
--DDL(Data Definition Language): create, alter, drop (객체(테이블) 생성, 수정, 삭제)
--DML(Data Manipulation Language): insert, update, delete(데이터 조작) 

--java: class Board {private int boardno}
--Oracle: create table Board (boardno number not null)

create table board(
    boardid number not null, --숫자, 필수 입력
    title varchar2(20) not null, --한글10자, 영문,특수,공백 20자, 필수 입력
    content varchar2(2000) not null, --필수 입력
    hp varchar2(20) -- default null 허용(필수 입력X)    
);

select * from board;

--DML(데이터 조작어) 실 반영 여부를 결정
--insert
--update
--delete
--반드시 그 결과를 반영할지, 취소할지를 의사결정
--commit(실제 반영)
--rollback(실제 반영 취소)

insert into board(boardid, title, content)
values(100, '오라클', '오 할만한데');


SELECT
    *
FROM board;

commit;  -- commit 해야만 다른 세션에서도 조회 가능

insert into board(boardid, title, content)
values(200, '자바', '그립다');

SELECT
    *
FROM board;
--ROLLBACK; 롤백하면 해당 세션에서도 데이터 사라짐

commit;

insert into board(boardid, title, content, hp)
values(300, '오늘', '수업중', '010-000-0000');

commit;

select * from board;

select boardid, nvl(hp, 'EMPTY') as "hp" from board;

--문자열 검색
--주소검색: [역] 입력 >> 역삼동, 역동, .... (Like 패턴 검색)
--문자열 패턴 검색 연산자: like
--like 연산자 도움 (와일드 카드 문자 (%: 모든 것, _: 한 문자) 결합

select ename
from emp where ename like '%A%';  -- ename 컬럼의 데이터 중에서 A가 들어간 모든 것 검색 

select ename
from emp where ename like '%a%'; --문자열 데이터 대소문자 구별(엄격)

select ename
from emp where ename like 'A%'; --이름의 첫 글자가 A인 사람 검색

select ename
from emp where ename like '%S'; --이름의 마지막 글자가 S인 사람

select ename
from emp where ename like '%LL%';

select ename
from emp where ename like '%L%L%';  --LL이 붙어있어도 되고 띄어있어도 됨

select ename
from emp where ename like '_A%'; --첫 글자는 어떤 것이 와도 상관없고 두 번째 글자는 A이고 뒤는 아무거나 상관없음

--정규 표현식(java/DB/script 등)
--regexp_like

select * from emp where REGEXP_LIKE (ename, '[A-C]');
--정규 표현 예제 5개 만들기(추후 카페)

--------------------------------------

--데이터 정렬하기
--order by 컬럼명: 문자열, 숫자, 날짜
--오름차순: asc(낮은 순, default)
--내림차순: desc(높은 순)

select *
from emp
order by sal;  --생략하면 asc

select *
from emp
order by sal asc;

--급여를 많이 받는 순으로 정렬
select * from emp order by sal desc;

--입사일이 가장 늦은 순으로 정렬해서 사번, 이름, 급여, 입사일 데이터를 출력
--가장 최근에 입사한 순으로

select empno, ename, sal, hiredate from emp order by hiredate desc;

/*
select           3
from              1
where           2
order by        4
*/


select empno, ename, sal, job, hiredate
from emp
where job ='MANAGER'
order by hiredate desc;

--order by 컬럼명 desc, 컬럼명 asc, 컬럼명 desc
select job, deptno
from emp
order by job asc, deptno desc;  --grouping 원리

---------------------------------------

--연산자
--합집합(union) : 테이블과 테이블의 데이터를 합치는 것(기본: 중복값 배제)
--합집합(union all) : 테이블과 테이블의 데이터를 합치는 것(기본: 중복값 허용)

create table uta (name varchar2(20));

insert into uta(name) values('AAA');
insert into uta(name) values('BBB');
insert into uta(name) values('CCC');
insert into uta(name) values('DDD');

commit;

select * from uta;

create table ut (name varchar2(20));

insert into ut(name) values('AAA');
insert into ut(name) values('BBB');
insert into ut(name) values('CCC');

commit;

select * from ut;

--union 중복 데이터 삭제
select * from ut
union
select * from uta;

--union all  중복 데이터 허용
select * from uta
union all
select * from ut;

--union
--1. 대응되는 컬럼의 타입이 동일해야 함
select empno, ename from emp
union
select dname, deptno from dept;  -- 문자열과 숫자가 대응하게 되어 에러

select empno, ename from emp
union
select deptno, dname from dept;

--2. 대응되는 컬럼의 개수가 동일해야 함
select empno, ename, job, sal from emp
union
select deptno, dname, loc, null from dept;  --null을 이용해서 대응을 맞춤

--실무 >> subquery (in line view)
select empno, ename
from(
    select empno, ename from emp   --가상 테이블화
    union
    select deptno, dname from dept
    ) order by empno desc;
    
    
--여기까지 초보 단계. 단일 테이블 다룸
------------------------------
--오라클 함수(보조 교재(pdf) : 50p)
/*
단일 행 함수의 종류 
1) 문자형 함수:
2) 숫자형 함수:  
3) 날짜형 함수:
4) 변환형 함수:
5) 일반적인 함수: 
*/

--참고
select * from SYS.nls_database_parameters;
--NLS_CHARACTERSET	AL32UTF8 >>한글 3byte 인식
--KO16KSC5601 2Byte (현재 변환하면 한글 다 깨짐)

--문자열 함수
select initcap('the super man') from dual;

select lower('AAA'), upper('aaa') from dual;

select ename, lower(ename) as "ename" from emp;

select * from emp where lower(ename) = 'king';

--문자열 개수
select length('abcd') from dual;  --4

select length('홍길동') from dual; --3

select length(' 홍 a길 동') from dual; --7

--결합 연산자 ||
--concat()

select 'a' || 'b' || 'c' as "data" from dual; --abc
select concat('a','b') from dual;  --매개변수 제한으로 2개만 가능

SELECT concat(ename, job) as "concat" from emp;
select ename || '     ' || job as "concat" from emp; --중간 공백

--부분 문자열 추출
--java(substring)
--oracle(substr)

select substr('ABCDE',2,3) from dual; --BCD   'ABCDE'에서 2번째 문자부터 3개를 추출

select substr('ABCDE',2) from dual; --BCDE

select substr('ABCDE',-2) from dual; --DE 뒤에서부터 셈

/*
사원 테이블에서 ename 컬럼 데이터에 대해서 첫 글자는 소문자로 나머지 문자는 대문자로 출력하세요
단, 위 결과를 하나의 컬럼으로(컬럼 이름 full name, 첫 글자와 나머지 문자 사이에 공백 하나 넣어서 출력)
SMITH -> [s MITH]
*/

select '['|| lower(substr(ename,1,1))||' '||substr(ename,2)||']'as "full name" from emp;

--lpad, rpad (채우기)
select lpad('ABC',10,'*') from dual;  왼쪽에 10칸 중 'ABC' 제외하고 남는 것을 '*'로 채움
select rpad('ABC',10,'^') from dual;

--Quiz
--사용자 비번: hong1006
--화면: ho****** 출력하고 싶어요(비번: 1004 >> 10**)

select rpad(substr('hong1006',1,2),length('hong1006'),'*') from dual;
select rpad(substr('1004',1,2),length('1004'),'*') from dual;

--emp 테이블에서 ename 컬럼의 데이터를 출력하는데 첫 글자만 출력하고 나머지 *로 표시하세요

select rpad(substr(ename,1,1),length(ename),'*') as "ename" from emp;

create table member2(
    id NUMBER,
    jumin varchar2(14)
);

insert into member2(id, jumin) values(100, '123456-1234567');
insert into member2(id, jumin) values(200, '234567-1234567');

commit;

select * from member2;

--하나의 컬럼으로 결과값을 출력
--100 : 123456-*******
--200 : 234567-*******
--컬럼명은 "juminnumber"

select id ||' : '|| rpad(substr(jumin,1,7),length(jumin),'*') as "juminnumber" from member2;

--trim 함수
--[첫 매개변수에서 두번째 문자들를 지워라]
select rtrim('MILLER','ER') from dual;  --MILL
select ltrim('MILLLLLLLLLLER','MIL') from dual;  --ER

select '>' || rtrim('MILLER         ',' ') || '<' from dual; -->MILLER<

--치환함수(replace)
select ename, replace(ename, 'A', '와우^^') from emp;

--------문자열 함수 끝-------------

--[숫자 함수]
--round(반올림 함수)
--trunc(절삭 함수)
--mod (나머지 구하는 함수)

select round(12.567,0) as "r" from dual;  --13
select round(12.567,1) as "r" from dual;   --12.6
select round(15.567,-1) as "r" from dual;   --20

select trunc(12.567,0) as "r" from dual;  --12
select trunc(12.567,1) as "r" from dual;   --12.5
select trunc(15.567,-1) as "r" from dual;   --10

--나머지
select 12/10 from dual;   --1.2
select mod(12, 10) from dual;  --2

select mod(0,0) from dual; --이게 되네

------숫자형 함수 끝---------------

--[날짜 함수]--

select sysdate from dual;
--alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

--날짜 연산(POINT)
--Date + Number >> Date
--Date - Number >> Date
--Date - Date >> Number (일수 나옴)

select hiredate from emp;

select MONTHS_BETWEEN('2018-01-01','2010-01-01') from dual;  --96  (앞매개-뒤매개)

select months_between(sysdate, '2010-01-15') from dual; --122.565016054360812425328554360812425329

select round(months_between(sysdate, '2010-01-15'),1) from dual; --122.6

--POINT
--날짜 형식의 문자열을 날짜로 바꾸는 함수 (to_date())
select to_date('2020-04-01') + 100 from dual; --2020-07-10 00:00:00

select sysdate + 1000 from dual; --2022-12-27 12:27:08


--Quiz
--1. 사원 테이블에서 사원들의 입사일에 현재 날짜까지 근속월수를 구하세요
--단, 근속월수는 정수부분만 출력하세요(반올림하지 마세요)

select ename, hiredate, trunc(months_between(sysdate, hiredate),0) as "근속 월수" from emp;

--2. 한달이 31일이라는 기준에서 근속월수를 구하세요(반올림하지 마세요)
--함수 사용하지 말고 연산으로 (날짜 - 날짜 >> 150일)

select ename, hiredate, trunc((sysdate - hiredate)/31,0) as "근속 월수" from emp;

----------------------------------------------

/*
[변환 함수]: TODAY POINT
오라클은 문자, 숫자, 날짜 형식밖에 없음. 
to_char() : 숫자 -> 문자(1000 -> $1000), 
                날짜 -> 문자(2020-01-01 -> 2020년01월01일) formating

to_date() : 문자 -> 날짜 >> select to_date('2020-12-12') + 100

to_number(): 문자 -> 숫자 (내부 자동 형변환)
select '100' + 100 from dual; --200 자동 형변환 
실제론
select to_number('100') + 100 from dual;                  
*/

-- to_number (문자 -> 숫자) 자동 형변환
select '1' +100 from dual;  --101
select to_number('1') + 100 from dual; --101

--to_char(): format >> 숫자, 날짜 (형식 문자)
select to_char(sysdate) || '일' from dual; --2020-04-01 12:55:31일

--pdf 69p참고
select sysdate, 
to_char(sysdate, 'YYYY') || '년' as "YYYY", --2020년
to_char(sysdate, 'year'), --twenty twenty
to_char(sysdate,'MM'),  --04
to_char(sysdate, 'DD'), --01
to_char(sysdate, 'DY') --수
from dual;

--Quiz
--입사월이 12월인 사원들의 사번, 이름, 입사일, 입사년도, 입사월을 출력하세요

select empno as "사번" , ename as "이름", to_char(hiredate, 'DD') as "입사일" , to_char(hiredate, 'YYYY') as "입사년도" , to_char(hiredate, 'MM') as "입사월"
from emp
where to_char(hiredate, 'MM') = 12;

select to_char(hiredate, 'YYYY MM DD') from emp; 

select to_char(hiredate, 'YYYY"년" MM"월" DD"일"') from emp; --1980년 12월 17일


--to_char() 숫자 -> 문자로(형식 문자)
--pdf 파일 71p 
--100000 >> 출력 >> $1,000,000 (문자)

select '>'||to_char(12345,'99999999999')||'<' from dual;  -->          12345<  앞 공간을 공백으로 채운다
select '>'||to_char(12345,'09999999999')||'<' from dual;  --> 00000000012345< 앞 공간을 0으로 채운다

select '>'||to_char(12345,'$9,999,999,999')||'<' from dual; -->        $12,345<

select sal, to_char(sal, '$999,999') from emp;  --800	     $800


--HR 계정으로 전환------------------------

select * from employees;

/*
사원테이블(employees)에서 사원의 이름은 last_name , first_name 합쳐서 fullname 별칭 부여해서 출력하고
입사일은  YYYY-MM-DD 형식으로 출력하고 연봉(급여 *12)을 구하고 연봉의 10%(연봉 * 1.1)인상한 값을
출력하고 그 결과는 1000단위 콤마 처리해서 출력하세요
단 2005년 이후 입사자들만 출력하세요 그리고 연봉이 높은 순으로  출력하세요
*/

select last_name||' '||first_name as fullname, 
to_char(hire_date, 'YYYY-MM-DD') as "05년 이후 입사자", 
salary*12 as "연봉", 
to_char((salary*12)*1.1, '$999,999,999') as "인상된 연봉"

from EMPLOYEES

where to_char(hire_date, 'YYYY') >=2005

order by "연봉" desc;  -- 별칭도 올 수 있다

---bit 계정으로

-------변환 환수 끝-----------

--[일반 함수(프로그래밍적인 성격)]--
--nvl(), nvl2() >> null 처리 담당
--decode() 함수 >> java if문(switch문) 유사
--case() 함수 >> java if문(switch문) 유사

select comm, nvl(comm, 0) from emp;

create table t_emp(
    id number(6),
    job varchar2(20)
);
insert into t_emp(id, job) values(100,'IT');
insert into t_emp(id, job) values(200,'SALES');
insert into t_emp(id, job) values(300,'MGR');
insert into t_emp(id) values(400);
insert into t_emp(id, job) values(500,'MGR');

select * from t_emp;

commit;

select id, decode(id, 100, '인사부', 200, '관리부', 300,'회계부','기타부서') as "부서"
from t_emp;

select deptno, decode(deptno, 10,'인사부',    --if문(switch문)과 유사
                                               20,'관리부',
                                               30,'회계부',
                                               '기타부서') as "부서"
from emp;

--Quiz
CREATE TABLE t_emp2(
id NUMBER(2),
jumin CHAR(7)
);
INSERT INTO t_emp2(id, jumin) VALUES(1,'1234567');
INSERT INTO t_emp2(id, jumin) VALUES(2,'2234567');
INSERT INTO t_emp2(id, jumin) VALUES(3,'3234567');
INSERT INTO t_emp2(id, jumin) VALUES(4,'4234567');
INSERT INTO t_emp2(id, jumin) VALUES(5,'5234567');
COMMIT;
SELECT * FROM t_emp2;

/*
t_emp2 테이블에서 id, jumin 데이터를 출력하되 jumin컬럼의 앞자리가 1이면 '남성', 2이면 '여성' 3이면 '중성' 그 외는 '기타'라고 출력하세요
*/

select id, jumin, decode(substr(jumin,1,1), 1,'남성',2,'여성',3,'중성','기타') as "gender"
from t_emp2;


--quiz
select deptno, ename, decode(deptno,20,
                                                decode(ename,'SMITH', 'HELLO', 'WORLD') 
                                                ,'ETC')  --decode 중첩 가능
from emp;

--case문
--java switch문
/*
    case 조건식 when 결과1 then 출력1
                     when 결과2 then 출력2
                     when 결과3 then 출력3
                     else 출력4
    end "컬럼명"
*/

create table t_zip(
    zipcode number(10)
);

insert into t_zip(zipcode) values(2);
insert into t_zip(zipcode) values(31);
insert into t_zip(zipcode) values(32);
insert into t_zip(zipcode) values(33);
insert into t_zip(zipcode) values(34);

commit;

select * from t_zip;

select '0' || to_char(zipcode), 
            case zipcode when 2 then '서울'
                                 when 31 then '경기'
                                 when 32 then '강원'
                                 when 41 then '제주'
                                 else '기타지역'
        end "region_name"
from t_zip;        


/*
사원테이블에서 사원급여가 1000달러 이하면 '4급'
1001달러 2000달러 이하면 '3급'
2001달러 3000달러 이하면 '2급'
3001달러 4000달러 이하면 '1급'
4001달러 이상이면 '특급' 이라는 데이터를 출력하세요

1. case 컬럼명 when 결과 then 출력 (= 일 때)
2. case when 컬럼명 조건 비교식 then  (비교 일 때)
*/

select ename, sal, case when sal<=1000 then '4급'  
                                    when sal<=2000 then '3급'    --sal between 1001 and 2000 해도 됨
                                    when sal<=3000 then '2급'
                                    when sal<=4000 then '1급'
                                    else '특급'
        end "급여 등급"

from emp
order  by sal desc;

-- [집계 함수] pdf 75p

/*
1. count(*) >>row 줄수, count(컬럼명) >> 데이터 건수(null을 포함하지 않는다)
2. sum()
3. avg()
4. max()
5. min()
등등..

집계함수
1. 집계함수는 group by절과 같이 사용
2. 모든 집계함수는 null 값을 무시
3. select 절에 집계함수 이외 다른 컬럼이 오면 반드시 그 컬럼은 group by 절에 명시
*/

select count(*) from emp;  --14
select count(comm) from emp; --6 데이터 건수는 null을 포함하지 않으므로
select count(empno) from emp; --14

select count(nvl(comm, 0)) from emp;  --14  null이 나오면 nvl이 따라간다고 봐야 함

--급여의 합
select sum(sal) as "급여합" from emp;  --29025

select avg(sal) as "평균 급여" from emp;  --2073.214285714285714285714285714285714286
select trunc(avg(sal)) as "평균 급여" from emp; --2073

--사장님이 회사 총 수당이 얼마나 지급되고 있나? (수당의 평균)
select round(avg(comm)) as "수당 평균" from emp; --722

--노조... 보고서 .. 누구냐

select trunc(avg(nvl(comm,0))) from emp; --309

--회사 규정이 (전체 사원수로 나눈다.. 309)
--회사 규정이 (받는 사원 수로 나눈다.. 722)

--검증: 코드 
select count(*) from emp where comm is null;  --8 이런 식으로 null 체크를 해주면 좋다

select max(sal) from emp;

select min(sal) from emp;

--POINT
select empno, count(empno) from emp;  --error not a single-group group function. empno 14건, count(empno) 1건

select sum(sal), avg(sal), max(sal), min(sal), count(sal), count(*) from emp;  --이건 다 1건 출력이므로 문제가 없다 grouping에 문제 없음

--부서별 평균 급여를 출력하세요
select deptno, avg(sal) 
from emp
group by deptno;  --grouping이 필요하다

--직종별 평균 급여를 구하세요
select job, avg(sal)
from emp
group by job;

--직종별 평균 급여, 급여 합, 최대 급여, 최소 급여, 급여 건수를 출력하세요
select job, round(avg(sal)) as "평균 급여",
sum(sal) as "급여 합",
max(sal) as "최대 급여",
min(sal) as "최소 급여",
count(sal) as "급여 건수"
from emp
group by job
order by "평균 급여" desc;

/*
grouping 원리

distinct 컬럼명1, 컬럼명2
order by 컬럼명1, 컬럼명2
group by  컬럼명1, 컬럼명2, 컬럼명3..
*/


--부서별, 직종별 급여의 합을 구하세요

select deptno, job, sum(sal) , count(sal)
from emp
group by deptno, job
order by deptno;

/*
select        4
from           1
where        2
group by    3
order by     5
*/

--직종별 평균 급여가 3000달러 이상인 사원의 직종과 평균급여를 출력하세요

--**group by의 조건절 >> having**

select ename, job, avg(sal) as "평균 급여" 
from emp
group by job, ename
having avg(sal)>=3000
order by "평균 급여" desc;

/*
하나의 테이블을 대상으로 쓸 수 있는 구문
select
from
where
group by having
order by
*/


/* 사원테이블에서 직종별 급여합을 출력하되 수당은 지급 받고 급여의 합이 5000 이상인 사원들의 목록을 출력하세요
--급여의 합이 낮은 순으로 출력하세요 */

select ename, job, sum(sal) as "급여합" 
from emp
where comm is not null
group by ename, job
having sum(sal)>=5000
order by "급여합" asc;


/* 사원테이블에서 부서 인원이 4명보다 많은 부서의 부서번호 ,인원수 , 급여의 합을 출력하세요 */

select deptno, count(deptno)as"부서별 인원수", sum(sal) as "급여합"
from emp
group by deptno
having count(deptno)>4;

--null값도 포함해서 카운트하려면 *를 쓰면 된다
select deptno, count(*)as"부서별 인원수", sum(sal) as "급여합"
from emp
group by deptno
having count(*)>4;


/* 사원테이블에서 직종별 급여의 합이 5000를 초과하는 직종과 급여의 합을 출력하세요
단 판매직종(salesman) 은 제외하고 급여합으로 내림차순 정렬하세요 */

select job, sum(sal) as "급여합"
from emp
where not (job='SALESMAN')  --job != 'SALESMAN'
group by job
having sum(sal)>5000
order by sum(sal) desc;

------------------------------------------
--[JOIN] (pdf 85p)
-- 관계형 데이터 베이스(RDBMS) >> ORDB(객체 관계형 데이터 베이스. 지금은 안씀) >> Framework(객체매핑:JPA, Mybatis)

/*
create table M (M1 char(6) , M2 char(10));
create table S (S1 char(6) , S2 char(10));
create table X (X1 char(6) , X2 char(10));

insert into M values('A','1');
insert into M values('B','1');
insert into M values('C','3');
insert into M values(null,'3');
commit;

insert into S values('A','X');
insert into S values('B','Y');
insert into S values(null,'Z');
commit;

insert into X values('A','DATA');
commit;

select * from m;
select * from s;
select * from x;
*/

--종류
--1. 등가조인(equi join) >> [inner]join
--원테이블과 대응되는 테이블에 있는 컬럼의 데이터를 1:1로 매핑
--JOIN문법
--1. SQL JOIN문법
--2. ANSI 문법(권장)

--SQL JOIN 문법
select *
from m, s
where m.m1 = s.s1;

select m.m1, m.m2, s.s2
from m, s
where m.m1=s.s1;   

--ANSI JOIN 문법(권장)
--where (from 조건절)
--where에서 join 조건과 일반 조건을 혼재하면 혼란..
--join 조건 분리 >> on 절

select *
from m inner join s
on m.m1 = s.s1;

select m.m1, m.m2, s.s2
from m join s -- inner 생략 가능
on m.m1 = s.s1;

--사원 번호, 사원 이름, 사원 부서 번호, 사원 부서명 알고 싶어요
select emp.empno, emp.ename, emp.deptno, dept.dname
from emp join dept
on emp.deptno = dept.deptno;

--join 테이블에 가명칭(alias)부여 >> alias로 접근
select e.empno, e.ename, e.deptno, d.dname
from emp e join dept d
on e.deptno = d.deptno;

--join (2, 3 ....) 여러 개 테이블

--SQL 문법
select m.m1, m.m2, s.s2,x.x2
from m, s, x
where m.m1=s.s1 and s.s1=x.x1;

--ANSI  문법
select m.m1, m.m2, s.s2, x.x2
from m join s on m.m1 = s.s1
           join x on s.s1=x.x1;




-------HR 계정으로 이동-----------

select * from employees;
select * from departments;
select * from locations;

--1. 사번, 이름(last_name), 부서번호, 부서이름 출력하세요

select e.employee_id, e.last_name, d.department_id, d.department_name
from employees e join departments d on e.department_id = d.department_id;
--106명
--107명인데 why >> 106명?
select count(*) from employees;   --107
--join은 null 포함하지 않음
select * from employees where department_id is null;
--178번 사원이 부서id가 null이었음
--등가조인으로는 해결 불가

--2. 사번, 이름(last_name), 부서번호, 부서명, 지역코드, 도시명 출력하세요
select e.employee_id, e.last_name, d.department_id, d.department_name, l.postal_code,l.city
from employees e join departments d on e.department_id = d.department_id
                            join locations l on d.location_id = l.location_id;

-------bit 계정으로 이동--------------

--2. 비등가 조인(non-equi join) => 의미만 존재 => 등가조인 문법
--원테이블과 대응되는 테이블에 있는 컬럼이 1:1 매핑되지 않는 경우
select * from emp;
select * from salgrade;

select e.empno, e.ename, e.sal, s.grade
from emp e join salgrade s
on e.sal between s.losal and s.hisal;



--3. outer join (equi join + null)
--outer join (주종관계 파악) >> 주가 되는 테이블에 있는 남은 데이터 가져오기
--문법 3가지
--left outer join(왼쪽 주인)
--right outer join(오른쪽 주인)
--full outer join(왼쪽 주인+오른쪽 주인 >>union)
--outer 생략 가능

select *
from m join s
on m.m1 = s.s1;

select *
from m left outer join s
on m.m1 = s.s1;

select *
from m right outer join s
on m.m1 = s.s1;

select *
from m full outer join s
on m.m1 = s.s1;


-----------hr계정으로----------
--department_id가 null인 178번 사원도 나오게 출력
select e.employee_id, e.last_name, d.department_id, d.department_name
from employees e left join departments d --outer 생략해도 된다
on e.department_id = d.department_id
order by e.employee_id;

------------------------------
--self join (자기참조) -> 의미 -> 문법(등가조인)
--하나의 테이블에서 특정 컬럼이 다른 컬럼을 참조하는 경우
--join(테이블 1개 이상이어야 함)

select e.empno, e.ename, m.empno, m.ename
from emp e left join emp m   --(alias를 달리해서 하나의 테이블을 여러 번 사용 가능)
on e.mgr = m.empno;

--테이블을 따로 만들지 않고 셀프 조인을 활용하는 이유: 관리자도 사원이므로

----------join 끝-----------------

--quiz

select * from emp;
select * from dept;

-- 1. 사원들의 이름, 부서번호, 부서이름을 출력하라.
select e.ename, d.deptno, d.dname
from emp e join dept d
on e.deptno = d.deptno;

 
-- 2. DALLAS에서 근무하는 사원의 이름, 직위, 부서번호, 부서이름을
-- 출력하라.
select e.ename, e.job,  d.deptno, d.dname
from emp e join dept d
on e.deptno = d.deptno;

 
-- 3. 이름에 'A'가 들어가는 사원들의 이름과 부서이름을 출력하라.
select e.ename, d.dname
from emp e join dept d 
on e.deptno = d.deptno
where e.ename like '%A%'; 


-- 4. 사원이름과 그 사원이 속한 부서의 부서명, 그리고 월급을
--출력하는데 월급이 3000이상인 사원을 출력하라.
select e.ename, d.dname, e.sal
from emp e join dept d
on e.deptno = d.deptno
where e.sal>=3000;


-- 5. 직위(직종)가 'SALESMAN'인 사원들의 직위와 그 사원이름, 그리고
-- 그 사원이 속한 부서 이름을 출력하라.

select e.job, e.ename, d.dname
from emp e join dept d
on e.deptno = d.deptno
where job='SALESMAN';

 
-- 6. 커미션이 책정된 사원들의 사원번호, 이름, 연봉, 연봉+커미션,
-- 급여등급을 출력하되, 각각의 컬럼명을 '사원번호', '사원이름',
-- '연봉','실급여', '급여등급'으로 하여 출력하라.
--(비등가 ) 1 : 1 매핑 되는 컬럼이 없다

select e.empno as "사원번호", e.ename as "사원이름", e.sal*12 as "연봉", e.sal*12+e.comm as "실급여" ,s.grade as "급여등급"
from emp e join dept d
on e.deptno = d.deptno
join salgrade s
on e.sal between s.losal and s.hisal
where e.comm is not null;

select * from salgrade;
 
-- 7. 부서번호가 10번인 사원들의 부서번호, 부서이름, 사원이름,
-- 월급, 급여등급을 출력하라.
select d.deptno, d.dname, e.ename, e.sal,s.grade
from emp e join dept d 
on e.deptno = d.deptno
                 join salgrade s
on e.sal between s.losal and s.hisal
where e.deptno = 10;

 
 
-- 8. 부서번호가 10번, 20번인 사원들의 부서번호, 부서이름,
-- 사원이름, 월급, 급여등급을 출력하라. 그리고 그 출력된
-- 결과물을 부서번호가 낮은 순으로, 월급이 높은 순으로
-- 정렬하라.
select e.deptno, d.dname, e.ename, e.sal, s.grade
from emp e join dept d 
on e.deptno = d.deptno
                 join salgrade s
on e.sal between s.losal and s.hisal
where e.deptno<=20
order by d.deptno asc, e.sal desc;
 
-- 9. 사원번호와 사원이름, 그리고 그 사원을 관리하는 관리자의
-- 사원번호와 사원이름을 출력하되 각각의 컬럼명을 '사원번호',
-- '사원이름', '관리자번호', '관리자이름'으로 하여 출력하라.
--SELF JOIN (자기 자신테이블의 컬럼을 참조 하는 경우)

select e.empno as "사원번호", 
e.ename as "사원이름", 
e.mgr as "관리자번호",
p.ename as "관리자이름"
from emp e join emp p
on e.mgr = p.empno;

---------------여기까지 초급-------------------

---------------중급-------------------------
--subquery pdf 100p.
--SQL의 꽃. >> SQL의 만능 해결사
--함수 >> 조인 >> subquery
--사원테이블에서 사원들의 평균 월급보다 더 많은 급여를 받는 사원의
--사번, 이름, 급여를 출력하세요

select avg(sal) from emp;  --2073

select *
from emp
where sal > 2073; --이렇게 두 번 해야 한다

--subquery를 이용하면
select empno, ename,sal
from emp
where sal> (select avg(sal) from emp);


--subquery
/*
1.single row subquery: subquery 결과 row 1개 (단일컬럼 단일값)
2.multi row subquery: subquery 결과 row 1개 이상(단일컬럼 여러 개의 값)
구별하는 이유는: 사용되는 연산자가 다르다
multi row 연산자:  in, not in, (any, all)
all(and):  sal > 1000 and sal >2000 and sal ....
any(or): sal >1000 or sal >2000  or ...

subquery 형식
1. 괄호 안에 있어야 한다 : (select sal from emp)
2. 단일 컬럼으로 구성 (멀티도 되지만 너무 복잡 >> 안씀) (select sal, deptno from emp (x))
3. 단독으로 실행 가능

실행 순서
1. 무조건 subquery가 먼저 실행
2. subquery의 결과값을 가지고 main query 실행
*/

--사원테이블에서 JONES 급여보다 더 많은 급여를 받는 사원의 사번, 이름, 급여 출력
select empno, ename, sal
from emp
where sal>(select sal from emp where ename='JONES');

--subquery 급여가 2000 이상
select * 
from emp
where sal in (select sal from emp where sal > 2000);

--부하직원이 있는 사원의 사번과 이름을 출력하세요
select empno, ename
from emp
where empno in(select mgr from emp); --or 조건

--부하직원이 없는 사원의 사번과 이름을 출력하세요
select empno, ename
from emp
where empno not in(select nvl(mgr,0) from emp);  --and 조건에 null이 있으면 결과는 null이기 때문

select empno, ename
from emp
where empno not in(select mgr from emp where mgr is not null); -- 이것도 된다 

--king에게 보고하는 즉, 직속상관이 king인 사원의 사번, 이름, 직종, 관리자 사번을 출력하세요 
select empno, ename, job, mgr
from emp
where mgr =(select empno from emp where ename='KING');

--20번 부서의 사원 중에서 가장 많은 급여를 받는 사원보다 더 많은 급여를 받는 사원의
--사번, 이름, 급여, 부서번호를 출력하세요
select empno, ename, sal, deptno
from emp
where sal>(select max(sal) from emp where deptno=20);

--POINT
--subquery는 select, from where 절 모두 사용 가능

select *
from emp
where deptno in (select deptno from emp where job='SALESMAN')
and sal in (select sal from emp where job='SALESMAN');

--Quiz
--실무에서 활용
--자기 부서의 평균 월급보다 더 많은 월급을 받는 
--사원의 사번, 이름, 부서번호, 부서별 평균 월급을 출력하세요
--1단계: 부서번호와 부서의 평균 월급을 담고 있는 테이블이 존재한다면
--(물리적인 테이블은 없어요)
select deptno, round(avg(sal),0) from emp group by deptno;

--2단계: from절 subquery 사용가능 (가상 테이블)
select e.empno, e.ename, e.deptno, e.sal, s.avgsal
from emp e join (select deptno, round(avg(sal),0) as avgsal from emp group by deptno) s  --**가상테이블, in line view**
on e.deptno = s.deptno
where e.sal > s.avgsal
order by e.empno;

-- 요렇게도 된다
select empno, ename, deptno, sal, avg(sal)
from emp e
where sal > (select avg(sal) from emp p where e.deptno=p.deptno)
group by empno, ename, deptno, sal
order by e.empno;

---------------------------------------
--subquery 연습문제 푸세요(시간: 10시 10분까지)
--카페에 있어요
--1. 'SMITH'보다 월급을 많이 받는 사원들의 이름과 월급을 출력하라.
select ename, sal
from emp
where sal>(select sal from emp where ename='SMITH');
 
--2. 10번 부서의 사원들과 같은 월급을 받는 사원들의 이름, 월급,
-- 부서번호를 출력하라.
select ename, sal, deptno
from emp
where sal in (select sal from emp where deptno=10);

--3. 'BLAKE'와 같은 부서에 있는 사원들의 이름과 고용일을 뽑는데
-- 'BLAKE'는 빼고 출력하라.
select ename, hiredate
from emp 
where deptno = (select deptno from emp where ename='BLAKE') and
ename!='BLAKE';

--4. 평균급여보다 많은 급여를 받는 사원들의 사원번호, 이름, 월급을
-- 출력하되, 월급이 높은 사람 순으로 출력하라.
select empno, ename, sal
from emp
where sal>(select avg(sal) from emp)
order by sal desc;

 
--5. 이름에 'T'를 포함하고 있는 사원들과 같은 부서에서 근무하고
-- 있는 사원의 사원번호와 이름을 출력하라.
select empno, ename
from emp
where deptno in (select deptno from emp where ename like '%T%');;

--6. 30번 부서에 있는 사원들 중에서 가장 많은 월급을 받는 사원보다
-- 많은 월급을 받는 사원들의 이름, 부서번호, 월급을 출력하라.
--(단, ALL(and) 또는 ANY(or) 연산자를 사용할 것)
select ename, deptno, sal
from emp
where sal > all(select sal from emp where deptno=30);


select ename, deptno, sal
from emp
where sal > (select max(sal) from emp where deptno=30);

--7. 'DALLAS'에서 근무하고 있는 사원과 같은 부서에서 일하는 사원의
-- 이름, 부서번호, 직업을 출력하라.
select e.ename, e.deptno, e.job
from emp e join dept d
on e.deptno = d.deptno
where e.deptno in (select deptno from emp where d.loc = 'DALLAS');


--8. SALES 부서에서 일하는 사원들의 부서번호, 이름, 직업을 출력하라.
select e.deptno, e.ename, e.job
from emp e join dept d
on e.deptno = d.deptno
where d.dname='SALES';

select deptno, ename, job
from emp
where deptno in (select deptno from dept where dname='SALES');

 
--9. 'KING'에게 보고하는 모든 사원의 이름과 급여를 출력하라
--king 이 사수인 사람 (mgr 데이터가 king 사번)
select ename, sal
from emp
where mgr = (select empno from emp where ename='KING');

 
--10. 자신의 급여가 평균 급여보다 많고, 이름에 'S'가 들어가는
-- 사원과 동일한 부서에서 근무하는 모든 사원의 사원번호, 이름,
-- 급여를 출력하라.
select empno, ename, sal
from emp
where sal >(select avg(sal) from emp) and
            deptno in (select deptno from emp where ename like '%S%');

 
--11. 커미션을 받는 사원과 부서번호, 월급이 같은 사원의
-- 이름, 월급, 부서번호를 출력하라.
select ename, sal, deptno
from emp
where deptno in (select deptno from emp where comm is not null) and
sal in (select sal from emp where comm is not null);


--12. 30번 부서 사원들과 월급과 커미션이 같지 않은
-- 사원들의 이름, 월급, 커미션을 출력하라.
select ename, sal, comm
from emp
where sal not in (select sal from emp where deptno=30) and
comm not in( select comm from emp where deptno=30 and comm is not null);

/*
막간정보
문자 타입
char(20)  >>20byte >> 한글10자, 영문자20자 >> 고정 길이 문자열
varchar2(20)  >> 20byte >> 한글10자, 영문자20자 >>가변 길이 문자열

char(20) >> '홍길동' >> 6byte >> [홍길동       ] >> 20byte
varchar2(20) >> '홍길동' >> 6byte >> [홍길동] >> 6byte

ex)
고정 길이 데이터: 남,여 : char(2)
가변 길이 데이터: 이름 : varchar(20)

성능상의 문제: char() > varchar() 
고정길이 데이터 char() 쓰면 좋은 데이터 : 남/여, 주민번호, 우편번호

한글문제 (unicode : 2byte) >> 한글, 영문자, 특수문자, 공백

nchar(20) >> 여기서 20은 글자수

*/

--------여기까지 초급 개발자 기본 소양----------------------

--[INSERT], [UPDATE], [DELETE] >>암기하자
/*
오라클 기준
DDL(데이터 정의어): create, alter, drop, truncate(rename, modify)
DML(데이터 조작어): insert, update, delete   20%
DQL(데이터 질의어): select                          70%
DCL(데이터 정의어): 권한(grant, revoke)   >>DBA(관리자)가 하는 것
TCL(트랜잭션): commit, rollback, savepoint

개발자: CRUD (Create >> insert(db), Read >> select(db), Update >> update, Delete >> delete)

*/

--DML(트랜잭션(Transaction): 하나의 논리적인 작업 단위) >LOCK
--A라는 은행에서 돈을 인출해서 B라는 은행에 입금
--A : update .... 1000> 500
--B: update .... 1000> 1500
-- 둘 다 성공: commit
-- 둘 중에 하나라도 실패: rollback

select * from tab; --접속한 사용자가 만든 모든 테이블 목록

select * from tab where tname='BOARD'; --BOARD 테이블 존재유무 확인

select * from col;  -- 모든 컬럼 조회

select * from col where tname='EMP';  --EMP의 컬럼 조회

select * from user_tables; --관리자
select * from user_tables where table_name = 'DEPT';

-------------------------------
--DML(pdf 168p)
create table temp(
    id number primary key,  -- primary key: not null과 unique 데이터만(null x, 중복 x)
    name varchar2(20)    --default null값 허용
);

select * from temp;


--[insert]-----------

--1. 가장 일반적인 insert
insert into temp(id, name)
values(100,'홍길동');

select * from temp;

commit;  --커밋 안하면 재시작 시 날아감

--2. 컬럼 목록 생략(컬럼 리스트 생략)
insert into temp
values(200,'김유신'); --데이터 컬럼의 개수, 순서 일치하는 경우

select * from temp;

commit;

--- 문제 상황
insert into temp(id, name)  
values(100, '아무개');  --unique constraint (BIT.SYS_C007006) violated  >> id가 primary key이기 때문

insert into temp(name)
values('아무개');  --cannot insert NULL into ("BIT"."TEMP"."ID")  >> id값 넣지 않았기 때문

---------------------------------------------
--일반 SQL문은 프로그램적인 요소 (x)

--PL-SQL(고급)

create table temp2(id varchar2(20));

--데이터 테스트... 일일이 1000건 1000번 실행...
--PL-SQL 맛보기--
/*
begin
    for i in 1..1000 loop
        insert into temp2(id) values('A' ||to_char(i));
    end loop;
end;
*/

-- 쓰고 나면 주석처리 해야 함
select * from temp2;
commit;

---------------------------------
create table temp3(
    memberid number(3) not null, --3자리 숫자
    name varchar2(10), --null 허용
    regdate date default sysdate --기본값 설정하기 regdate를 인서트 생략하면 sysdate가 디폴트로 입력
);

select sysdate from dual; 

insert into temp3(memberid, name, regdate)
values(100, '홍길동', '2020-04-03');

select * from temp3;
commit;

insert into temp3(memberid, name)
values(200, '아무개');   --regdate는 디폴트값 입력

select * from temp3;

commit;

insert into temp3(memberid) --null 허용한 경우 생략하면 null입력
values(300);

select * from temp3;

commit;

--insert (TIP)
--1. 대량 데이터 insert 하기
create table temp4(id number);
create table temp5(num number);

insert into temp4(id) values(1);
insert into temp4(id) values(2);
insert into temp4(id) values(3);
insert into temp4(id) values(4);
insert into temp4(id) values(5);
insert into temp4(id) values(6);
insert into temp4(id) values(7);
insert into temp4(id) values(8);
insert into temp4(id) values(9);
insert into temp4(id) values(10);
commit;

--요구사항:  temp4에 있는 모든 데이터를 temp5에 넣고 싶음

insert into temp5(num)
select id from temp4;   -- values 대신 select문 가능

select * from temp5;

--2. insert TIP
--테이블이 없는 상황에서 [테이블 생성] + [대량 데이터 삽입]
--단 복사 개념(제약 정보는 복사 안되요 (PK, FK))
--순수한 테이블 구조(컬럼 이름, 타입) 복사

--create tavle copyemp(id number)
create table copyemp  --emp와 같은 구조를 만들고 데이터 삽입까지
as
    select * from emp;
    
select * from copyemp;

create table copyemp2
as
    select empno, ename, sal
    from emp
    where deptno=30;
    
select * from copyemp2;
select * from col where tname='COPYEMP2';

--질문: 구조(틀)만 복사하고 데이터 복사하고 싶지 않아요
create table copyemp3
as 
    select * from emp where 1=2;   -- 거짓조건을 활용해서 틀만 복사
    
select * from copyemp3;

------------[insert end]-------------------

------------[update]------------
/*
update table_name
set column1 = value1, column2 = value2 .....
where 조건

update table_name
set column = (subquery)
where 조건
*/

select * from copyemp;

update copyemp
set sal =0;

select * from copyemp;
rollback;

update copyemp
set sal =0
where deptno=20;

select * from copyemp order by deptno;

commit;

update copyemp
set sal = (select sum(sal) from emp)
where deptno=20;

commit;

--여러 개의 컬럼을 update
update copyemp
set ename='AAAA', job= 'BBBB',hiredate=sysdate, sal=1111
where deptno=10;

select * from copyemp where deptno=10;
commit;

------------[update end]----------------------
-----[delete]-----
--원칙 >> delete -> commit, rollbak -> (원칙적으로)복원 불가 -> 단 백업해놓으면 가능

delete from copyemp;

select * from copyemp;
rollback;

delete from copyemp where deptno in(10,20); 

select * from copyemp where deptno in (10,20);
commit;
----------[delete end]--------

/*
APP(JAVA)  -> JDBC API  -> ORACLE(DB)

CRUD
create : insert
read : select
update: update
delete: delete

(DML: insert, update, delete) 트랜잭션(commit, rollback)

JDBC -> ORACLE -> emp 테이블 작업
전체 조회
조건 조회
삭제
수정
삽입
java에서
public List<Emp> getEmpAllList() {String aql="select * from emp"}
public Emp getEmpListByEmpno(){String sql="select... where empno=777"}
public int insertEmpData(Emp emp){String sql="insert into emp()...}

*/

------------------------------------------------
-----[DDL]-----
--create, alter, drop(테이블 기준)

select * from tab;
select * from tab where tname = 'BOARD';


 --drop :테이블 완전 삭제
drop table board; 

create table board(
    boardid number,
    title nvarchar2(100),
    content nvarchar2(2000),
    regdate date
);

select * from tab where tname = 'BOARD';


--학생 성적 테이블
--국어, 영어, 수학, 총점컬럼
--국어, 영어, 수학 점수가 들어오면 자동으로 총점 계산 
--oracle 11g버전(가상컬럼(조합컬럼))
create table vtable(
    no1 number,
    no2 number,
    no3 number generated always as (no1+no2) virtual
);

insert into vtable(no1, no2)
values(100,200);
select * from vtable; --자동으로 no1+no2 컬럼 생성

insert into vtable(no1,no2)
values(33,44);

select * from vtable;

--가상 컬럼엔 직접 데이터 못 넣는다
insert into vtable(no1, no2, no3)
values(10, 20, 30);  --INSERT operation disallowed on virtual columns

--컬럼의 정보 보기  
select *
from user_tab_columns where table_name='VTABLE';  --가상 테이블이 어떤 값들의 연산인지도 확인할 수 있음

--실무에서 활용되는 코드
--제품정보 (입고일) .. 분기별(4분기)
--입고일: 2020-03-01 >> 1분기
create table vtable2
(
    no number, --순번
    p_code char(4), --제품코드(A001, A002)
    p_date char(8), --입고일(20200101)
    p_qty number, --수량
    p_bungi number generated always as (
        case when substr(p_date,5,2) in('01','02','03') then 1
                when substr(p_date,5,2) in('04','05','06') then 2  
                when substr(p_date,5,2) in('07','08','09') then 3   
                else 4
        end
    ) virtual
);

insert into vtable2(p_date) values('20200101');
insert into vtable2(p_date) values('20200126');
insert into vtable2(p_date) values('20200324');
insert into vtable2(p_date) values('20200608');
insert into vtable2(p_date) values('20201004');
insert into vtable2(p_date) values('20201224');



select * from vtable2;

select * from vtable2 where p_bungi = 2;

--alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

----------------------------------------------------
--DDL 테이블 다루기(pdf 138p)
--1. 테이블 생성하기
create table temp6 (id number);

--2. 테이블 생성했는데 컬럼 추가하기
desc temp6;

alter table temp6
add ename varchar2(20);

--3. 기존 테이블에 있는 컬럼의 이름을 잘못 표기(ename -> username)
--기존 테이블에 있는 컬럼의 이름 바꾸기(rename)
alter table temp6
rename column ename to username;

--4. 기존 테이블에 있는 기존 컬럼의 타입 수정하기
--(modify) <- 오라클에서
alter table temp6
modify(username varchar2(100));

desc temp6;

--5. 기존 테이블에 있는 기존 컬럼 삭제
alter table temp6
drop column username;

--6. 테이블 삭제
--6.1 데이터 삭제: delete
--테이블 처음 만들면 처음 크기 설정됨 -> 데이터를 넣으면 -> 확장
--ex) 처음 1MB >> 10만건 >> 100MB >> delete 10만건 삭제 >> 여전히 크기는 100MB >>데이터만 삭제 됐으므로

--테이블 데이터 삭제하면서 공간의 크기도 줄이는 방법
--truncate(where 절은 사용 못함)
--ex) 처음 1MB >> 10만건 >> 100MB >> truncate 10만건 삭제 >> 1MB

--7. 테이블 삭제(drop)
drop table temp6;

--------------------------------------------------------
--테이블 제약 설정(pdf 148p)
--데이터 [무결성] 확보
--select(연관성 ..(x))
--제약(constraint: insert, update, delete(FK))

/*
PRIMARY KEY(PK) 유일하게 테이블의 각행을 식별(NOT NULL 과 UNIQUE 조건을 만족)
--테이블에 한 개만 걸 수 있다
--내부적으로 검색의 향상을 위해서(index) 자동 생성 (select향상)

FOREIGN KEY(FK) 열과 참조된 열 사이의 외래키 관계를 적용하고 설정합니다.
--참조제약 [테이블]과 [테이블]간의 관계 설정

UNIQUE key(UK) 테이블의 모든 행을 유일하게 하는 값을 가진 열(NULL 을 허용)
NOT NULL(NN) 열은 NULL 값을 포함할 수 없습니다.

CHECK(CK) 참이어야 하는 조건을 지정함(대부분 업무 규칙을 설정)
--설정한 범위의 값만 받겠다 
--ex) gender in('남', '여')
*/

--제약을 만드는 시점
--1. 테이블 만들면서 바로 생성(create table...)
--2. 테이블 생성 이후 추가(alter table add constraint ...) 자동화 된 툴들이 사용하는 방법

--1. 제약 정보 확인하기
select * from user_constraints where table_name='EMP';
--SYS_C007005 : 내부적으로 생성된 제약 이름
--"EMPNO" IS NOT NULL : 조건

create table temp7(
 --id number primary key  --줄임표현(비추) (제약이름: SYS_C007005 식으로 생성됨)
    id number constraint pk_temp7_id primary key,   --권장(제약이름: pk_temp7_id)
    name varchar2(20) not null,
    addr varchar2(50)
);

select * from user_constraints where table_name='TEMP7';  --내부적으로 테이블은 대문자로 만들어짐
--PK_TEMP7_ID >> 제약명만 보고도 해석이 가능(제약수정, 삭제 용이)

--insert into temp7(name, addr) values('홍길동', '서울시 강남구');  --cannot insert NULL into ("BIT"."TEMP7"."ID") 제약사항이 있어서 오류

insert into temp7(id, name, addr) values(10, '홍길동','서울시 강남구');
commit;
select * from temp7;

insert into temp7(id, name, addr) values(10, '아무개', '서울시 강남구'); 
--중복 데이터
--ORA-00001: unique constraint (BIT.PK_TEMP7_ID) violated

--1. 테이블에 primary key를 몇 개까지 걸 수 있을까? >> 1개
--(name, num) 여러 개의 컬럼을 묶어서 1개 가능 >> 복합키

create table temp8(
    id number constraint pk_temp8_id primary key,
    name varchar2(20) not null,
    jumin char(6) constraint uk_temp8_jumin unique,  --null 허용
    addr varchar2(20)
);
select* from user_constraints where table_name='TEMP8';

insert into temp8(id, name, jumin, addr)
values(10, '홍길동', '123456', '경기도 성남시');
commit;
select * from temp8;

insert into temp8(id, name, jumin, addr)
values(20, '아무개', '123456', '경기도 성남시');
--ORA-00001: unique constraint (BIT.UK_TEMP8_JUMIN) violated

--null ... unique 허용(null도 중복체크를 할까)
insert into temp8(id, name, addr)
values(30, '김씨', '경기도 성남시');  

select * from temp8;

insert into temp8(id, name, addr)  --null은 중복체크에 해당 안됨
values(40, '박씨', '경기도 성남시');  

commit;

--unique와 not null 동시에 하려면
--create table temp8(jumin not null constraint ... unique)
--unique 제약은 테이블 컬럼 개수만큼 가능

------------------------------------------
create table temp9(id number);

--기존 테이블에 제약 추가하기
--주의) 기존 데이터가 있는 경우 제약을 위반하는 데이터가 있으면 제약은 추가되지 않음
--제약 걸기 전에 데이터 검사 작업 선행

alter table temp9
add constraint pk_temp9_id primary key(id);

select* from user_constraints where table_name='TEMP9';

--여러 개 컬럼(복합키)
--add constraint pk_temp9_id primary key(id, name);

alter table temp9
add ename varchar2(20);

desc temp9;

--not null 추가하기
alter table temp9
modify(ename not null);

------------------------------------
--[check 제약]--
--where 조건과 동일한 형태의 제약 >> where age >19
--컬럼이름 age > 19

create table temp10(
    id number constraint pk_temp10_id primary key,
    name varchar2(20) not null,
    jumin char(6) constraint uk_temp10_jumin unique,
    addr varchar2(20),
    age number constraint ck_temp10_age check(age >=19)
);

select* from user_constraints where table_name='TEMP10';

insert into temp10(id, name, jumin, addr,age)
values(100, '홍길동', '123456','서울시 강남구',20);

select * from temp10;
commit;

insert into temp10(id, name, jumin, addr,age)
values(200, '홍길동', '123456','서울시 강남구',18);
--ORA-02290: check constraint (BIT.CK_TEMP10_AGE) violated

--------------------------------------------
--참조 제약: RDBMS: 테이블과 테이블과의 관계 설정
--emp 테이블에 있는 deptno 컬럼은 dept 테이블에 있는 deptno를 참조
--참조하는 쪽에 거는 제약: fk
--참조를 당하는 쪽에 거는 제약: pk

create table c_emp
as 
    select empno, ename, deptno from emp where 1=2;
    
create table c_dept
as 
    select deptno, dname from dept where 1=2;
    
--emp 테이블에 있는 deptno 컬럼은 dept 테이블에 있는 deptno를 참조합니다

alter table c_emp
add constraint fk_c_emp_deptno foreign key(empno)
                                                    references c_dept(deptno);
--02270. 00000 -  "no matching unique or primary key for this column-list"
--c_dept의 deptno가 pk가 아니므로 참조 오류
--c_dept(deptno)가 다른 테이블에 참조당하기 위해선 신용 확보 필요(primary key)

alter table c_dept
add constraint pk_c_dept_deptno primary key(deptno);

alter table c_emp
add constraint fk_c_emp_deptno foreign key(deptno)
                                                    references c_dept(deptno); --이젠 된다
                                                    
--c_emp(deptno) --- c_dept(deptno) 관계가 설정(1:N 관계)

insert into c_dept(deptno, dname) values(100,'인사팀');
insert into c_dept(deptno, dname) values(200,'관리팀');
insert into c_dept(deptno, dname) values(300,'회계팀');

select * from c_dept;

commit;

--신입사원 입사
--질문) not null 걸어서 쓰는 것이 맞다, 아니다(null 허용)
--null 허용 이유: 신입사원이 반드시 부서를 가져야 하는 것은 아니다
--not null 이유: 입사하는 모든 사원은 반드시 부서를 가져야 한다

insert into c_emp(empno, ename)
values(100, '홍길동');

select * from c_emp;

update c_emp
set deptno = 200
where empno=100;

commit;
--------------------------

--두 개의 테이블
--(부모와 자식 관계)
--(master, detail)

--emp(deptno)와 dept(deptno) 관계에서 주테이블(부모)는 pk를 가지고 있는 쪽

select * from c_dept;
select * from c_emp;

delete from c_dept where deptno=300; --아직 참조하고 있지 않은 부서 번호이기 때문에 삭제 가능
delete from c_dept where deptno=200;   --참조 중이라 삭제 불가
--ORA-02292: integrity constraint (BIT.FK_C_EMP_DEPTNO) violated - child record found
--그래도 지우고 싶다면
--child(200번 부서를 삭제, 수정) >> parent 수정 삭제

/*
(column datatype [CONSTRAINT constraint_name]       
REFERENCES table_ name (column1[,column2,..] [ON DELETE CASCADE]) 

column datatype, . . . . . . . , 
[CONSTRAINT constraint_name] FOREIGN KEY (column1[,column2,..])        
REFERENCES table_name  (column1[,column2,..] [ON DELETE CASCADE]) 
*/

--TIP> MS-SQL >>ON UPDATE CASCADE, ON DELETE CASCADE
--TIP> MYSQL >> 
-- [ON DELETE CASCADE]  부모테이블과 생명을 같이 하겠다
-- 300 삭제 할 있나요?  네 
-- delete from c_dept where detpno=300;
-- 참조하는 자식 데이터 같이 삭제
-- delete from c_emp where deptno=300; 같이 실행
alter table c_emp
drop constraint fk_c_emp_empno;

alter table c_emp
add constraint fk_emp_empno foreign key(deptno) 
references c_dept(deptno) ON DELETE CASCADE;

select * from c_emp;
select * from c_dept;
delete from c_dept where deptno=100;
commit;

/*
--학생 성적 테이블
--학번의 데이터는 중복되거나 NULL 값을 허용하면 안된다
--이름 NULL 값을 허용하지 않는다
--국어
--영어
--수학 점수 컬럼은 숫자 타입이고 NULL 값을 허용
--는 값을 입력하지 않으면  default로 0값을 갖는다
--총점 ,평균 컬럼은 가상컬럼으로(조합컬럼) 생성한다 (평균 소수이하 3자리 반올림)
--학과코드는 학과 테이블에 학과코드를 참조한다
--학번 , 이름 , 국어 , 영어 , 수학 , 총점 , 평균 , 학과코드

--학과 테이블
--학과코드 데이터는 중복되거나 NULL 값을 허용하면 안된다,
--학과명 은 null값을 허락하지 않는다

--학과코드 , 학과명

--그리고 select 결과는
--샘플 데이터 3건 입력
--학번 , 이름  총점, 평균 , 학과코드 , 학과명 을 출력하세요
*/

create table student_score(
    id number,
    sname varchar2(20) not null,
    korean number default 0,   --기본값 default를 0으로 한다
    english number default 0,
    math number default 0,
    total  number generated always as (korean+english+math) virtual,
    average number generated always as (round(((korean+english+math)/3),2)) virtual,
    dept_id varchar2(20)
);


create table u_dept(
    dept_id varchar2(20),
    dname varchar2(20) not null
);

select * from u_dept;

alter table student_score
add constraint pk_stuent_score_id primary key(id);

alter table u_dept
add constraint pk_u_dept_dept_id primary key(dept_id);

select* from user_constraints where table_name='STUDENT_SCORE';
select* from user_constraints where table_name='U_DEPT';

alter table student_score
add constraint fk_student_score_dept_id foreign key(dept_id)
                                                    references u_dept(dept_id);

select* from user_constraints where table_name='STUDENT_SCORE';

insert into u_dept(dept_id, dname) values('A10','문과');
insert into u_dept(dept_id, dname) values('A20','이과');
insert into u_dept(dept_id, dname) values('A30','예체능과');

select* from  u_dept;

insert into student_score(id, sname, korean, english, math, dept_id)
values('1','홍길동', 100, 70, 80, 'A10');
insert into student_score(id, sname, korean, english, math, dept_id)
values('2','장영실', 80, 100, 90, 'A20');
insert into student_score(id, sname, korean, english, math, dept_id)
values('3','이중섭', 90, 65, 80, 'A30');

insert into student_score(id, sname,dept_id)
values('4','안창호', 'A30');

select* from  student_score;

select s.id, s.sname, s.total, s.average, u.dept_id, u.dname
from student_score s join u_dept u
on s.dept_id = u.dept_id;

commit;


/*
-- 테이블 생성에서 제약조건 설정하기

create table department (
    dept_id number constraint pk_department_dept_id primary key,
    dept_name varchar2(50) not null
);

create table grade (
    student_id number constraint pk_grade_student_id primary key,
    student_name varchar2(50) not null,
    korean number default 0,
    english number default 0,
    math number default 0,
    sum number generated always as (korean + english + math) virtual,
    avg number generated always as ((korean + english + math)/3) virtual,
    dept_id number constraint fk_grade_dept_id references department(dept_id)
);

-- 테이블 생성시 제약조건 하단에서 한 번에 주기

create table grade(
  s_number number ,
  s_name varchar2(20) not null,
  k_score number default 0,
  e_score number default 0,
  m_score number default 0,
  m_code number ,
  avg_score number GENERATED always as (round((k_score + e_score + m_score)/3,2)) VIRTUAL,
  sum_score number GENERATED always as (k_score + e_score + m_score) VIRTUAL,
  
  --복합키 constraint pk_grade_snum primary key(s_number,name),   --복합키 제약조건 줄 때 수월하다
  constraint pk_grade_snum primary key(s_number),
  constraint fk_grade_mcode foreign key(m_code) references major(m_code) 
  --나중에 걸거나 (테이블 생성 후에)
);
*/


/* 사원 */
CREATE TABLE EMP (
	empno NUMBER NOT NULL, /* 사번 */
	ename VARCHAR2(20), /* 이름 */
	sal NUMBER, /* 급여 */
	deptno NUMBER /* 부서번호 */
);
ALTER TABLE EMP
ADD	CONSTRAINT PK_EMP_DEPTNO PRIMARY KEY (empno);
/* 부서 */
CREATE TABLE DEPT (
	deptno NUMBER NOT NULL, /* 부서번호 */
	dname VARCHAR2(20) /* 부서명 */
);


ALTER TABLE DEPT
ADD	CONSTRAINT PK_DEPT_DEPTNO	PRIMARY KEY(deptno);

ALTER TABLE EMP
ADD	CONSTRAINT FK_DEPT_TO_EMP 	FOREIGN KEY(deptno)
REFERENCES DEPT(deptno);

----------------제약 설정 끝 ------------------------

--view 객체(가상 테이블) pdf(192p)

/*
CREATE  [OR  REPLACE]  [FORCE | NOFORCE]  VIEW view_name [(alias[,alias,...])] 
AS 
Subquery  
[WITH  CHECK  OPTION  [CONSTRAINT  constraint ]] 
[WITH  READ  ONLY] 


OR  REPLACE  이미 존재한다면 다시 생성한다. 
FORCE   Base Table 유무에 관계없이 VIEW 을 만든다. 
NOFORCE  기본 테이블이 존재할 경우에만 VIEW 를 생성한다. 
view_name  VIEW 의 이름 
Alias   Subquery 를 통해 선택된 값에 대한 Column 명이 된다. 
Subquery  SELECT 문장을 기술한다. 
WITH CHECK OPTION VIEW 에 의해 액세스 될 수 있는 행만이 입력,갱신될 수 있다.  
Constraint  CHECK OPTON 제약 조건에 대해 지정된 이름이다. 
WITH READ ONLY  이 VIEW 에서 DML 이 수행될 수 없게 한다. 
*/


--[42000]: ORA-01031: insufficient privileges
--당신은 view 생성 권한이 없어요 .... 관리자에게 권한을 받으세요
-- SYSTEM PRIVILEGES
GRANT CREATE VIEW TO "BIT" WITH ADMIN OPTION;

CREATE VIEW v_001
AS
   SELECT empno,ename FROM emp;

--view 는 sql 문장을 가지고 있는 객체 

--view 객체 (create ....)
--create view 뷰이름 as sql 문장 (view 통해서 볼 수 있는 데이터 목록)
--view 는 테이블처럼 사용가능 (가상테이블) -> 쓰는 방법 (emp, dept ) 동일하게
--view 메모리상에서만 존재하는 가상테이블 (ex) in-line-view


--view 사용법
--일반 테이블과 동일 ... (select, where ...)
--DML(insert, update, delete) -> view통해서 볼 수 있는 데이터 -> DML

--view 사용 목적
--1. 개발자의 편리성(join, subquery) >> 실제 테이블이 있다면 좋겠다
--2. 보안(권한 처리) -> 노출하고 싶은 데이터만 모아서 view 생성 
--3. 편리성(복잡한 query 모아서) view 생성... 미리 만들어 보기



--보안성
--인사 테이블
--emp 바로 노출하면 급여정보 등이 노출
create view v_emp
as  
    select empno, ename, job, hiredate from emp;
    
--v_emp 사용하시면 되요
select * from v_emp;
select * from v_emp where empno=7788;

--편리성(복잡한 쿼리를 단순화)
--만들어놓고 쓸 수 있다
create view v_002
as 
   select e.empno, e.ename, d.deptno, d.dname
   from emp e join dept d
   on e.deptno = d.deptno;
   
select * from v_002;

--자기 부서의 평균 월급보다 더 많은 월급을 받는 
--사원의 사번, 이름 , 부서번호 , 부서별 평균 월급을 출력하세요
--자기 부서의 평균 월급보다 더 많은 월급 담고 있는 테이블이 있다면..

create view v_003
as 
    select deptno, avg(sal) as avgsal
    from emp
    group by deptno;

select * from v_003;

select *
from emp e join v_003 s
on e.deptno = s.deptno
where e.sal > s.avgsal;

--테이블이 1개 이상
--join  안되면 >> suquery  안되면 >> view(가상테이블)

--view 삭제
drop view v_007;

create or replace view v_007
as 
    select avg(sal) as avgsal from emp;  --조합함수는 alias 넣어줘야 한다

select * from v_007;

--view를 통한 DML가능(insert, update, delete)
--단 view 가지는 구문이 테이블 1개 가능
--복합 view는 DML불가(테이블 1개 이상으로 구성된 query)
--단순 view(테이블 1개로 만든 view)

select * from v_emp; --볼 수 있는 데이터(empno, ename, job, hiredate)

update v_emp  --v_emp 너는 sal 컬럼을 볼 수 없어.. 변경 할 수 없어
set sal = 0;

update v_emp
set job = 'IT';

select * from v_emp; 
select * from emp;  -- 실제로는 emp 테이블이 변경된 것

rollback;

create or replace view v_emp2
as 
    select * from emp where deptno=20;
    
select * from v_emp2;

update v_emp2
set sal = 0;  -- deptno=20인 경우만 sal=0이 됨

select * from emp;

rollback;

-- view 목록보기
select * from user_views;

--
--1. 30번 부서 사원들의 직위, 이름, 월급을 담는 VIEW를 만들어라.
create or replace view v_30
as 
    select job, ename, sal
    from emp
    where deptno=30;
    
select * from v_30;

 
--2. 30번 부서 사원들의  직위, 이름, 월급을 담는 VIEW를 만드는데,
-- 각각의 컬럼명을 직위, 사원이름, 월급으로 ALIAS를 주고 월급이
-- 300보다 많은 사원들만 추출하도록 하라.
-- create or replace view view001 (컬럼명, 컬럼명, .....)  
create or replace view v_30
as 
    select job as "직위", ename as "사원이름", sal as "월급"
    from emp
    where sal>300 and deptno=30;

select * from v_30;

--3. 부서별 최대월급, 최소월급, 평균월급을 담는 VIEW를 만들어라.
create or replace view v_maxmin
as 
    select deptno, max(sal) as "최대 월급", min(sal) as "최소 월급", avg(sal) as "평균 월급"
    from emp
    group by deptno;

select * from v_maxmin;

       
--4. 부서별 평균월급을 담는 VIEW를 만들되, 평균월급이 2000 이상인
-- 부서만 출력하도록 하라.

create or replace view avgsal
as
    select deptno, avg(sal) as "평균 월급"
    from emp
    group by deptno
    having avg(sal)>=2000;
    
select * from avgsal;
 

--5. 직위별 총월급을 담는 VIEW를 만들되, 직위가 MANAGER인
-- 사원들은 제외하고 총월급이 3000이상인 직위만 출력하도록 하라.

create or replace view sumsal
as
    select job, sum(sal) as "총 월급"
    from emp
    where job !='MANAGER'
    group by job
    having sum(sal)>=3000;
    

select * from sumsal;

select * from emp;


---------------------------------------
--개발자 필수 사항

--시퀀스(Sequence)


/*
CREATE  SEQUENCE  sequence_name  
              [INCREMENT  BY  n]  
              [START  WITH  n]  
              [{MAXVALUE n | NOMAXVALUE}]  
              [{MINVALUE n | NOMINVALUE}]  
              [{CYCLE | NOCYCLE}]  
              [{CACHE | NOCACHE}]; 
sequence_name  SEQUENCE 의 이름입니다. 
INCREMENT  BY  n 정수 값인 n 으로 SEQUENCE 번호 사이의 간격을 지정. 
    이 절이 생략되면 SEQUENCE 는 1 씩 증가. 
START  WITH  n  생성하기 위해 첫번째 SEQUENCE 를 지정. 
    이 절이 생략되면 SEQUENCE 는 1 로 시작. 
MAXVALUE n  SEQUENCE 를 생성할 수 있는 최대 값을 지정. 
NOMAXVALUE   오름차순용 10^27 최대값과 내림차순용-1 의 최소값을 지정. 
MINVALUE n  최소 SEQUENCE 값을 지정. 
NOMINVALUE  오름차순용 1 과 내림차순용-(10^26)의 최소값을 지정. 
CYCLE | NOCYCLE  최대 또는 최소값에 도달한 후에 계속 값을 생성할 지의 여부를 
    지정. NOCYCLE 이 디폴트. 
CACHE | NOCACHE  얼마나 많은 값이 메모리에 오라클 서버가 미리 할당하고 유지 
    하는가를 지정. 디폴트로 오라클 서버는 20 을 CACHE. 
*/




select * from tab where tname = 'BOARD';

drop table board;

create table board(
    boardid number constraint pk_board_id primary key,
    title nvarchar2(100)   -- 이 때 100은 글자수
);

select * from board;
--boardid 컬럼(not null, unique, index 구성)
--개발자: boardid >> where boardid=? >> 무조건 1건  return

--insert, update
--insert into board(boardid, title) values()
--넣는 데이터가 중복값이 아니고 null 아니다 보장 어떻게?

--조건: 처음 글을 쓰면 1이라는 값을 insert .. 그 다음부터의 글은 2,3,4
--순차적인 값들을 insert 하고 싶어요
--?? insert 문을 구성

--조건 : 처음 글을 쓰면 1이라는 값을 insert하고 싶고, 그 다음부터의 글은 2, 3, 4...순차적인 값을 insert하고 싶다
--그러면 insert문을 어떻게 만들까?
--Hint : subquery를 values안에 사용 가능하다


insert into board(boardid, title)
values((select count(boardid) + 1 from board) ,'안녕');
insert into board(boardid, title)
values((select count(boardid) + 1 from board) ,'방가');

select * from board;
commit;
--문제점이 있어용~(DML)
--한 줄을 삭제한 후 다시 입력하면 숫자가 중복되어 버린다. primary key라서 중복되면 안되는데..

delete from board where boardid = 1;

insert into board(boardid, title)
values((select count(boardid) + 1 from board) ,'안녕'); -- 1이 입력이 안된다!!

insert into board(boardid, title)
values ((select nvl(max(boardid),0) + 1 from board), '처음');

insert into board(boardid, title)
values ((select nvl(max(boardid),0) + 1 from board), '두번');

insert into board(boardid, title)
values ((select nvl(max(boardid),0) + 1 from board), '세번');


select * from board order by boardid;

delete from board order by boardid = 1;
commit;

select * from board order by boardid;


----------------------------------------
--sequence 번호 추출: 중복값이 없고 순차적인 값 >> 공유객체

create sequence board_num;

select * from sys.user_sequences;

/*
NEXTVAL 과 CURRVAL 의사열 
1) NEXTVAL 는 다음 사용 가능한 SEQUENCE 값을 반환 한다. 
2) SEQUENCE 가 참조될 때 마다, 다른 사용자에게 조차도 유일한 값을 반환한다. 
3) CURRVAL 은 현재 SEQUENCE 값을 얻는다. 
4) CURRVAL 이 참조되기 전에 NEXTVAL 이 사용되어야 한다. 
*/

--실제 번호 추출
select board_num.nextval from dual;

--몇 번까지 추출
select board_num.currval from dual;  --확인만 하지 추출하는 것은 아니다

-----------------------------------
create sequence kboard_num;

create table kboard(
    num number constraint pk_kboard_num primary key,
    title varchar2(100)
);

select kboard_num.currval from dual; --적어도 한 번 nextval을 해야 currval 를 호출 할 수 있다

insert into kboard(num,title)
values(kboard_num.nextval, '처음 글3');

select kboard_num.currval from dual;

select * from kboard;
--------------------------------------

--1. sequence 객체(테이블간 공유자원) >> 여러 개의 테이블이 하나의 채번기 사용
--A 테이블  >> 1, 2, 8
--B 테이블  >> 3, 4, 5
--C 테이블  >> 6, 7

--사이트(게시판) 10개
--상품 게시판, 관리자 게시판, 회원 게시판
--1. 하나의 sequence를 공유
--2. 게시판 글 번호 따로 관리 >>sequence 여러 개 생성

--ms-sql 경우
--create table board( boardnum int identity(1,1)... >>테이블 종속적
--insert into board(title) values('방가') >> 생략하면 자동으로 글 인덱스 번호 증가
--2012 버전부터는 sequence 사용 가능

--my-sql 경우
--create table test(
--num int(10) not null auto_increment primary key, 테이블 종속적
--name varchar(10) not null
--);

--mariaDB는 sequence 존재
--https://mariadb.com/kb/en/create-sequence/
----------------------------------------------

create sequence seq_num
start with 10                   --시작 지점 지정
increment by 2;             -- 증가간격 지정

select seq_num.nextval from dual;

select seq_num.currval from dual;

--게시판 데이터 insert
--게시판 글보기(최신글 순으로 ... 글번호 큰 것)
--select * from board order by boardnum desc

------------------------------
--개발자 필수 2
--rownum 의사컬럼: 실제 물리적으로 존재하는 컬럼이 아니고 논리적인 존재

--rownum: 실제 테이블에 컬럼으로 존재하지 않지만 내부적으로 행번호 부여할 수 있는 의사컬럼
--rowid: 주소값(행이 실제로 저장되는 내부 주소값) -> 인덱스 생성 사용

select * from emp;

select rownum as 순번, empno, ename from emp; -- rownum: select한 결과에 순번을 붙여줌

--Ton-n 쿼리
--테이블에서 조건에 맞는 상위(top) 레코드 n개 추출

--MS_SQL
--select top 10, * from emp order by sal desc

--Oracle
--rownum(의사컬럼) 기준을 정의
--1. 정렬의 기준을 정의(선행)
--2. 정렬된 상황에서 앞에 순번 조건을 제시 데이터 추출

--1단계
    select *
    from (select *
             from emp
             order by sal desc) e;
             
--2단계
    select rownum as "num", e.*
    from (select *
             from emp
             order by sal desc) e;
             
--3단계(급여를 많이 받는 사원 5명)
    select rownum as "num", e.* 
    from (select *
             from emp
             order by sal desc) e
    where rownum <= 5; 
--   where rownum >5;  이렇게 하면 아무 데이터도 출력되지 않는다 
---------------------------------------
--게시판 만들기 페이징 처리 필수 쿼리문(rownum 가상컬럼)
-- 위보다 이걸 권장
select *
from(
    select rownum as "num", e.*
    from (select * 
             from emp
             order by sal desc) e
        )
where "num" <10;

-----------------------------------------
--게시판(페이징 처리)
--100건 데이터
--10건씩 나누어서 보여주기

--총 100건
--pagesize=10(한 화면에 보여줄(페이지) 데이터 건수 row 수)
--page count = 10개
--[1][2]...[10]
--[1] 클릭하면 >> 1~10번
--[2] 클릭하면 >>11~20번..
--[10] 클릭하면 >> 91~100번

-------hr계정으로 이동-----------
select num, employee_id, last_name, email
from(
    select rownum as num, e.*
     from(
         select * 
         from employees 
         order by employee_id asc
     )e
     where rownum <= 10
    ) s
where num > 0; 
------------------------------------
--또는 between A and B
--where rownum between 10 and 20 사용 가능
------------------------------------
--SQL 기본 과정 END--
--SQL 고급 과정(3차 프로젝트)
--PL-SQL(변수, 제어문, 커서, 함수, 프로시져, 


----[종합 문제]----

--1> 부서테이블의 모든 데이터를 출력하라.
select * from dept;
 
 
--2> EMP테이블에서 각 사원의 직업, 사원번호, 이름, 입사일을 출력하라.
select job, empno, ename, hiredate
from emp;
 
--3> EMP테이블에서 직업을 출력하되, 각 항목(ROW)가 중복되지 않게
-- 출력하라.
select distinct job
from emp;
 
--4> 급여가 2850 이상인 사원의 이름 및 급여를 출력하라.
select ename, sal
from emp
where sal>=2850;
 
--5> 사원번호가 7566인 사원의 이름 및 부서번호를 출력하라.
 select ename, deptno
 from emp
 where empno=7566;
 
--6> 급여가 1500이상 ~ 2850이하의 범위에 속하지 않는 모든 사원의 이름
-- 및 급여를 출력하라.
 select ename, sal
 from emp
 where sal not between 1500 and 2850;
 
--7> 1981년 2월 20일 ~ 1981년 5월 1일에 입사한 사원의 이름,직업 및 
--입사일을 출력하라. 입사일을 기준으로 해서 오름차순으로 정렬하라.
 select ename, job, hiredate
 from emp
 where hiredate between '81/02/20' and '81/05/01'
 order by hiredate asc;
 
--8> 10번 및 30번 부서에 속하는 모든 사원의 이름과 부서 번호를
-- 출력하되, 이름을 알파벳순으로 정렬하여 출력하라.
select ename, deptno
from emp
where deptno in (10, 30)
order by ename asc;
 
--9> 10번 및 30번 부서에 속하는 모든 사원 중 급여가 1500을 넘는
-- 사원의 이름 및 급여를 출력하라.
--(단 컬럼명을 각각 employee 및 Monthly Salary로 지정하시오)

 select ename as "employee", sal as "Monthly Salary"
from emp
where deptno in (10,30) and sal >1500;

--10> 관리자가 없는 모든 사원의 이름 및 직위를 출력하라.
 select ename, job
 from emp
 where mgr is null;
 
--11> 커미션을 받는 모든 사원의 이름, 급여 및 커미션을 출력하되, 
-- 급여를 기준으로 내림차순으로 정렬하여 출력하라.
 select ename, sal, comm
 from emp
 where comm is not null
 order by sal desc;
 
--12> 이름의 세 번째 문자가 A인 모든 사원의 이름을 출력하라.
select ename
from emp
where ename like '__A%';
 
--13> 이름에 L이 두 번 들어가며 부서 30에 속해있는 사원의 이름을 
--출력하라.
 select ename
 from emp
 where ename like '%L%L%' and deptno=30;

--14> 직업이 CLERK 또는 ANALYST 이면서 급여가 1000,3000,5000 이 
-- 아닌 모든 사원의 이름, 직업 및 급여를 출력하라.
 select ename, job, sal
 from emp
 where job in('CLERK','ANALYST') and sal not in(1000, 3000, 5000); 
 
--15> 사원번호, 이름, 급여 그리고 15%인상된 급여를 정수로 표시하되 
--컬럼명을 New Salary로 지정하여 출력하라.
 select empno, ename, sal, round(sal*1.15) as "New Salary"
 from emp;
 
--16> 15번 문제와 동일한 데이타에서 급여 인상분(새 급여에서 이전 
-- 급여를 뺀 값)을 추가해서 출력하라.(컬럼명은 Increase로 하라). 
select empno, ename, sal, round(sal*1.15) as "New Salary" , round(sal*0.15) as "Increase"
from emp;
 
--18> 모든 사원의 이름(첫 글자는 
-- 대문자로, 나머지 글자는 소문자로 표시) 및 이름 길이를 표시하는
-- 쿼리를 작성하고 컬럼 별칭은 적당히 넣어서 출력하라.
select initcap(ename) as "이름", length(ename) as "이름 길이"
from emp;
 
--19> 사원의 이름과 커미션을 출력하되, 커미션이 책정되지 않은 
-- 사원의 커미션은 'no commission'으로 출력하라.
 select ename, nvl(to_char(comm), 'no commission')
 from emp;
 
 select * from emp;

--20> 모든 사원의 이름,부서번호,부서이름을 표시하는 질의를 작성하라.
 select e.ename, d.deptno, d.dname
 from emp e join dept d
 on e.deptno = d.deptno;
 
 --선생님답
 SELECT empno, deptno , DECODE(deptno,10,'ACCOUNTING' ,
                                                    20,'RESEARCH',
                                                    30,'SALES',
                                                    40,'OPERATIONS') AS "dname"
FROM EMP;
 
--21> 30번 부서에 속한 사원의 이름과 부서번호 그리고 부서이름을 출력하라.
 select e.ename, d.deptno, d.dname
 from emp e join dept d
 on e.deptno = d.deptno
 where e.deptno = 30;
 
 
--22> 30번 부서에 속한 사원들의 모든 직업과 부서위치를 출력하라.
--(단, 직업 목록이 중복되지 않게 하라.)
 select distinct e.job, d.loc
 from emp e join dept d
 on e.deptno = d.deptno
 where e.deptno = 30;
 
 
--23> 커미션이 책정되어 있는 모든 사원의 이름, 부서이름 및 위치를 출력하라.
select e.ename, d.dname, d.loc
from emp e join dept d
on e.deptno = d.deptno
where e.comm is not null;
 
--24> 이름에 A가 들어가는 모든 사원의 이름과 부서 이름을 출력하라.
 select e.ename, d.dname
from emp e join dept d
on e.deptno = d.deptno
where e.ename like '%A%';
 
 
--25> Dallas에서 근무하는 모든 사원의 이름, 직업, 부서번호 및 부서이름을 
-- 출력하라.
select e.ename, e.job, d.deptno, d.dname
from emp e join dept d
on e.deptno = d.deptno
where d.loc='DALLAS';
 
 
--26> 사원이름 및 사원번호, 해당 관리자이름 및 관리자 번호를 출력하되,
-- 각 컬럼명을 employee,emp#,manager,mgr#으로 표시하여 출력하라.
select e.ename as "employee", 
e.empno as "emp#",
p.ename as "manager",
e.mgr as "mgr#"
from emp e join emp p
on e.mgr = p.empno;
 
--27> 모든 사원의 이름,직업,부서이름,급여 및 등급을 출력하라.
select e.ename, e.job, d.dname, e.sal, s.grade
from emp e join salgrade s
on e.sal between s.losal and s.hisal
join dept d
on e.deptno = d.deptno;
 
--28> Smith보다 늦게 입사한 사원의 이름 및 입사일을 출력하라.
select ename, hiredate
from emp
where hiredate >( select hiredate from emp where ename='SMITH');
 
--29> 자신의 관리자보다 먼저 입사한 모든 사원의 이름, 입사일, 
-- 관리자의 이름, 관리자의 입사일을 출력하되 각각 컬럼명을 
-- Employee,EmpHiredate, Manager,MgrHiredate로 표시하여 
-- 출력하라.
select e.ename as "Employee", e.hiredate as "EmpHiredate", e.mgr as "Manager", p.ename as "MgrHiredate"
from emp e join emp p
on e.mgr=p.empno
where e.hiredate< p.hiredate;
 
--30> 모든 사원의 급여 최고액,최저액,총액 및 평균액을 출력하되 
-- 각 컬럼명을 Maximum,Minimum,Sum,Average로 지정하여 출력하라.
select max(sal) as "Maximun", min(sal) as "Minimum", sum(sal) as "Sum", avg(sal) as "Average"
from emp;

--31> 각 직업별로 급여 최저액.최고액,총액 및 평균액을 출력하라.
select job, max(sal) as "Maximun", min(sal) as "Minimum", sum(sal) as "Sum", avg(sal) as "Average"
from emp
group by job;

--32> 직업이 동일한 사람 수를 직업과 같이 출력하라.
 select job, count(job)
 from emp
 group by job;
 
 
--33> 관리자의 수를 출력하되, 관리자 번호가 중복되지 않게하라.
-- 그리고, 컬럼명을 Number of Manager로 지정하여 출력하라.
select count(distinct mgr) as "Number of Manager"
from emp;
 
--34> 최고 급여와 최저 급여의 차액을 출력하라.
select max(sal)-min(sal)
from emp;
 
--35> 관리자 번호 및 해당 관리자에 속한 사원들의 최저 급여를 출력하라.
-- 단, 관리자가 없는 사원 및 최저 급여가 1000 미만인 그룹은 제외시키고 
-- 급여를 기준으로 출력 결과를 내림차순으로 정렬하라.
 
 select mgr, min(sal)
 from emp
 where mgr is not null
 group by mgr
 having min(sal)>=1000
 order by min(sal) desc;

--36> 부서별로 부서이름, 부서위치, 사원 수 및 평균 급여를 출력하라.
-- 그리고 각각의 컬럼명을 부서명,위치,사원의 수,평균급여로 표시하라.
select d.dname as "부서명", d.loc as "부서 위치", count(empno) as "사원의 수", avg(sal) as "평균급여"
from emp e join dept d
on e.deptno = d.deptno
group by d.dname, d.loc;
 
--37> Smith와 동일한 부서에 속한 모든 사원의 이름 및 입사일을 출력하라.
-- 단, Smith는 제외하고 출력하시오
select ename, hiredate
from emp 
where deptno = (select deptno from emp where ename='SMITH') and
ename!='SMITH';
 
--38> 자신의 급여가 평균 급여보다 많은 모든 사원의 사원 번호, 이름, 급여를 
--    표시하는 질의를 작성하고 급여를 기준으로 결과를 내림차순으로 정렬하라.
select empno, ename, sal
from emp
where sal > (select avg(sal) from emp)
order by sal desc;
 
--39> 이름에 T가 들어가는 사원의 속한 부서에서 근무하는 모든 사원의 사원번호
-- 및 이름을 출력하라.
select empno, ename
from emp
where deptno in (select deptno from emp where ename like '%T%');
 
 
--40> 부서위치가 Dallas인 모든 사원의 이름,부서번호 및 직위를 출력하라.
 select e.ename, d.deptno, e.job
 from emp e join dept d
 on e.deptno = d.deptno
 where d.loc = 'DALLAS';
 
--41> KING에게 보고하는 모든 사원의 이름과 급여를 출력하라.
 select ename, sal
 from emp
where mgr = (select empno from emp where ename='KING');

--42> Sales 부서의 모든 사원에 대한 부서번호, 이름 및 직위를 출력하라.
 select d.deptno, e.ename, e.job
 from emp e join dept d
 on e.deptno = d.deptno
 where d.dname = 'SALES';
 
--43> 자신의 급여가 평균 급여보다 많고 이름에 T가 들어가는 사원과 동일한
-- 부서에 근무하는 모든 사원의 사원 번호, 이름 및 급여를 출력하라.
 select empno, ename, sal
 from emp
 where deptno in(
   select deptno 
    from emp
    where (ename like '%T%') and sal > (select avg(sal) from emp)
);
 
 
--44> 커미션을 받는 사원과 급여가 일치하는 사원의 이름,부서번호,급여를 
-- 출력하라.
select ename, deptno, sal
from emp
where sal in (select sal from emp where comm is not null);
 
 
--45> Dallas에서 근무하는 사원과 직업이 일치하는 사원의 이름,부서이름,
--     및 급여를 출력하시오
select e.ename, d.dname, e.sal
from emp e join dept d
on e.deptno = d.deptno
where job in (select job from emp where d.loc='DALLAS');
 
 
--46> Scott과 동일한 급여 및 커미션을 받는 모든 사원의 이름, 입사일 및 
-- 급여를 출력하시오
select ename, hiredate, sal
from emp
where sal = (select sal from emp where ename='SCOTT')
and nvl(comm,0) = (select nvl(comm,0) from emp where ename='SCOTT');

 
--47> 직업이 Clerk 인 사원들보다 더 많은 급여를 받는 사원의 사원번호,
-- 이름, 급여를 출력하되, 결과를 급여가 높은 순으로 정렬하라.
select empno, ename, sal
from emp
where sal > all(select sal from emp where job='CLERK')
order by sal desc;
  
--48> 이름에 A가 들어가는 사원과 같은 직업을 가진 사원의 이름과
-- 월급, 부서번호를 출력하라.
select ename, sal, deptno
from emp
where job in (select job from emp where ename like '%A%');
 
 
--49> New  York 에서 근무하는 사원과 급여 및 커미션이 같은 사원의 
-- 사원이름과 부서명을 출력하라.
select e.ename, d.dname
from emp e join dept d
on e.deptno = d.deptno
where sal in (select sal from emp where d.loc='NEW YORK') 
and nvl(comm,0) in (select nvl(comm,0) from emp where d.loc='NEW YORK');

--50> Dallas에서 근무하는 사원과 직업 및 관리자가 같은 사원의 사원번호,사원이름,
--    직업,월급,부서명,커미션을 출력하되 커미션이 책정되지 않은 사원은 NoCommission
--    으로 표시하고, 커미션의 컬럼명은 Comm으로 나오게 출력하시오.
--    단, 최고월급부터 출력되게 하시오

select e.empno, e.ename, e.job, e.sal, d.dname, nvl(to_char(e.comm), 'NoCommission') as Comm
from emp e join dept d
on e.deptno = d.deptno
where job in (select job from emp where d.loc='DALLAS') 
and mgr in (select mgr from emp where d.loc='DALLAS')
order by sal desc;


-------------------------------------------------------
create table dmlemp
as
    select * from emp;
    
select * from dmlemp;

alter table dmlemp
add constraint pk_dmlemp_empno primary key(empno);

select * from sys.user.constraints where table_name='DMLEMP';



create table trans_A(
	num number,
	name varchar2(20)
);

create table trans_B(
	num number constraint pk_trans_B_num primary key,
	name varchar2(20)
);

select * from trans_A;
select * from trans_B;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          

select * from user_constraints where table_name='DEPT';

select * from dept;

alter table dept
add constraint pk_dept_deptno primary key(deptno);

select deptno , dname , loc from dept;

create table Department
(
    deptno number,
    dname varchar2(50)
); 

--------------------------------------------
--jsp jdbc 실습 예제

CREATE TABLE koreaMember
(
    id VARCHAR2(50) PRIMARY KEY ,
    pwd VARCHAR2(50) NOT NULL,
    NAME VARCHAR2(50) NOT NULL,
    age NUMBER ,
    gender CHAR(4),
    email VARCHAR2(50),
    ip   VARCHAR2(50)
);


desc koreaMember;
select * from koreaMember;




CREATE TABLE team2Board
(
    title VARCHAR2(50) NOT NULL,
    name VARCHAR2(50) NOT NULL,
    content VARCHAR2(4000)
);
select * from team2Board;

desc team2Board;

rollback;

drop table team2Board;
