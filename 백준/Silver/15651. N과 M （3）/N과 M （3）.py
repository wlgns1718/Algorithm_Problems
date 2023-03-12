import sys
input = sys.stdin.readline

def sol(N,M,idx,nums):
    if idx == M:
        for i in range(idx):
            print(nums[i],end=" ")
        return print()
    for i in range(1,N+1):
        nums[idx] = i
        sol(N,M,idx+1,nums)


N, M = map(int, input().split())
nums = [0]*M
sol(N,M,0,nums)