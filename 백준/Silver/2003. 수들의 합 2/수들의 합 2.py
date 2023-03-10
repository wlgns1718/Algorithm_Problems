import sys
input = sys.stdin.readline

N, M = map(int,input().split())
nums = list(map(int,input().split()))
i = 0
j = 0
num_sum = 0
answer = 0
while True:
    if num_sum == 0:
        j = i
    if num_sum >= M:
        if num_sum == M:
            answer += 1
        num_sum -= nums[j]
        j += 1
        continue
    if i ==N:
        break
    num_sum += nums[i]
    i += 1
print(answer)