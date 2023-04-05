import sys

input = sys.stdin.readline

N = int(input())
ls = []
dp = [0] * (N+2)
for i in range(N):
    a,b = map(int,input().split())
    ls.append([a,b])

for i in range(N,-1,-1):
    t = ls[i-1][0]
    w = ls[i-1][1]
    if t+i>N+1:
        dp[i] = dp[i+1]
    else:
        dp[i] = max(dp[i+1],w+dp[i+t])
print(dp[1])