# Write your MySQL query statement below
SELECT euni.unique_id , e.name
from Employees as e
LEFT JOIN EmployeeUNI as euni
ON e.id = euni.id;