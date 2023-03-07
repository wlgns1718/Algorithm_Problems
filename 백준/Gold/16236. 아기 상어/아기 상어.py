import sys
from collections import deque
input = sys.stdin.readline

def bfs(cur):
    visit = set()
    queue = deque()
    queue.append([cur[0],cur[1],0])
    visit.add((cur[0],cur[1]))
    dx = [1,-1,0,0]
    dy = [0,0,1,-1]
    can_eat = []
    while queue:
        cur_point = queue.popleft()
        for i in range(4):
            nx = cur_point[0] + dx[i]
            ny = cur_point[1] + dy[i]
            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue
            if (nx,ny) in visit : continue
            if matrix[nx][ny] > size:
                continue
            queue.append([nx,ny,cur_point[2]+1])
            visit.add((nx,ny))
            if matrix[nx][ny] < size and matrix[nx][ny] != 0:
                can_eat.append([nx,ny,cur_point[2] + 1])

    can_eat.sort(key= lambda x : (x[2],x[0],x[1]))
    return can_eat

N = int(input())
matrix = [list(map(int,input().split())) for _ in range(N)]
cur = [0,0]
for i in range(N):
    for j in range(N):
        if matrix[i][j] == 9:
            cur[0] = i
            cur[1] = j
feed = 0
size = 2
answer = 0
while True:
    temp = bfs(cur)
    if not temp:
        break
    feed += 1
    if feed == size:
        size += 1
        feed = 0
    eat = temp.pop(0)
    answer += eat[2]
    matrix[cur[0]][cur[1]] = 0
    cur[0] = eat[0]
    cur[1] = eat[1]
    matrix[eat[0]][eat[1]] = 9
print(answer)
