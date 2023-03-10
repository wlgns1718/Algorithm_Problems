import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int,input().split()))
nums.sort()
x = int(input())
answer = 0
i = 0
j = N - 1
while i < j:
    if nums[i] + nums[j] == x:
        answer += 1
        if nums[i] == nums[i+1]:
            i +=1
        elif nums[j] == nums[j-1]:
            j -= 1
        else:
            i += 1
    elif nums[i] + nums[j]>x:
        j -= 1
    else:
        i += 1
print(answer)