# Write your MySQL query statement below
SELECT P.EMAIL FROM PERSON P 
GROUP BY P.EMAIL
HAVING COUNT(*)>1;