import sys

input = sys.stdin.readline
n = int(input())
s = input()
w=0
h=0
e=0
ans=0
for c in s:
    if c=="W":
        w+=1
    elif c=="H":
        h+=w
    elif c=="E":
        ans=(2*ans+e)%1000000007
        e+=h
print(ans)