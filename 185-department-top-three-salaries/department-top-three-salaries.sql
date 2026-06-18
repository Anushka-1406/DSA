# Write your MySQL query statement below
SELECT department , Employee , Salary FROM 
(
SELECT d.name as department,e.name as Employee , e.salary as  Salary,
dense_rank() OVER(PARTITION BY d.name ORDER BY e.salary DESC) as ranks
FROM Employee e
LEFT JOIN Department d
ON e.departmentid = d.id
) as temp
WHERE ranks <=3