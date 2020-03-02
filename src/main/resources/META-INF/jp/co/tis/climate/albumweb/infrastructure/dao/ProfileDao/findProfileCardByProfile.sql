select
    EMPLOYEE_ID
    , PICTURE
    , NAME
from
    PROFILE
where
    /*%if profile.name != null */
    NAME like /* @contain(profile.name) */'%name%' escape '$'
    /*%end */

    /*%if profile.bloodTypeId != null */
    and
    BLOOD_TYPE_ID = /* profile.bloodTypeId */0
    /*%end */

    /*%if profile.hobby != null */
    and
    HOBBY like /* @contain(profile.hobby) */'%hobby%' escape '$'
    /*%end */

    /*%if profile.birthplace != null */
    and
    BIRTHPLACE = /* profile.birthplace */0
    /*%end */
