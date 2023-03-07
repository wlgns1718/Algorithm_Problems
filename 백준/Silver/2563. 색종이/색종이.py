import sys

input = sys.stdin.readline
n = int(input())
arr = [list(map(int,input().split())) for _ in range(n)]
squre = [[0]*100 for _ in range(100)]
for i in arr:
    x,y = i[0],i[1]
    for w in range(x,x+10):
        for h in range(y,y+10):
            squre[w][h] = 1
print(sum(sum(squre,[])))