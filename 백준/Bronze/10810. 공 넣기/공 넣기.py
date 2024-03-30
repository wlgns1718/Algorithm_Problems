import sys

input = sys.stdin.readline

N, M = map(int, input().split())
ls = [0] * N
for _ in range(M):
    a, b, c = map(int, input().split())
    a -= 1
    b -= 1
    for i in range(a, b+1):
        ls[i] = c
print(*ls)