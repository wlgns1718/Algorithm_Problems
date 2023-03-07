import sys

N = int(sys.stdin.readline())
for _ in range(N):
    a, b = map(int, sys.stdin.readline().split())
    u, d = 1, 1
    for i in range(0,a):
        u *= (b-i)
        d *= (i+1)
    print(u//d)