-- 코드를 작성해주세요
WITH FRONT_END as 
(
    SELECT sum(CODE)
    FROM SKILLCODES
    where CATEGORY = "FRONT End"
)


SELECT CASE
    WHEN SKILL_CODE & (SELECT * FROM FRONT_END) AND
    SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'Python')
    THEN 'A'
    WHEN SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'C#')
    THEN 'B'
    WHEN SKILL_CODE & (SELECT * FROM FRONT_END)
    THEN 'C'
    END AS GRADE, ID, EMAIL
FROM DEVELOPERS
GROUP BY GRADE, ID, EMAIL
HAVING GRADE IS NOT NULL
ORDER BY GRADE, ID, EMAIL