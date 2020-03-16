SELECT
 /*%expand*/*
FROM ACCOUNT account JOIN PROFILE profile
 ON account.employee_id = profile.employee_id
WHERE
/*%if @isNotEmpty(employeeId) */
 account.employee_id = /* employeeId */tie000000
/*%end */
/*%if @isNotEmpty(isAdmin) */
 AND
 account.is_admin = /* isAdmin */0
/*%end */
/*%if @isNotEmpty(name) */
 AND
 profile.name LIKE /* name */
/*%end */
