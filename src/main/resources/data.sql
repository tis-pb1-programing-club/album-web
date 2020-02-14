INSERT INTO ACCOUNT VALUES (
    'tie000000',
    'pass123-',
    '1'
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
    IS_NEWCOMER,
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
    '東京'
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
