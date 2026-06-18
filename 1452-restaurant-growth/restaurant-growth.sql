# Write your MySQL query statement below
SELECT visited_on,
(
    SELECT SUM(amount)
    FROM Customer
    WHERE visited_on BETWEEN date_sub(c.visited_on, interval 6 day)
    AND c.visited_on
) as amount,
ROUND((
    SELECT SUM(amount) /7
    FROM Customer
    WHERE visited_on BETWEEN date_sub(c.visited_on, interval 6 day)
    AND c.visited_on
),2) as average_amount
FROM Customer as c
WHERE visited_on >= (
    SELECT date_add(MIN(visited_on), interval 6 day)
    FROM Customer
)
GROUP BY visited_on
ORDER BY visited_on