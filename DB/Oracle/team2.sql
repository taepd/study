Copy from bit/1004 Create EMP using select * from EMP; 

select * from emp ;



Copy from bit/1004 Create DEPT using select * from DEPT; 

select * from dept;

ALTER TABLE EMP ADD(img varchar2(30));

select * from (select rownum rn,empno, ename, job, deptno from emp where rownum <= 5) where rn >= 1;
  

select distinct deptno from emp order by deptno asc;

desc emp;

select job,round(avg(sal),0),max(sal),min(sal) from emp group by job;


--TABLE 설계 (비인증형 답변(계층형)  게시판)
CREATE TABLE jspboard(
  idx NUMBER PRIMARY KEY , -- 글번호 (DB : 오라클(sequence 객체) , Ms-sql, Mysql(테이블 종속 자동증가)
  writer VARCHAR2(30) NOT NULL , --글쓴이 (회원전용: 로그인한 ID , 별칭     비회원용: 입력값 )
  pwd VARCHAR2(20) NOT NULL , --회원전용(x)  , 비회원전용(0 : 수정 ,삭제 )
  subject VARCHAR2(50) NOT NULL, --글제목
  content VARCHAR2(100) NOT NULL, --글내용
  writedate DATE DEFAULT SYSDATE, -- 작성일
  readnum NUMBER DEFAULT 0 , --글조회 (insert default 0)
  filename VARCHAR2(200),  --파일명 (test.txt)
  filesize NUMBER ,              --파일크기(byte)
  homepage VARCHAR2(50) ,
  email VARCHAR2(100), --필수 입력 사항 (not null) null값을 허용
  --답변형 게시판 구축
  refer   NUMBER DEFAULT 0 , -- 답변형 게시판 (참조글 or 글의 그룹번호)
  depth   NUMBER DEFAULT 0,  -- 답변형 게시판(depth(글의 깊이 , 들여쓰기)
  step    NUMBER DEFAULT 0   -- 답변형 게시판 (글의 정렬 순서 : 답글정렬순서)
);


    

--순번 처리 (oracle)
CREATE SEQUENCE jspboard_idx
START WITH 1
INCREMENT BY 1
NOCACHE;


--덧글(꼬리말) 을 위한 테이블 생성
--누구의 덧글인지를 판단 ....
CREATE TABLE reply(
  no NUMBER PRIMARY KEY ,
  writer VARCHAR2(30),
  userid VARCHAR2(30),
  pwd VARCHAR2(30),
  content VARCHAR2(100),
  writedate DATE DEFAULT SYSDATE ,
  idx_fk  REFERENCES jspboard(idx)
);

CREATE SEQUENCE reply_no
START WITH 1
INCREMENT BY 1
NOCACHE;


SELECT * FROM jspboard;
SELECT * FROM reply;

desc jspboard;
---------------------------------

--프로젝트 테이블들

-- 회원
DROP TABLE BITUSER;

-- 관리자
DROP TABLE ADMIN;

-- 공지사항
DROP TABLE NOTICE;

-- 댓글
DROP TABLE REPLY;

-- 게시글
DROP TABLE BOARD;

-- 이미지
DROP TABLE IMAGE;

-- 관심목록
DROP TABLE FAVORITE;

-- 카테고리
DROP TABLE CATEGORY;

-- 회원
CREATE TABLE BITUSER (
	ID      VARCHAR2(20)  NOT NULL, -- ID
	PWD     VARCHAR2(20)  NOT NULL, -- 비밀번호
	LOC     VARCHAR2(300) NOT NULL, -- 위치정보
	NICK    VARCHAR2(20)  NOT NULL, -- 닉네임
	PROFILE VARCHAR2(100) NULL      -- 프로필 사진
);

-- 회원 기본키
CREATE UNIQUE INDEX PK_BITUSER
	ON BITUSER ( -- 회원
		ID ASC -- ID
	);

-- 회원
ALTER TABLE BITUSER
	ADD
		CONSTRAINT PK_BITUSER -- 회원 기본키
		PRIMARY KEY (
			ID -- ID
		);

-- 관리자
CREATE TABLE ADMIN (
	ID  VARCHAR2(20) NOT NULL, -- 아이디
	PWD VARCHAR2(20) NOT NULL  -- 비밀번호
);

-- 관리자 기본키
CREATE UNIQUE INDEX PK_ADMIN
	ON ADMIN ( -- 관리자
		ID ASC -- 아이디
	);

-- 관리자
ALTER TABLE ADMIN
	ADD
		CONSTRAINT PK_ADMIN -- 관리자 기본키
		PRIMARY KEY (
			ID -- 아이디
		);

-- 공지사항
CREATE TABLE NOTICE (
	INDEX   NUMBER        NOT NULL, -- 글번호
	TITLE   VARCHAR2(100) NOT NULL, -- 제목
	CONTENT VARCHAR2(500) NOT NULL, -- 내용
	RTIME   DATE          NOT NULL, -- 등록시간
	NCSTATE CHAR(1)       NOT NULL, -- 공지사항 유무
	ID      VARCHAR2(20)  NOT NULL  -- 아이디
);

-- 공지사항 기본키
CREATE UNIQUE INDEX PK_NOTICE
	ON NOTICE ( -- 공지사항
		INDEX ASC -- 글번호
	);

-- 공지사항
ALTER TABLE NOTICE
	ADD
		CONSTRAINT PK_NOTICE -- 공지사항 기본키
		PRIMARY KEY (
			INDEX -- 글번호
		);

-- 댓글
CREATE TABLE REPLY (
	RPINDEX  NUMBER        NOT NULL, -- 댓글번호
	CONTENT  VARCHAR2(100) NOT NULL, -- 내용
	SCSTATE  CHAR(1)       NOT NULL, -- 비밀유무
	DELSTATE CHAR(1)       NOT NULL, -- 삭제유무
	TRSTATE  CHAR(1)       NOT NULL, -- 구매자 거래유무
	RTIME    DATE          NOT NULL, -- 등록시간
	REFER    NUMBER        NOT NULL, -- refer
	DEPTH    NUMBER        NOT NULL, -- depth
	STEP     NUMBER        NOT NULL, -- step
	ID       VARCHAR2(20)  NOT NULL, -- ID
	BDINDEX  NUMBER        NOT NULL  -- 글번호
);

-- 댓글 기본키
CREATE UNIQUE INDEX PK_REPLY
	ON REPLY ( -- 댓글
		RPINDEX ASC -- 댓글번호
	);

-- 댓글
ALTER TABLE REPLY
	ADD
		CONSTRAINT PK_REPLY -- 댓글 기본키
		PRIMARY KEY (
			RPINDEX -- 댓글번호
		);

-- 게시글
CREATE TABLE BOARD (
	BDINDEX  NUMBER        NOT NULL, -- 글번호
	TITLE    VARCHAR2(100) NOT NULL, -- 제목
	PRICE    NUMBER        NOT NULL, -- 가격
	CONTENT  VARCHAR2(500) NOT NULL, -- 내용
	RTIME    DATE          NOT NULL, -- 등록시간
	TRSTATE  CHAR(1)       NOT NULL, -- 판매자 거래유무
	DELSTATE CHAR(1)       NOT NULL, -- 삭제유무
	COUNT    NUMBER        NOT NULL, -- 조회수
	ID       VARCHAR2(20)  NOT NULL, -- ID
	CTCODE   VARCHAR2(20)  NOT NULL  -- 카테고리코드
);

-- 게시글 기본키
CREATE UNIQUE INDEX PK_BOARD
	ON BOARD ( -- 게시글
		BDINDEX ASC -- 글번호
	);

-- 게시글
ALTER TABLE BOARD
	ADD
		CONSTRAINT PK_BOARD -- 게시글 기본키
		PRIMARY KEY (
			BDINDEX -- 글번호
		);

-- 이미지
CREATE TABLE IMAGE (
	IMGINDEX NUMBER        NOT NULL, -- 이미지번호
	IMGNAME  VARCHAR2(100) NOT NULL, -- 이미지이름
	BDINDEX  NUMBER        NOT NULL  -- 글번호
);

-- 이미지 기본키
CREATE UNIQUE INDEX PK_IMAGE
	ON IMAGE ( -- 이미지
		IMGINDEX ASC -- 이미지번호
	);

-- 이미지
ALTER TABLE IMAGE
	ADD
		CONSTRAINT PK_IMAGE -- 이미지 기본키
		PRIMARY KEY (
			IMGINDEX -- 이미지번호
		);

-- 관심목록
CREATE TABLE FAVORITE (
	FAVINDEX NUMBER       NOT NULL, -- 관심목록 번호
	ID       VARCHAR2(20) NOT NULL, -- ID
	BDINDEX  NUMBER       NOT NULL  -- 글번호
);

-- 관심목록 기본키
CREATE UNIQUE INDEX PK_FAVORITE
	ON FAVORITE ( -- 관심목록
		FAVINDEX ASC -- 관심목록 번호
	);

-- 관심목록
ALTER TABLE FAVORITE
	ADD
		CONSTRAINT PK_FAVORITE -- 관심목록 기본키
		PRIMARY KEY (
			FAVINDEX -- 관심목록 번호
		);

-- 카테고리
CREATE TABLE CATEGORY (
	CTCODE VARCHAR2(20) NOT NULL, -- 카테고리코드
	CTNAME VARCHAR2(20) NOT NULL  -- 카테고리코드명
);

-- 카테고리 기본키
CREATE UNIQUE INDEX PK_CATEGORY
	ON CATEGORY ( -- 카테고리
		CTCODE ASC -- 카테고리코드
	);

-- 카테고리
ALTER TABLE CATEGORY
	ADD
		CONSTRAINT PK_CATEGORY -- 카테고리 기본키
		PRIMARY KEY (
			CTCODE -- 카테고리코드
		);

-- 공지사항
ALTER TABLE NOTICE
	ADD
		CONSTRAINT FK_ADMIN_TO_NOTICE -- 관리자 -> 공지사항
		FOREIGN KEY (
			ID -- 아이디
		)
		REFERENCES ADMIN ( -- 관리자
			ID -- 아이디
		);

-- 댓글
ALTER TABLE REPLY
	ADD
		CONSTRAINT FK_BITUSER_TO_REPLY -- 회원 -> 댓글
		FOREIGN KEY (
			ID -- ID
		)
		REFERENCES BITUSER ( -- 회원
			ID -- ID
		);

-- 댓글
ALTER TABLE REPLY
	ADD
		CONSTRAINT FK_BOARD_TO_REPLY -- 게시글 -> 댓글
		FOREIGN KEY (
			BDINDEX -- 글번호
		)
		REFERENCES BOARD ( -- 게시글
			BDINDEX -- 글번호
		);

-- 게시글
ALTER TABLE BOARD
	ADD
		CONSTRAINT FK_BITUSER_TO_BOARD -- 회원 -> 게시글
		FOREIGN KEY (
			ID -- ID
		)
		REFERENCES BITUSER ( -- 회원
			ID -- ID
		);

-- 게시글
ALTER TABLE BOARD
	ADD
		CONSTRAINT FK_CATEGORY_TO_BOARD -- 카테고리 -> 게시글
		FOREIGN KEY (
			CTCODE -- 카테고리코드
		)
		REFERENCES CATEGORY ( -- 카테고리
			CTCODE -- 카테고리코드
		);

-- 이미지
ALTER TABLE IMAGE
	ADD
		CONSTRAINT FK_BOARD_TO_IMAGE -- 게시글 -> 이미지
		FOREIGN KEY (
			BDINDEX -- 글번호
		)
		REFERENCES BOARD ( -- 게시글
			BDINDEX -- 글번호
		);

-- 관심목록
ALTER TABLE FAVORITE
	ADD
		CONSTRAINT FK_BITUSER_TO_FAVORITE -- 회원 -> 관심목록
		FOREIGN KEY (
			ID -- ID
		)
		REFERENCES BITUSER ( -- 회원
			ID -- ID
		);

-- 관심목록
ALTER TABLE FAVORITE
	ADD
		CONSTRAINT FK_BOARD_TO_FAVORITE -- 게시글 -> 관심목록
		FOREIGN KEY (
			BDINDEX -- 글번호
		)
		REFERENCES BOARD ( -- 게시글
			BDINDEX -- 글번호
		);


-- admin계정 추가
insert into admin values('admin',1004);

select * from admin;

commit;

desc admin;

desc bituser;

-- user테이블에 admin미리 입력
insert into bituser values('admin',1004, 'admin','admin','admin');

select * from bituser;

commit;

select * from user_sequences;

ALTER TABLE BOARD ADD IMG varchar2(500);

select * from board;

SELECT * from 
                        (select rownum rn, bdindex, title,price,content,rtime,trstate,delstate,count ,ctcode,id, loc 
                        FROM (SELECT b.bdindex,b.title,b.price,b.content,b.rtime,b.trstate,b.delstate,b.count,b.id,b.ctcode,u.loc FROM board b JOIN bituser u ON b.id = u.id order by b.bdindex desc)
                        where rownum <=5
                        ) where rn >= 1;
SELECT * from 
                        (select rownum rn, bdindex, title,price,content,rtime,trstate,delstate,count ,ctcode,id, loc 
                        FROM (SELECT b.*, u.loc FROM board b JOIN bituser u ON b.id = u.id order by b.bdindex desc)
                        where rownum <=5
                        ) where rn >= 1;
 SELECT * FROM board b JOIN bituser u ON b.id = u.id order by b.bdindex desc;
 
 select * from board;
 
 desc board;
 
 select * from bituser;
 
SELECT * FROM board b JOIN bituser u ON b.id = u.id;
  
select * from notice;

insert into notice values(3,'제목3','내용3','2020-05-26','Y','admin');

commit;

--공지사항 게시판 인덱스 순번 처리
CREATE SEQUENCE notice_ncindex
START WITH 1
INCREMENT BY 1
NOCACHE;

--게시글  인덱스 순번 처리
CREATE SEQUENCE board_bdindex
START WITH 1
INCREMENT BY 1
NOCACHE;

select rownum rn, n.* from notice n order by ncindex desc;


select * from
    (select rownum rn, n.* from notice n order by ncindex desc) 
        where rn between 1 and 10; 

desc notice;


select * from userqna;

select * from BITUSER;

select * from admin;

select * from board;

SELECT * FROM USER_SEQUENCES;


 select * from 
					(select rownum rn, qaindex, title, qatime, count, scstate, content, filename, id, awstate, nick from (
					SELECT q.*, u.nick FROM userqna q JOIN bituser u ON q.id = u.id order by q.qaindex desc
					) where rownum <=10) where rn >= 1;

commit;

ALTER TABLE BITUSER MODIFY (PROFILE DEFAULT 'profile.png');

SELECT * FROM USER_SEQUENCES;

