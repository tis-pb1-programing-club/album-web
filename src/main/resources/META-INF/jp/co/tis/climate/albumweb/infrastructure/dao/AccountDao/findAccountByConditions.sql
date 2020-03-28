SELECT /*%expand "A" */*
FROM ACCOUNT AS A
  INNER JOIN USER_ROLE AS U ON A.EMPLOYEE_ID = U.EMPLOYEE_ID
  LEFT OUTER JOIN PROFILE AS P ON A.EMPLOYEE_ID = P.EMPLOYEE_ID
WHERE
/*%if accountSearch.employeeId != null*/
A.EMPLOYEE_ID = /* accountSearch.employeeId */'0'
/*%end*/
/*%if accountSearch.name != null*/
AND
P.NAME LIKE /* @infix(accountSearch.name.getValue()) */'taro'
/*%end*/
/*%if accountSearch.role != null && accountSearch.role.getValue() == "admin"*/
AND
U.ROLE = 'ROLE_ADMIN'
/*%end*/
