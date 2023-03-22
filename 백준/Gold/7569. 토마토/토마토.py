import sys
from collections import deque
input = sys.stdin.readline

def sol(queue,visit):
    answer = 0
    dh = [1,-1,0,0,0,0]
    dx = [0,0,1,-1,0,0]
    dy = [0,0,0,0,1,-1]
    while queue:
        for i in range(len(queue)):
            cur_point = queue.popleft()
            h = cur_point[0]
            x = cur_point[1]
            y = cur_point[2]
            for idx in range(6):
                nh = h + dh[idx]
                nx = x + dx[idx]
                ny = y + dy[idx]
                if nh < 0 or nh>=H or nx<0 or nx>=N or ny < 0 or ny >=M:
                    continue
                if (nh,nx,ny) in visit:
                    continue
                if box[nh][nx][ny] == -1 or box[nh][nx][ny] == 1:
                    continue
                box[nh][nx][ny] = 1
                visit.add((nh,nx,ny))
                queue.append([nh,nx,ny])
        if queue:
            answer += 1
    for h in range(H):
        for i in range(N):
            for j in range(M):
                if box[h][i][j] == 0:
                    return -1
    return answer
M, N, H = map(int,input().split())
box = []
visit = set()
queue = deque()
zero= 0
for i in range(H):
    temp = [list(map(int,input().split())) for _ in range(N)]
    for p in range(N):
        for q in range(M):
            if temp[p][q] == 1:
                queue.append([i,p,q])
                visit.add((i,p,q))
            elif temp[p][q]==0:
                zero += 1
    box.append(temp)
if zero==0:
    print(0)
else:
    print(sol(queue,visit))