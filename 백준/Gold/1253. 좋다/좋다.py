import sys

input = sys.stdin.readline

def sol(newList,num):
    #num되면 return
    start = 0
    end = len(newList) - 1
    while start < end:
        a = newList[start] + newList[end]
        if a > num:
            end -= 1
        elif a < num:
            start += 1
        elif a == num:
            return 1
    return 0

N = int(input())

number = list(map(int,input().split()))
number.sort()
answer = 0
if len(number) <= 2:
    print(0)
else:
    for i in range(N):
        new = number[:i] + number[i+1:]
        answer += sol(new,number[i])

    print(answer)