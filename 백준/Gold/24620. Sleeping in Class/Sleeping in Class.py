def sol(num,N,arr):
    res = 0
    for i in range(N):
        if res > num:
            return False
        res += arr[i]
        if res ==num:
            res = 0
    return True




T = int(input())

for _ in range(T):
    total,max_val = 0, 0
    N = int(input())
    arr = list(map(int,input().split()))
    if len(set(arr)) ==0:
        print(0)
        continue
    for i in arr:
        total+=i
        if max_val < i:
            max_val = i
    answer = 0
    for i in range(max(1,max_val), total+1):
        if total % i == 0 and sol(i,N,arr):
            answer = N - total//i
            break
    print(answer)