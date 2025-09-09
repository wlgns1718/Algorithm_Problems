import sys

input = sys.stdin.readline
ls = list(map(int, input().split(" ")))
ls.sort()
print(*ls)