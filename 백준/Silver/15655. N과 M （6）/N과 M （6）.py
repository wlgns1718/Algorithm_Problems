import sys
input = sys.stdin.readline

def sol(N,M,idx,nums,select,num,start):
    if idx == M:
        for i in range(M):
            print(num[i],end=" ")
        return print()
    for i in range(start,N):
        if select[i] == True:
            continue
        select[i] = True
        num[idx] = nums[i]
        sol(N,M,idx+1,nums,select,num,i+1)
        select[i] = False


N, M = map(int, input().split())
nums = list(map(int,input().split()))
nums.sort()
num = [0]*M
select = [False]*N
sol(N,M,0,nums,select,num,0)