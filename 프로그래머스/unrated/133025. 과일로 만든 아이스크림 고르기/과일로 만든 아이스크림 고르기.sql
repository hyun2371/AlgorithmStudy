-- 코드를 입력하세요
SELECT i.flavor from ICECREAM_INFO i
join FIRST_HALF f
on f.flavor = i.flavor
where total_order>3000 AND INGREDIENT_TYPE = 'fruit_based'
order by total_order desc;