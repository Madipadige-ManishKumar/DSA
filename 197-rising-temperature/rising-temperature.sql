# Write your MySQL query statement below
SELECT W.ID 
FROM WEATHER W
JOIN WEATHER A 
ON DATEDIFF(W.recordDate, A.recordDate) = 1
WHERE W.TEMPERATURE > A.TEMPERATURE;