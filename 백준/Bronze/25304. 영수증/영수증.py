import sys
input = sys.stdin.readline

total = int(input())
N = int(input())
answer = 0
for _ in range(N):
    a, b = map(int, input().split())
    answer += (a*b)
if answer == total:
    print("Yes")
else:
    print("No")