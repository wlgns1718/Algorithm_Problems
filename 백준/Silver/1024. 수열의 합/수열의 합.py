import sys


def cal(N, L):
    temp = 0
    cnt = 0
    for i in range(L, 102):  # i는 배열 길이
        temp = (N / i) - ((i - 1) / 2)
        if temp < 0 or i > 100:
            return temp, -1
        if temp.is_integer():
            temp = int(temp)
            cnt = i
            return temp, cnt
        


N, L = map(int, sys.stdin.readline().split(" "))
a,b = cal(N, L)
if b == -1:
    print(-1)
else:
    for i in range(b):
        print(a+i,end=' ')