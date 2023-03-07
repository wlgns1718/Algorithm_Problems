import sys

N = int(sys.stdin.readline())
stair = []
for _ in range(N):
    stair.append(int(input()))
dp= [0]*(N)
dp[0] = stair[0]
if N >= 2:
    dp[1] = stair[0]+stair[1]
if N >= 3:
    dp[2] = max(stair[2]+stair[1],stair[2]+stair[0])
for i in range(3,N):
    dp[i] = max(stair[i]+dp[i-2],stair[i]+stair[i-1]+dp[i-3])
print(dp[-1])