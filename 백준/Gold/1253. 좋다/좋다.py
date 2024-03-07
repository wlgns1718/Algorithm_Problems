import sys
input = sys.stdin.readline

def sol(val, arr):
    global N, nums, count

    start = 0
    end = len(arr) - 1
    while start < end:
        a = arr[start] + arr[end]
        if a < val:
            start += 1
        elif a > val:
            end -= 1
        else:
            count += 1
            return

N = int(input())
nums = list(map(int, input().split()))
nums.sort()
count = 0
for idx, val in enumerate(nums):
    sol(val, nums[0:idx] + nums[idx+1:])

print(count)