import sys
input = sys.stdin.readline

def sol1(select,chicken,idx,M,start,answer):
    if idx == M:
        return sol2(select,answer)
    for i in range(start,len(chicken)):
        select[i] = True
        temp = sol1(select,chicken,idx+1,M,i+1,answer)
        if answer > temp:
            answer = temp
        select[i] = False
    return answer
def sol2(select,answer):
    res = 0
    for i in home:
        temp = float("INF")
        for j in range(len(select)):
            if select[j] == False:
                continue
            x = abs(i[0]-chicken[j][0])
            y = abs(i[1]-chicken[j][1])
            if temp > (x+y):
                temp = x+y
        res += temp
    return res if res < answer else answer

N,M = map(int,input().split())

chicken = []
matrix = []
home = []
for i in range(N):
    matrix.append(list(map(int,input().split())))
    for j in range(N):
        if matrix[i][j] == 2:
            chicken.append([i,j])
        if matrix[i][j] == 1:
            home.append([i,j])

answer = float("INF")

if M > len(chicken):
    select = [True] * len(chicken)
    print(sol2(select))
else:
    select = [False] * len(chicken)
    print(sol1(select,chicken,0,M,0,answer))