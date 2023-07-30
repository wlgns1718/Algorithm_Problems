import sys
input = sys.stdin.readline

N = int(input())

nums = list(map(int,input().split()))
nums.sort()
i = 0
j = N - 1
res1, res2 = nums[0], nums[N-1]
answer = abs(nums[0] + nums[N-1])
while i < j:
    if abs(nums[i] + nums[j]) <= answer:
        res1 = nums[i]
        res2 = nums[j]
        answer = abs(nums[i] + nums[j])
        if nums[i] + nums[j] > 0:
            j -= 1
        else:
            i += 1
    elif abs(nums[i] + nums[j]) > answer:
        if nums[i] + nums[j] > 0:
            j -= 1
        else:
            i += 1
print(res1,res2)