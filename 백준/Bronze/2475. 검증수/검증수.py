import sys

input = sys.stdin.readline

nums = list(map(int,input().split()))
temp = 0
for i in nums:
    temp += (i*i)
answer = temp%10
print(answer)