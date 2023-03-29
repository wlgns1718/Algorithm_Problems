import sys

input = sys.stdin.readline

N = int(input())
N //= 4
for i in range(N+1):
    if i == N:
        print("int")
        break
    print("long",end=" ")