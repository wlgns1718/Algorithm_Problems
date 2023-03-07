import sys

input = sys.stdin.readline

x,y,w,h = map(int,input().split())

answer = min(x,y,h-y,w-x)
print(answer)