import sys
input = sys.stdin.readline

def sol(N,M,idx,nums,num,start):
    if idx == M:
        for i in range(M):
            print(num[i],end=" ")
        return print()
    for i in range(start,N):
        num[idx] = nums[i]
        sol(N,M,idx+1,nums,num,i)


N, M = map(int, input().split())
nums = list(map(int,input().split()))
nums.sort()
num = [0]*M
sol(N,M,0,nums,num,0)