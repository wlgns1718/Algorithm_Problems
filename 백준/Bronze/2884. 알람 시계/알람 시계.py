import sys

input = sys.stdin.readline
a,b = map(int,input().split())

if b-45>=0:
    print(a, b-45)
else:
    if a == 0:
        a = 23
        b = b-45+60
    else:
        b = b-45+60
        a -=1
    print(a,b)