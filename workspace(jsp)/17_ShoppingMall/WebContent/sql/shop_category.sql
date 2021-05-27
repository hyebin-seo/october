-- shop_category 테이블 생성

create table shop_category(
	category_num number(4) primary key,        -- 카테고리 번호
	category_code varchar2(10) not null,       -- 카테고리 코드
	category_name varchar2(100) not null       -- 카테고리 이름
);