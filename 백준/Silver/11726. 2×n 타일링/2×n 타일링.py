import sys
input = sys.stdin.readline

dp = [0] *2
dp[0] = 1
dp[1] = 2

N = int(input())

for i in range(2,N):
    dp[i%2] = dp[0] + dp[1]
if N ==1:
    print(1)
else:
    print(max(dp)%10007)