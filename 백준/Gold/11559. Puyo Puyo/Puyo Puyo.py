import sys
from collections import deque

input = sys.stdin.readline


def down():
    global check
    for i in range(10, -1, -1):
        for j in range(6):
            if puyo[i][j] != '.' and puyo[i+1][j] == '.': #밑으로 내리기
                check = True
                temp_row = i + 1
                while temp_row < 12 and puyo[temp_row][j] == '.':
                    puyo[temp_row][j] = puyo[temp_row-1][j]
                    puyo[temp_row-1][j] = '.'
                    temp_row += 1

def delete():
    global answer, tri
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    queue = deque()
    for i in range(12):
        for j in range(6):
            if puyo[i][j] == '.':
                continue
            visit = set()
            shape = puyo[i][j]
            visit.add((i,j))
            queue.append([i,j])
            while queue:
                x, y = queue.popleft()
                for idx in range(4):
                    nx = x + dx[idx]
                    ny = y + dy[idx]
                    #범위 체크
                    if nx < 0 or ny < 0 or nx >= 12 or ny >= 6: continue
                    #방문체크
                    if (nx,ny) in visit: continue
                    #같은 모양인지 체크
                    if puyo[nx][ny] == shape:
                        queue.append([nx,ny])
                        visit.add((nx,ny))
            #블록 4개이상 붙었는지 확인
            if len(visit) >= 4:
                tri = True
                for v in visit:
                    row, col = v[0], v[1]
                    puyo[row][col] = '.'


def print_puyo():
    for i in range(12):
        print(puyo[i])
    print("-----------------------------")


puyo = []
for _ in range(12):
    puyo.append(list(input().strip()))

check = True
tri = True

answer = 0
while check:
    check = False
    tri = False
    delete()
    down()
    if tri:
        answer += 1
print(answer)
