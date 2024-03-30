import copy
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
ls = [i for i in range(1,N+1)]
ls_temp = copy.deepcopy(ls)
for _ in range(M):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    for i in range(a, b+1):
        ls[i] = ls_temp[a + b - i]
    ls_temp = copy.deepcopy(ls)
print(*ls)