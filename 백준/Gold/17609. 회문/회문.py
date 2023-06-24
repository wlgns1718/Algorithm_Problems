import sys

input = sys.stdin.readline

def sol(pali):
    ls = list(pali)
    start = 0
    end = len(ls) - 1
    temp = 0
    while start <= end:
        if temp >= 2:
            return 2
        if ls[start] == ls[end]:
            start += 1
            end -= 1
            continue
        else:
            temp += 1
            start += 1
    return temp
def sol2(pali):
    ls = list(pali)
    start = 0
    end = len(ls) - 1
    temp = 0
    while start <= end:
        if temp >= 2:
            return 2
        if ls[start] == ls[end]:
            start += 1
            end -= 1
            continue
        else:
            temp += 1
            end -= 1
    return temp
N = int(input())

for _ in range(N):
    pali = input().strip()
    print(min(sol(pali),sol2(pali)))