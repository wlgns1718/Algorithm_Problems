import sys

input = sys.stdin.readline

a, b = map(int, input().split())
c = int(input())

b += c
d = 0
if b >= 60:
    d = (int) (b / 60)
    b -= (d * 60)
a += d
if a >= 24:
    a %= 24
print(a, b)