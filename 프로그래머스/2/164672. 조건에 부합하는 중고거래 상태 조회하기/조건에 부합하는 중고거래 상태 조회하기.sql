-- 코드를 입력하세요
SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, case when status = 'DONE' then '거래완료'
                                                when status ='SALE' then '판매중'
                                                else '예약중' end as status

from used_goods_board
where year(created_date) = 2022 and month(created_date) = 10 and day(created_date) =5
order by BOARD_ID desc