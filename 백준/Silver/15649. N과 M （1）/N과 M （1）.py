import sys
input = sys.stdin.readline

def sol(select,idx,M,N,nums):
    if idx == M:
        for i in range(M):
                print(nums[i],end=" ")
        return print()
    for i in range(1,N+1):
        if select[i] == True:
            continue
        select[i] = True
        nums[idx] = i
        sol(select,idx+1,M,N,nums)
        select[i] = False

N, M = map(int, input().split())
select = [False]*(N+1)
nums = [0]*(N+1)
sol(select,0,M,N,nums)