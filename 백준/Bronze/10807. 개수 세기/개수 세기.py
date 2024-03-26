import sys

input = sys.stdin.readline

n = int(input())
ls = list(map(int, input().split()))
answer = 0
target = int(input())
for i in ls:
    if i == target:
        answer += 1
print(answer)