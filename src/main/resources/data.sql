INSERT INTO ACCOUNT VALUES (
    'tie000000',
    'pass123-'
);

INSERT INTO BIRTHPLACE VALUES (
    '1',
    '東京'
);

INSERT INTO GENDER VALUES (
    '0',
    '男性'
), (
    '1',
    '女性'
), (
    '2',
    '無回答'
);

INSERT INTO BLOOD_TYPE VALUES (
    '0',
    'A型'
), (
    '1',
    'B型'
), (
    '2',
    'O型'
), (
    '3',
    'AB型'
);

INSERT INTO PROFILE (
    EMPLOYEE_ID,
    NAME,
    HIRE_DATE,
    RECRUIT,
    GENDER_ID,
    BLOOD_TYPE_ID,
    SALES_POINT,
    HOBBY,
    BIRTHPLACE
)
VALUES (
    'tie000000',
    'TIS太郎',
    '201604',
    '0',
    '0',
    '1',
    'セールスポイント',
    '趣味',
    '13'
);

INSERT INTO CAREER VALUES (
    'tie000000',
    '201604',
    '201608',
    'PJ名',
    '業務内容'
);

INSERT INTO REGISTRATION_UPDATE VALUES (
    'tie000000',
    '2020-2-15 10:23:54'
);

INSERT INTO TEAM VALUES (
    '1',
    'チーム名'
);

INSERT INTO BELONG VALUES (
    'tie000000',
    '1'
);

INSERT INTO ACCOUNT VALUES (
    'tie333333',
    'pass123-'
);

INSERT INTO PROFILE (
    EMPLOYEE_ID,
    NAME,
    HIRE_DATE,
    RECRUIT,
    GENDER_ID,
    BLOOD_TYPE_ID,
    SALES_POINT,
    HOBBY,
    BIRTHPLACE
)
VALUES (
    'tie333333',
    '三郎丸',
    '201504',
    '0',
    '0',
    '1',
    'セールスポイント',
    '趣味',
    '13'
);


INSERT INTO ACCOUNT VALUES (
    'tie222222',
    'pass123-'
);

INSERT INTO PROFILE (
    EMPLOYEE_ID,
    NAME,
    HIRE_DATE,
    RECRUIT,
    GENDER_ID,
    BLOOD_TYPE_ID,
    SALES_POINT,
    HOBBY,
    BIRTHPLACE
)
VALUES (
    'tie222222',
    '次郎丸',
    '201404',
    '0',
    '0',
    '1',
    'セールスポイント',
    '趣味',
    '13'
);


INSERT INTO ACCOUNT VALUES (
    'tie111111',
    'pass123-'
);

INSERT INTO PROFILE (
    EMPLOYEE_ID,
    NAME,
    HIRE_DATE,
    RECRUIT,
    GENDER_ID,
    BLOOD_TYPE_ID,
    SALES_POINT,
    HOBBY,
    BIRTHPLACE
)
VALUES (
    'tie111111',
    '一郎丸',
    '201304',
    '0',
    '0',
    '1',
    'セールスポイント',
    '趣味',
    '13'
);

INSERT INTO ACCOUNT VALUES (
    'tie444444',
    'pass123-'
);

INSERT INTO USER_ROLE VALUES (
    'tie111111',
    'ROLE_ADMIN'
);
INSERT INTO USER_ROLE VALUES (
    'tie222222',
    'ROLE_ADMIN'
);

INSERT INTO USER_ROLE VALUES (
    'tie000000',
    'ROLE_ADMIN'
);

INSERT INTO USER_ROLE VALUES (
    'tie333333',
    'ROLE_USER'
);

INSERT INTO USER_ROLE VALUES (
    'tie444444',
    'ROLE_ADMIN'
);
