-- jsp_bbs 테이블 생성
-- bbs(Bulletin Board System : 전자 게시판)

-- jsp_bbs 게시판 컬럼 구성

create table jsp_bbs(
	board_no number(5) primary key,
	board_writer varchar2(20) not null,
	board_title varchar2(100) not null,
	board_cont varchar2(1000) not null,
	board_pwd varchar2(20) not null,
	board_hit number(5) default 0,
	board_date date,
	board_group number(5),
	board_step number(5),
	board_indent number(5)
);