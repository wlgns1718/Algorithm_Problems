import sys

input = sys.stdin.readline

n = int(input())

dp = [1]

for i in range(n + 1):
    dp.append(0)
    for j in range(i):
        dp[i] += (dp[j] * dp[i - j - 1])
        
print(dp[n])
        
        