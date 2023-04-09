import sys
from collections import deque

def bfs(queue,visit):
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]

    while queue:
        cur = queue.popleft()
        for idx in range(4):
            nx = cur[0]+dx[idx]
            ny = cur[1] + dy[idx]
            if nx == N-1 and ny == M-1:
                return cur[2] + 1
                
            if nx < 0 or ny < 0 or nx >= N or ny >= M: continue
            if ls[nx][ny] == 0: continue
            if (nx,ny) in visit: continue
            queue.append([nx,ny,cur[2]+1])
            visit.add((nx,ny))

input = sys.stdin.readline
N, M = map(int,input().split())

ls =[[0] * M for _ in range(N)]
for i in range(N):
    temp = input().rstrip()
    for j in range(M):
        ls[i][j] = int(temp[j])
queue = deque()
visit = set()
queue.append([0,0,1])
visit.add((0,0))
print(bfs(queue,visit))
