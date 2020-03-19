SELECT *
FROM ACCOUNT AS A INNER JOIN PROFILE AS P
  ON A.EMPLOYEE_ID = P.EMPLOYEE_ID
WHERE
/*%if employeeId != null*/
A.EMPLOYEE_ID = /* employeeId */'0'
/*%end*/
AND
/*%if name != null*/
P.NAME LIKE /* @infix(name) */'taro'
/*%end*/
AND
/*%if isAdmin != null*/
A.IS_ADMIN = /* isAdmin */'1'
/*%end*/
