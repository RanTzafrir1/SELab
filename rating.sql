/*query returns table: for each book number of his purchases. 
table ordered by number of purchases. table doesn't include book with no purchases*/

select purchases.bookid, count(*) as numberofpurchases
from purchases 
group by bookid
order by numberofpurchases desc;


select  cb.bookid,count(*) as numberofpurchases
from categorybook cb inner join purchases p on cb.bookid = p.bookid --join between two tables
where cb. category  = 'category1' -- 'category1' = thismessage.getMapValue("category")
group by bookid
order by numberofpurchases desc;
