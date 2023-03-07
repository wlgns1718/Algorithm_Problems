T = int(input())

arr = list(map(int,input().split()))
ans = 0
for i in arr:
    if i ==1:
        continue
    for j in range(2,i//2+1):
        if i % j !=0:
            continue
        else:
            break
    else:
        ans += 1
print(ans)