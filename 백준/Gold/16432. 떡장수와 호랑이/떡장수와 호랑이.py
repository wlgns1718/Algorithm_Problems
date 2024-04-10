import sys
sys.setrecursionlimit(10**9)

input = sys.stdin.readline

def sol(idx,ls):
    global tri

    if tri:
        return
    if idx == N:
        for i in ls:
            print(i)
        tri = True
        return

    if idx == 0:
        for i in dduck[idx]:
            visit[idx][i] = True
            ls[idx] = i
            sol(idx+1,ls)
    else:
        for i in dduck[idx]:
            if not visit[idx][i] and ls[idx-1] != i:
                visit[idx][i] = True
                ls[idx] = i
                sol(idx+1,ls)



N = int(input())

visit = [[False]*10 for _ in range(N)]

tri = False
dduck = []
answer = [0]*N
for _ in range(N):
    temp = list(map(int, input().split()))[1:]
    dduck.append(temp)
sol(0,answer)

if not tri:
    print(-1)