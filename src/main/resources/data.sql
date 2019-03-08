INSERT INTO HELLO ( ID, MESSAGE ) VALUES ( 0, 'HELLO WORLD!' );

INSERT INTO PERSONAL (
    PERSONAL_ID
    , FAMILY_NAME
    , PERSONAL_NAME
    , YEARLY
    , SEX
    , BLOOD_TYPE
    , TEAM
    , CUSTOMER
    , PROJECT
    , PRIVATE_SENTENCE
    , COMMENT
)
VALUES (
    0
    , 'クー'
    , 'にゃんこ'
    , 2
    , 0
    , 0
    , '長毛'
    , '人間'
    , 'おなか見せ'
    , 'ずっと寝てます。' || CHAR(13) || CHAR(10) || 'Tulleが好きです。' || CHAR(13) || CHAR(10) || 'お風呂は嫌いです。'
    , 'にゃーお'
), (
    1
    , 'クー1'
    , 'にゃんこ1'
    , 2
    , 1
    , 1
    , '長毛1'
    , '人間1'
    , 'おなか見せ1'
    , 'ずっと寝てます。' || CHAR(13) || CHAR(10) || 'Tulleが好きです。' || CHAR(13) || CHAR(10) || 'お風呂は嫌いです。'
    , 'にゃーお1'
);

INSERT INTO HISTORY (
    PERSONAL_ID
    , HISTORY_ID
    , YEAR
    , MONTH
    , EVENT
)
VALUES (
    0
    , 0
    , 2016
    , 4
    , '産まれる'
)
,(
    0
    , 1
    , 2018
    , 6
    , '飼われる'
);