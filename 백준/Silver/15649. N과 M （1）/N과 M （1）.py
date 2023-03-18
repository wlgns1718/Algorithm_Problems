import sys

input = sys.stdin.readline

def sol(idx,select):
    if idx == M:
        for i in range(M):
            print(nums[i],end=" ")
        return print()

    for i in range(1,N+1):
        if select[i] == True:
            continue
        nums[idx] = i
        select[i] = True
        sol(idx+1,select)
        select[i] = False

N, M = map(int,input().split())

nums = [0]*M
select = [False] * (N+1)
sol(0,select)