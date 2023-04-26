from collections import deque
import sys
input = sys.stdin.readline

def bfs(start):
    Q = deque()
    Q.append(start)
    while Q:
        si,sj = Q.popleft()
        visited.add((si,sj))
        for i in range(4):
            ni = si + di[i]
            nj = sj + dj[i]
            if ni < 0 or ni >= M or nj < 0 or nj >= N : continue
            if (ni,nj) in visited : continue
            if farm[ni][nj] == 0 :continue
            Q.append((ni,nj))
            visited.add((ni,nj))


T= int(input())
di = [-1,1,0,0]
dj = [0,0,-1,1]
for tc in range(T):
    N,M,P = map(int,input().split())
    farm = [[0]*N for _ in range(M)]
    visited = set()
    moo = []
    for i in range(P):
        a,b = map(int,input().split())
        farm[b][a] = 1
        moo.append((b,a))
    check = 1
    for k in moo:
        i,j = k
        if (i,j) in visited:
            continue
        bfs((i,j))
        check += 1
    print(check-1)