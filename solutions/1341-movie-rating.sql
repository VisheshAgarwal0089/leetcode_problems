# Write your MySQL query statement below
(select u.name as results
FROM users u
JOIN movierating mr 
ON u.user_id=mr.user_id
group by u.user_id
order by count(mr.movie_id) DESC, u.name ASC LIMIT 1)
UNION ALL
(select m.title as results
from movies m
join movierating mr
on m.movie_id = mr.movie_id
where mr.created_at between '2020-02-01' and '2020-02-29'
group by m.title
order by AVG(mr.rating) DESC, m.title ASC LIMIT 1);