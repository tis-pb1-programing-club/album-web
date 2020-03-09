select
    EMPLOYEE_ID
    , PICTURE
    , NAME
from
    PROFILE
where
    /*%if profile.name != null && profile.name.value != null && profile.name.value != ""*/
    NAME like /* @infix(profile.name.value) */'%name%' escape '$'
    /*%end */

    /*%if profile.hobby != null && profile.hobby.value != null && profile.hobby.value != ""*/
    and
    HOBBY like /* @infix(profile.hobby.value) */'%hobby%' escape '$'
    /*%end */

    /*%if profile.birthplace != null */
    and
    BIRTHPLACE = /* profile.birthplace.code */0
    /*%end */
