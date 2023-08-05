-- 코드를 입력하세요
SELECT MONTH(START_DATE) `MONTH`,CAR_ID, COUNT(*) `RECORD`
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE (DATE_FORMAT(START_DATE,"%Y-%m") BETWEEN "2022-08" AND "2022-10")
AND CAR_ID IN 
(
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE DATE_FORMAT(START_DATE,"%Y-%m") BETWEEN "2022-08" AND "2022-10"
    GROUP BY CAR_ID
    HAVING COUNT(*) >= 5
)
GROUP BY CAR_ID, `MONTH`
HAVING `RECORD` > 0
ORDER BY `MONTH`, CAR_ID DESC