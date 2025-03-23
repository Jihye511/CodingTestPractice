-- 코드를 입력하세요
SELECT BOOK_ID, date_format(PUBLISHED_DATE,"%Y-%m-%d") as published_date
FROM BOOK
WHERE YEAR(PUBLISHED_DATE) ='2021' AND CATEGORY='인문'
order by published_date;