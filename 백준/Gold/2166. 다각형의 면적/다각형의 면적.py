import sys
input = sys.stdin.readline

N = int(input())
answer = 0
ls = [list(map(int,input().split())) for _ in range(N)]
ls.append(ls[0])
x = 0
y = 0
for i in range(N):
    x += ls[i][0] * ls[i+1][1]
    y += ls[i][1] * ls[i+1][0]
print(round(abs(x-y)/2,1))