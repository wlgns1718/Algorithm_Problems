import sys

input = sys.stdin.readline

N, M = map(int, input().split())
ls = [i for i in range(1, N+1)]

for _ in range(M):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    temp = ls[a]
    ls[a] = ls[b]
    ls[b] = temp
print(*ls)