import sys

input = sys.stdin.readline

def check_col(x,y):
    #열로 K개가 있는지 확인
    temp = 0
    while x < N:

        if farm[x][y] != 1:
            return False
        x += 1
        temp += 1
        if temp == K:
            return True
    return False

def check_row(x,y):
    #횡으로 K개가 있는지 확인
    temp = 0
    while y < M:

        if farm[x][y] != 1:
            return False
        y += 1
        temp += 1
        if temp == K:
            return True
    return False
N, M, K = map(int,input().split())
start = []
visit = set()
answer = []
farm = [list(map(int,input().split())) for _ in range(N)]
cnt = 0
for i in range(N):
    for j in range(M):
        if farm[i][j] == 0:
            continue
        cnt += 1
        if check_col(i,j):
            start.append([i,j,"col"])
        if check_row(i,j):
            start.append([i,j,"row"])
if cnt == K * 2:
    print(0)
else:
    if len(start) == 1:
        if start[0][2] == 'col':
            for i in range(K):
                answer.append([start[0][0]+i,start[0][1]])
        else:
            for i in range(K):
                answer.append([start[0][0],start[0][1]+i])
    else:

        for i in start:
            if i[2] == 'col':
                for j in range(K):
                    if (i[0]+j, i[1]) in visit:
                        answer.append([i[0]+j,i[1]])
                    visit.add((i[0]+j,i[1]))
            else:
                for j in range(K):
                    if (i[0], i[1]+j) in visit:
                        answer.append([i[0], i[1]+j])
                    visit.add((i[0], i[1]+j))
    answer.sort(key=lambda x:(x[0],x[1]))
    print(len(answer))
    for i in answer:
        print(i[0]+1, i[1]+1)