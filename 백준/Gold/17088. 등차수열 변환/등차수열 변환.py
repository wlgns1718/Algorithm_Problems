import sys

input = sys.stdin.readline

def sol(cur,K):
    #K로 등차 수열이 되는지 판단
    cnt = 0
    for i in number[1:]:
        if i - cur == K:
            cur = i
            continue
        if i - cur == K + 1:
            cnt += 1
            cur = i - 1
        elif i - cur == K - 1:
            cnt += 1
            cur = i + 1
        else:
            return False
    return cnt
N = int(input())

number = list(map(int,input().split()))
if len(number) == 1:
    print(0)
else:
    #K가 될 수 있는 수 찾기
    k = number[1]-number[0]
    case = [k-2, k-1, k, k+1, k+2]
    start = [number[0]-1, number[0],number[0]+1]
    answer = 987654321
    for i in case:
        for j in start:
            temp = sol(j,i)
            if temp is False:
                continue
            temp += abs(j - number[0])
            if answer > temp :
                answer = temp
    if answer == 987654321:
        print(-1)
    else:
        print(answer)