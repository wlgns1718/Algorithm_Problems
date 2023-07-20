import sys

input  = sys.stdin.readline
answer = 0
def bruteforce(idx):
    global answer
    if idx == N:
        temp = 0
        for i in range(1,N):
            temp += abs(case[i-1]-case[i])
        if answer < temp:
            answer = temp
    for i in range(N):
        if select[i] : continue
        case[idx] = number[i]
        select[i] = True
        bruteforce(idx+1)
        select[i] = False


N = int(input())

number = list(map(int,input().split()))

case = [0] * N
select = [False] * N
bruteforce(0)
print(answer)