import sys
from collections import deque
def zero(farm, queue):
    while queue:
        p = queue.popleft()
        x = p[0]#N
        y = p[1]#M
        if x+1<N  and farm[x+1][y] == 1:
            queue.append((x+1,y))
            farm[x+1][y] = 0
        if y+1<M and farm[x][y+1] == 1:
            queue.append((x,y+1))
            farm[x][y+1] = 0
        if x-1>=0 and farm[x-1][y]==1:
            queue.append((x-1,y))
            farm[x-1][y]=0
        if y-1>=0 and farm[x][y-1]==1:
            queue.append((x,y-1))
            farm[x][y-1]=0
input = sys.stdin.readline
T = int(input())
for _ in range(T):
    queue = deque()
    answer = 0
    M, N, K = map(int,input().split(" "))
    farm = [[0 for _ in range(M)] for _ in range(N)]
    for _ in range(K):# 어디에 배추가 심어져 있는지
        x,y = map(int,input().split(' '))#1,0
        farm[y][x] = 1
    for i in range(N):
        for j in range(M):
            if farm[i][j] == 1:
                farm[i][j] = 0
                answer += 1
                queue.append((i,j))
                zero(farm,queue)
    print(answer)