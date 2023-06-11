import sys

from collections import deque

input = sys.stdin.readline
queue = deque()

a, b = map(int,input().split())
matrix = []
for j in range(b):
    temp = input().strip()
    matrix.append([])
    for i in range(len(temp)):
        matrix[j].append(int(temp[i]))

matrix2 = [[a*b]*a for _ in range(b)]
matrix2[0][0] = 0

queue.append((0,0))
dx = [0,0,1,-1]
dy = [1,-1,0,0]
while queue:
    cur = queue.popleft()
    for idx in range(4):
        nx = cur[0] + dx[idx]
        ny = cur[1] + dy[idx]
        if nx < 0 or ny < 0 or nx >= b or ny >= a:
            continue
        if matrix[nx][ny] == 1:
            if matrix2[nx][ny] <= matrix2[cur[0]][cur[1]] + 1:
                continue
            else:
                matrix2[nx][ny] = matrix2[cur[0]][cur[1]]+1
                queue.append((nx,ny))
        else:
            if matrix2[nx][ny] <= matrix2[cur[0]][cur[1]]:
                continue
            else:
                matrix2[nx][ny] = matrix2[cur[0]][cur[1]]
                queue.append((nx, ny))



print(matrix2[b-1][a-1])