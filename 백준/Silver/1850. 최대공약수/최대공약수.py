def sol(a,b):
    while True:
        temp = a
        a = b
        b = temp%b
        if b==0:
            return a

import sys

input = sys.stdin.readline

a, b = map(int,input().split())

if b>a:
    a,b = b,a
print('1' * sol(a,b))