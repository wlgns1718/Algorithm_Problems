import sys

input = sys.stdin.readline
N = int(input())

for _ in range(N):
    temp = input()
    idx = 0
    answer = 0
    for i in temp:
        if i == 'O':
            idx +=1
        elif i=='X':
            for i in range(idx+1):
                answer += i
                idx = 0
    for i in range(idx+1):
        answer += i
    print(answer)