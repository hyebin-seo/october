-- board 테이블 생성

create table board(
	board_no number(5) primary key,
	board_writer varchar(2) not null,
	board_title varchar2(100) not null,
	board_cont varchar2(1000),
	board_pwd varchar2(20) not null,
	board_hit number(5) default 0,
	board_regdate date
);

-- board 테이블 시퀀스 생성
create sequence board_seq
start with 1
increment by 1
nocache;

-- board 테이블에 데이터 추가
insert into board values
(board_seq.nextval, '홍길동', '제목1','길동이글','1111', dafualt, sysdate);
insert into board values
(board_seq.nextval, '이순신', '순신 글','이순신순신','2222', dafualt, sysdate);
insert into board values
(board_seq.nextval, '유관순', '관순 글','관순 글','3333', dafualt, sysdate);
insert into board values
(board_seq.nextval, '김유신', '유신 글1','유신 글','4444', dafualt, sysdate);
insert into board values
(board_seq.nextval, '김연아', '연아 글','연라 글','5555', dafualt, sysdate);
