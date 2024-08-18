import sys

input = sys.stdin.readline

l, r, t = map(int,input().split())

if abs(l-r) > t:
    print((min(l, r) + t) * 2)
else:
    t -= abs(l-r)
    print((max(l, r) + t // 2) * 2)