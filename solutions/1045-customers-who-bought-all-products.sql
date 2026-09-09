# Write your MySQL query statement below
SELECT c.customer_id
FROM customer c
GROUP BY c.customer_id
having count(DISTINCT product_key) =(select count(*) from product);