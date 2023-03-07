N = int(input())
dp = [[0]*10 for _ in range(N+1)]

for i in range(1,10): #1한자리수 초기화
    dp[1][i] = 1
mod = 1000000000#결과값 나눌 수
for i in range(2,N+1):#총 자릿수
    for j in range(10):
        if j == 0:
            dp[i][j] = dp[i-1][1]
        elif j == 9:
            dp[i][j] = dp[i-1][8]
        else:
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]
print(sum(dp[N]) % mod)
    