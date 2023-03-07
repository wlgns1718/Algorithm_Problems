import sys

def solution(start, end):
    i = 1
    res = 0
    while True:
        if res == 0:
            start += 1
            if start == end:
                return 1
            end -= 1
            res += 2
            if start == end:
                return 2
            continue
        a, b, c = i - 1, i, i + 1
        if start + c < end - c:
            i = c
            start += c
            end -= c
            res += 2

        else:
            if (start + c) >= end:
                return res + 1
            else:
                return res+2
            
N = int(sys.stdin.readline())
for _ in range(N):
    start , end = map(int, sys.stdin.readline().split())
    print(solution(start,end))
            
            