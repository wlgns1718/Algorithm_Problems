import sys

input = sys.stdin.readline


def sol(idx,nums,select,visit):
    if idx==M:
        temp = ""
        for i in range(idx):
            temp += str(nums[i])+","
        if temp in visit:
            return
        for i in range(idx):
            print(nums[i],end=" ")
        visit.add(temp)
        return print()
    for i in range(N):
        if select[i] == True:
            continue
        select[i] = True
        nums[idx] = ls[i]
        sol(idx+1, nums,select,visit)
        select[i] = False

N, M = map(int,input().split())

ls = list(map(int,input().split()))
ls.sort()
select = [False]*N
nums = [0]*M
visit = set()
sol(0,nums,select,visit)