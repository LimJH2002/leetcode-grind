SELECT W2.ID
FROM WEATHER W1
JOIN WEATHER W2 
ON W1.RECORDDATE = W2.RECORDDATE - 1
WHERE W2.TEMPERATURE > W1.TEMPERATURE