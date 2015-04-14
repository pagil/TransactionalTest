-- http://localhost:8080/TransactionalTest/dbconsole

select * from LIVE_STOCK;
select * from PRICE_HISTORY;
select * from LIVE_STOCK_PRICE_HISTORY;

select * from (select ls.ID NEW_ID, count(*) NEW_COUNT from LIVE_STOCK ls
  join LIVE_STOCK_PRICE_HISTORY lsph on lsph.LIVE_STOCK_PRICE_HISTORIES_ID = ls.ID
  join PRICE_HISTORY ph on lsph.PRICE_HISTORY_ID = ph.ID
group by ls.ID)
where NEW_COUNT> 1;