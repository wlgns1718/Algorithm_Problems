import sys

input = sys.stdin.readline

def sol(cnt,answer,select):
    if cnt==N+1:
        temp = ""
        for i in range(N+1):
            temp += str(nums[i])

        if int(temp) > int(answer[1]):
            answer[1] = temp
        if int(temp) < int(answer[0]):
            answer[0] = temp
        return
    for i in range(10):
        if select[i] == True:
            continue
        if cnt == 0:
            nums[cnt] = i
            select[i] = True
            sol(cnt+1,answer,select)
            select[i] = False
            continue
        else:
            if ls[cnt-1] == ">":
                if nums[cnt-1] < i:
                    continue
                nums[cnt] = i
                select[i] = True
                sol(cnt+1,answer,select)
                select[i] = False
            elif ls[cnt-1]=="<":
                if nums[cnt-1] > i:
                    continue
                nums[cnt] = i
                select[i] = True
                sol(cnt + 1, answer,select)
                select[i] = False




N = int(input())
answer = [9999999999,0]

ls = list(map(str,input().split()))
nums = [0]*(N+1)
select = [False] * 10
sol(0,answer,select)
print(answer[1],answer[0])