import sys

input = sys.stdin.readline

def sol(idx,select,visit):
    if idx == N:
        temp = 0
        for i in range(N):
            if select[i] == False:
                continue
            temp += nums[i]
        visit.add(temp)
        return
    select[idx] = True
    sol(idx+1,select,visit)
    select[idx] = False
    sol(idx+1, select, visit)
    return
N = int(input())

select = [False] * N
visit = set()
nums = list(map(int,input().split()))

sol(0,select,visit)
i = 1
while True:
    if i not in visit:
        print(i)
        break
    i += 1