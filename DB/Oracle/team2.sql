Copy from bit/1004 Create EMP using select * from EMP; 

select * from emp;

Copy from bit/1004 Create DEPT using select * from DEPT; 

select * from dept;

ALTER TABLE EMP ADD(img varchar2(30));

select * from (select rownum rn,empno, ename, job, deptno from emp where rownum <= 5) where rn >= 1;
