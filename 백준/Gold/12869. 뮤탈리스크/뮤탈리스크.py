import sys

input = sys.stdin.readline
case = [[9,3,1],[9,1,3],[1,3,9],[1,9,3],[3,1,9],[3,9,1]]
def sol(x,y,z,idx):
    if dp[x][y][z] <= idx:
        return
    dp[x][y][z] = idx
    for i in case:
        nx = x - i[0] if x - i[0] >=0 else 0
        ny = y - i[1] if y - i[1] >=0 else 0
        nz = z - i[2] if z - i[2] >= 0 else 0
        sol(nx,ny,nz,idx+1)




N = int(input())

scv = list(map(int,input().split()))
while len(scv) < 3:
    scv.append(0)
dp = [[[987654] * (scv[2]+1) for _ in range(scv[1] + 1)] for _ in range(scv[0] + 1)]
sol(scv[0],scv[1],scv[2],0)
print(dp[0][0][0])