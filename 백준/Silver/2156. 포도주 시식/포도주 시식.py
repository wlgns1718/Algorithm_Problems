import sys
input = sys.stdin.readline
n = int(input())
dp = [0 for _ in range(n+1)]
wine = [0]
for i in range(n):
    wine.append(int(input()))
if n == 1:
    print(wine[1])
elif n == 2:
    print(wine[1]+wine[2])
else:
    dp[1] = wine[1]
    dp[2] = wine[1] + wine[2]
    for i in range(3, n+1):
        dp[i] = max(wine[i]+wine[i-1]+dp[i-3], wine[i]+dp[i-2], dp[i-1])
    print(dp[n])