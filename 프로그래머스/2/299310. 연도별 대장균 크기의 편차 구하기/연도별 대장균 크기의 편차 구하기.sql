-- 코드를 작성해주세요
WITH MAX_VAL AS
(
    SELECT MAX(SIZE_OF_COLONY) `SIZE`, YEAR(DIFFERENTIATION_DATE) `DATE`
    FROM ECOLI_DATA
    GROUP BY YEAR(DIFFERENTIATION_DATE)
)

SELECT YEAR(ED.DIFFERENTIATION_DATE) `YEAR`,
MV.SIZE - ED.SIZE_OF_COLONY `YEAR_DEV`,
ED.ID `ID`
FROM ECOLI_DATA ED, MAX_VAL MV
WHERE YEAR(ED.DIFFERENTIATION_DATE) = MV.DATE
ORDER BY `YEAR` ASC, `YEAR_DEV` ASC