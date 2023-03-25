import sys
input = sys.stdin.readline

def dust():#미세먼지 이동
    direct = [[-1,0],[1,0],[0,-1],[0,1]] # 상 하 좌 우
    amount = [[0] * c for _ in range(r)]
    for i in range(r):
        for j in range(c):
            if not (matrix[i][j] == 0 or matrix[i][j] == -1):
                cnt = 0
                for dx, dy in direct:
                    nx, ny = i + dx, j + dy
                    if nx < 0 or nx >= r or ny < 0 or ny >= c: continue
                    if [nx,ny] in clean: continue
                    cnt += 1
                    amount[nx][ny] += matrix[i][j] // 5
                matrix[i][j] = matrix[i][j] - (matrix[i][j]//5 * cnt)
    for i in range(r):
        for j in range(c):
            matrix[i][j] += amount[i][j]
    return

def clean_up():
    direct = [[0,1],[-1,0],[0,-1],[1,0]]
    tri = 0
    x, y = clean[0]
    start, y = x, 1
    pre = 0
    while True:
        nx, ny = x+direct[tri][0], y + direct[tri][1]
        if x == start and  y == 0:#원래자리로 오면 종료
            break
        if nx < 0 or nx >= r or ny < 0 or ny >= c:#범위 체크
            tri += 1
            continue
        matrix[x][y], pre = pre, matrix[x][y]
        x, y = nx, ny
    return
def clean_down():
    direct = [[0,1],[1,0],[0,-1],[-1,0]]
    tri = 0
    x, y = clean[1]
    start, y = x, 1
    pre = 0
    while True:
        nx, ny = x+direct[tri][0], y+direct[tri][1]
        if x == start and y==0:#원래자리로 오면 종료
            break
        if nx < 0 or nx >= r or ny < 0 or ny >= c:#범위 체크
            tri += 1
            continue
        matrix[x][y], pre = pre, matrix[x][y]
        x,y = nx, ny
    return

r, c, t = map(int, input().split())
matrix, clean = [],[]

for i in range(r):
    matrix.append(list(map(int,input().split())))
    for j in range(len(matrix[i])):
        #공기청정기위치
        if matrix[i][j] == -1:
            clean.append([i,j])
for _ in range(t):
    dust()
    clean_up()
    clean_down()

answer = 0
for i in range(r):
    for j in range(c):
        if matrix[i][j] > 0:
            answer += matrix[i][j]
print(answer)