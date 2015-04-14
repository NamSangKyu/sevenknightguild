USE mytest;
CREATE  TABLE guildmember (
  code INT(8) NOT NULL AUTO_INCREMENT,
  nick VARCHAR(30) NOT NULL,
  password VARCHAR(30) NOT NULL,
  joindate Date NOT NULL,
  dropdate Date NULL DEFAULT NULL,
  PRIMARY KEY (code))
DEFAULT CHARACTER SET = utf8;

insert into guildmember(nick, password, joindate) values('역시마스터','1234','2015-02-17');
insert into guildmember(nick, password, joindate) values('역시상타규','1234','2015-02-17');
insert into guildmember(nick, password, joindate) values('역시벌크','1234','2015-02-17');
insert into guildmember(nick, password, joindate) values('역시귀족','1234','2015-02-17');
insert into guildmember(nick, password, joindate) values('역시Coakin','1234','2015-02-17');
insert into guildmember(nick, password, joindate) values('힘겨운하루','1234','2015-02-17');
insert into guildmember(nick, password, joindate) values('엔카','1234','2015-02-17');

drop table guildmember

--탈퇴한 회원
select * from guildmember  where dropdate is not null

--현재 회원
select * from guildmember  where dropdate is null

select nick from guildmember where dropdate is null
-- guild war
CREATE  TABLE guildwar(
  code INT(16) NOT NULL,
  takepart INT(8) DEFAULT 0,
  dateinfo DATE NOT NULL
  )
DEFAULT CHARACTER SET = utf8;

drop table guildwar

-- guild siege warfare
select * from guildwar

select m.code, m.nick, takepart from guildwar w, guildmember m where m.code = w.code AND dateinfo = '2015-04-13'  

insert into guildwar values(1,1,'2015-04-12');
insert into guildwar values(2,1,'2015-04-12');
insert into guildwar values(3,1,'2015-04-12');
insert into guildwar values(4,1,'2015-04-12');
insert into guildwar values(7,1,'2015-04-12');
insert into guildwar values(1,1,'2015-04-13');
insert into guildwar values(2,1,'2015-04-13');
insert into guildwar values(3,1,'2015-04-13');
insert into guildwar values(4,1,'2015-04-13');
insert into guildwar values(7,1,'2015-04-13');




CREATE  TABLE warface (
  code INT(16) NOT NULL,
  score INT(16) NULL DEFAULT 0,
  dateinfo DATE NOT NULL)
  
insert into warface values(1, 30000, '2015-04-12');
insert into warface values(1, 23000, '2015-04-11');
insert into warface values(1, 42000, '2015-04-10');
insert into warface values(1, 54000, '2015-04-09');
insert into warface values(2, 20000, '2015-04-12');
insert into warface values(2, 13000, '2015-04-11');
insert into warface values(2, 32000, '2015-04-10');
insert into warface values(2, 14400, '2015-04-09');
insert into warface values(3, 33300, '2015-04-12');
insert into warface values(3, 23400, '2015-04-11');
insert into warface values(3, 55000, '2015-04-10');
insert into warface values(3, 65400, '2015-04-09');
insert into warface values(4, 20000, '2015-04-12');
insert into warface values(4, 33000, '2015-04-11');
insert into warface values(4, 52000, '2015-04-10');
insert into warface values(4, 84400, '2015-04-09');
insert into warface values(5, 89900, '2015-04-12');
insert into warface values(5, 97650, '2015-04-11');
insert into warface values(5, 57700, '2015-04-10');
insert into warface values(5, 75540, '2015-04-09');
insert into warface values(7, 3900, '2015-04-12');

select * from warface

delete from warface

--회원 공성 정보 조회 해당월
select score, dateinfo from warface w, guildmember m where w.code = 1 AND dateinfo like '%-04-%' AND w.code = m.code order by dateinfo asc
--전체회원 공성 정보 조회 해당월
select w.code, score, dateinfo from warface w, guildmember m where dateinfo like '2015-04-12' AND w.code = m.code  order by dateinfo asc

select nick from warface w, guildmember m where dateinfo like '2015-04-11' AND m.code = w.code

--해당 회원 월 공성 평균
select w.code, nick, avg(score) as average from warface w, guildmember m where w.code = 1 AND dateinfo like '2015-04-%' AND w.code = m.code


select m.code, nick, avg(score) as average from warface w, (select code, nick from guildmember) m 
where w.code = m.code group by code order by average desc

select * from warface where dateinfo like '%-02-%'
