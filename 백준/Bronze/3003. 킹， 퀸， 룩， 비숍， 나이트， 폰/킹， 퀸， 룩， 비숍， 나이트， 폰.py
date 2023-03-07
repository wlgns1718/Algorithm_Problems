IN = list(map(int,input().split()))
OUT = [1,1,2,2,2,8]
res = []
for i in range(len(OUT)):
    res.append(OUT[i]-IN[i])
result = ' '.join(map(str,res))
print(result)