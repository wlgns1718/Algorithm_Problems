import sys

input = sys.stdin.readline

N,M = map(int,input().split())

answer = 1000000000 * 1000000000 + 1

start = 0

time = []
for _ in range(N):
    time.append(int(input()))

while start <= answer:
    temp = 0
    mid = (start+answer) // 2
    for i in range(N):
        temp += mid // time[i]
    if temp >= M:
        answer = mid - 1
    else:
        start = mid + 1
print(answer+1)