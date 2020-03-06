select
    EMPLOYEE_ID
    , PICTURE
    , NAME
from
    PROFILE
where
    /*%if profile.name != null */
    NAME like /* @infix(profile.name.value) */'%name%' escape '$'
    /*%end */

    /*%if profile.hobby != null */
    and
    HOBBY like /* @infix(profile.hobby.value) */'%hobby%' escape '$'
    /*%end */

    /*%if profile.birthplace != null */
    and
    BIRTHPLACE = /* profile.birthplace */0
    /*%end */
