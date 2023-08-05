-- 코드를 입력하세요
SELECT TITLE, b.BOARD_ID, REPLY_ID, r.WRITER_ID, r.CONTENTS, 
        date_format(r.CREATED_DATE,"%Y-%m-%d") as CREATED_DATE
from used_goods_board b
join used_goods_reply r
on b.board_id = r.board_id
where b.created_date like "2022-10%"
order by r.created_date, title;