#카탈란 수

import sys
input = sys.stdin.readline

N = int(input()) + 1
if N == 0 or N == 1:
    print(1)
else:
    temp = 2 * N
    down = 1
    answer = 1
    div = 1
    for i in range(0, N):
        answer *= temp
        down *= (i+1)
        if answer % down == 0:
            answer //= down
            down = 1
        temp -= 1
    answer //= down
    print(answer // (N + 1))