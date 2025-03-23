-- 코드를 입력하세요
SELECT pt_name, pt_no, gend_cd, age, IFNULL(TLNO,'NONE') AS TLNO
from patient
where age<=12 and gend_cd ='W'
ORDER BY AGE DESC, PT_NAME;