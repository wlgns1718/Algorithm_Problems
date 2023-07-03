import sys

input = sys.stdin.readline

N, K = map(int,input().split())
sol = [[0]*201 for _ in range(201)]

for i in range(1,201):
    sol[i][1] = 1
    sol[1][i] = i
for i in range(2,201):
    for j in range(2,201):
        sol[i][j] = sol[i-1][j] + sol[i][j-1]
print(sol[N][K]%1000000000)