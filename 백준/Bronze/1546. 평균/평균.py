import sys

input = sys.stdin.readline

N = int(input())

nums = list(map(int,input().split()))
max_num = max(nums)
temp = 0
for i in nums:
    temp += i*100/max_num
print(temp/N)