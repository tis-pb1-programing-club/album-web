--INSERT INTO HELLO ( ID, MESSAGE ) VALUES ( 0, 'HELLO WORLD!' );
--
--INSERT INTO PROFILE (
--    EMPLOYEE_ID
--    , LAST_NAME
--    , FIRST_NAME
--    , JOINING_YEAR
--    , SEX
--    , BLOOD_TYPE
--    , TEAM
--    , CUSTOMER
--    , PROJECT
--    , PRIVATE_SENTENCE
--    , COMMENT
--)
--VALUES (
--    0
--    , 'クー'
--    , 'にゃんこ'
--    , 2017
--    , 0
--    , 0
--    , '長毛'
--    , '人間'
--    , 'おなか見せ'
--    , 'ずっと寝てます。' || CHAR(13) || CHAR(10) || 'Tulleが好きです。' || CHAR(13) || CHAR(10) || 'お風呂は嫌いです。'
--    , 'にゃーお'
--), (
--    1
--    , 'クー1'
--    , 'にゃんこ1'
--    , 2018
--    , 1
--    , 1
--    , '長毛1'
--    , '人間1'
--    , 'おなか見せ1'
--    , 'ずっと寝てます。' || CHAR(13) || CHAR(10) || 'Tulleが好きです。' || CHAR(13) || CHAR(10) || 'お風呂は嫌いです。'
--    , 'にゃーお1'
--);
--
--INSERT INTO CAREER (
--    EMPLOYEE_ID
--    , CAREER_ID
--    , YEAR
--    , MONTH
--    , EVENT
--)
--VALUES (
--    0
--    , 0
--    , 2016
--    , 4
--    , '産まれる'
--)
--,(
--    0
--    , 1
--    , 2018
--    , 6
--    , '飼われる'
--);

-- adminユーザを登録する
insert into users values ('admin', '$2a$10$vTHgo5H7j7ayxcK7M9j4RuSNmiegX.Kng6c08BR/rWFW4U4gxsUO2');
insert into user_role (username, role)
values ('admin', 'ROLE_admin');
-- 一般ユーザ
insert into users
values ('qoo', '$2a$10$vTHgo5H7j7ayxcK7M9j4RuSNmiegX.Kng6c08BR/rWFW4U4gxsUO2');
insert into user_role (username, role)
values ('qoo', 'ROLE_user');
