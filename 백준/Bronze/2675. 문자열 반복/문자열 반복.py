import sys

input = sys.stdin.readline

N = int(input())
for _ in range(N):
    a,b = map(str,input().split())
    answer = ""
    for i in b:
        answer += i*int(a)
    print(answer)