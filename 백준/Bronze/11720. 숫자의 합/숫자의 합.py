import sys

input = sys.stdin.readline

N = int(input())

nums = list(map(str,input().strip()))
answer = 0
for i in nums:
    answer += int(i)
print(answer)