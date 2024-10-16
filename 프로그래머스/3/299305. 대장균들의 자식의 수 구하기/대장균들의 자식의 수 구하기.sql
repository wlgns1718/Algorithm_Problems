WITH INFO AS(
SELECT
    PARENT_ID, COUNT(*) `COUNT`
FROM ECOLI_DATA
GROUP BY PARENT_ID
HAVING PARENT_ID IS NOT NULL
)
-- 코드를 작성해주세요

SELECT E.ID, IF(I.COUNT IS NULL, 0, I.COUNT) AS CHILD_COUNT
FROM ECOLI_DATA E LEFT JOIN INFO I
ON E.ID = I.PARENT_ID
ORDER BY E.ID ASC
