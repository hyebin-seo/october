-- jsp_bbs 테이블 생성
-- BBS(Bulletin Board System : 전자 게시판)

-- jsp_bbs 게시판 컬럼 구성

create table jsp_bbs(
	board_no number(5) primary key,          -- 게시판 글번호
	board_writer varchar2(20) not null,      -- 게시판 글 작성자
	board_title varchar2(100) not null,      -- 게시판 글제목
	board_cont varchar2(1000) not null,      -- 게시판 글내용
	board_pwd varchar2(20) not null,         -- 게시판 글 비밀번호
	board_hit number(5) default 0,           -- 게시판 글 조회수
	board_date date,                         -- 게시판 글 작성일자
	board_group number(5),                   -- 게시판 글 그룹
	board_step number(5),                    -- 게시판 글 답변 단계
	board_indent number(5)                   -- 게시판 답변글 들여쓰기
);

