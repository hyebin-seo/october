-- board ���̺� ����

create table board(
	board_no number(5) primary key,
	board_writer varchar(2) not null,
	board_title varchar2(100) not null,
	board_cont varchar2(1000),
	board_pwd varchar2(20) not null,
	board_hit number(5) default 0,
	board_regdate date
);

-- board ���̺� ������ ����
create sequence board_seq
start with 1
increment by 1
nocache;

-- board ���̺� ������ �߰�
insert into board values
(board_seq.nextval, 'ȫ�浿', '����1','�浿�̱�','1111', dafualt, sysdate);
insert into board values
(board_seq.nextval, '�̼���', '���� ��','�̼��ż���','2222', dafualt, sysdate);
insert into board values
(board_seq.nextval, '������', '���� ��','���� ��','3333', dafualt, sysdate);
insert into board values
(board_seq.nextval, '������', '���� ��1','���� ��','4444', dafualt, sysdate);
insert into board values
(board_seq.nextval, '�迬��', '���� ��','���� ��','5555', dafualt, sysdate);
