import sys

input = sys.stdin.readline

p = input().strip()
d = input().strip()
if(d in p):
    print("go")
else:
    print("no")