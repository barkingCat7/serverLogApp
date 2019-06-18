--(1) Write MySQL query to find IPs that mode more than a certain number of requests for a given time period.

--    Ex: Write SQL to find IPs that made more than 100 requests starting from 2017-01-01.13:00:00 to 2017-01-01.14:00:00.

--(2) Write MySQL query to find requests made by a given IP.

--query 1
select r.ip_address from Record r where r.date_time BETWEEN "2017-01-01 13:00:00" AND "2017-01-01 14:00:00" GROUP BY r.ip_address HAVING count(r.ip_address) >= 100

--query 2
SELECT * FROM record WHERE record.ip_address="192.168.11.231"