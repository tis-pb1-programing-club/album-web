SELECT
 ACCOUNT.EMPLOYEE_ID,
 CASE WHEN USER_ROLE.ROLE = 'ROLE_ADMIN' THEN 1 ELSE 0 END AS IS_ADMIN,
 PROFILE.NAME
FROM ACCOUNT JOIN PROFILE
 ON ACCOUNT.EMPLOYEE_ID = PROFILE.EMPLOYEE_ID
 LEFT OUTER JOIN USER_ROLE
 ON ACCOUNT.EMPLOYEE_ID = USER_ROLE.EMPLOYEE_ID
WHERE
/*%if @isNotEmpty(employeeId) */
 ACCOUNT.EMPLOYEE_ID = /* employeeId */'tie000000'
/*%end */
/*%if @isNotEmpty(isAdmin) */
 /*%if "1".equals(isAdmin) */
  AND
  USER_ROLE.ROLE = 'ROLE_ADMIN'
 /*%else */
  AND
  USER_ROLE.ROLE is NULL
 /*%end */
/*%end */
/*%if @isNotEmpty(name) */
 AND
 PROFILE.NAME LIKE /* name */'%太郎%'
/*%end */
