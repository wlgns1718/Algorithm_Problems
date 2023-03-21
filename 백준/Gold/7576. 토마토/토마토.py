import sys
input = sys.stdin.readline
from collections import deque
answer = 0
queue = deque()

M,N = map(int,input().split())
dx = [0,0,1,-1]
dy = [1,-1,0,0]
box = [list(map(int,input().split())) for _ in range(N)]
visit = set()
zero_cnt = 0
for i in range(N):
    for j in range(M):
        if box[i][j] == 1:
            queue.append([i,j])
            visit.add((i,j))
        elif box[i][j] == 0:
            zero_cnt += 1
if zero_cnt == 0:
    print(0)
else:
    while queue:
        for _ in range(len(queue)):
            cur_point = queue.popleft()
            x = cur_point[0]
            y = cur_point[1]
            for idx in range(4):
                nx = x+dx[idx]
                ny = y+dy[idx]
                if nx < 0 or nx >= N or ny < 0 or ny >= M:
                    continue
                if box[nx][ny] == -1 or box[nx][ny] == 1 or (nx,ny) in visit:
                    continue
                box[nx][ny] = 1
                queue.append([nx,ny])
                visit.add((nx,ny))
        if queue:
            answer += 1
    for i in range(N):
        for j in range(M):
            if box[i][j] == 0:
                answer = -1
                break
    print(answer)