import sys
input = sys.stdin.readline
answer = 0
N = int(input())
nums = [0]*1001
time = []
for _ in range(N):
    a,b = map(int,input().split())
    time.append([a,b])
    for i in range(a,b):
        nums[i] += 1
for i in range(N):
    total = 0
    temp = [p for p in nums]
    t = time[i]
    for j in range(t[0], t[1]):
        temp[j]-=1
    cnt = 0
    for j in temp:
        if j>=1:
            cnt += 1
        else:
            total += cnt
            cnt = 0
    if answer < total:
        answer = total
print(answer)